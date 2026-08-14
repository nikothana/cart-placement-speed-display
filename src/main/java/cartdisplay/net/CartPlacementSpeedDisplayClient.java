package cartdisplay.net;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class CartPlacementSpeedDisplayClient implements ClientModInitializer {

    public static final CartPVPTracker TRACKER = new CartPVPTracker();

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null) {
                TRACKER.tick(client.world.getTime());
            }
        });

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient()) return ActionResult.PASS;

            ItemStack held = player.getStackInHand(hand);
            long currentTick = world.getTime();

            if (held.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractRailBlock) {
                TRACKER.onRailPlaced(currentTick);
            } else if (held.isOf(Items.TNT_MINECART)) {
                TRACKER.onCartPlaced(currentTick);
            } else if (held.isOf(Items.FLINT_AND_STEEL)) {
                TRACKER.onFlintAndSteelUsed(currentTick);
            }

            return ActionResult.PASS;
        });

        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient()) return ActionResult.PASS;

            ItemStack held = player.getStackInHand(hand);
            if (held.isOf(Items.TNT_MINECART)) {
                TRACKER.onCartPlaced(world.getTime());
            }

            return ActionResult.PASS;
        });

        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (!world.isClient()) return ActionResult.PASS;

            ItemStack stack = player.getStackInHand(hand);
            if (stack.isOf(Items.CROSSBOW) && CrossbowItem.isCharged(stack)) {
                long currentTick = world.getTime();
                Long framesElapsed = TRACKER.onCrossbowShot(currentTick);

                if (framesElapsed != null) {
                    // Record stats into Mod Menu integration
                    ModMenuIntegration.STATS.recordCombo(framesElapsed);

                    // Render action bar output
                    CartPVPTracker.displayActionBar(player, framesElapsed);
                }
            }
            return ActionResult.PASS;
        });
    }
}