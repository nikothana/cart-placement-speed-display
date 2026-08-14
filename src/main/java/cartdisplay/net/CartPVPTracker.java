package cartdisplay.net;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class CartPVPTracker {

    public enum SequenceStage {
        IDLE, RAIL_PLACED, CART_PLACED, FLINT_USED
    }

    private SequenceStage currentStage = SequenceStage.IDLE;
    private long startTick = 0;
    private long lastActionTick = 0;
    private static final int TIMEOUT_TICKS = 100;

    public void onRailPlaced(long currentTick) {
        currentStage = SequenceStage.RAIL_PLACED;
        startTick = currentTick;
        lastActionTick = currentTick;
    }

    public void onCartPlaced(long currentTick) {
        if (currentStage == SequenceStage.RAIL_PLACED) {
            currentStage = SequenceStage.CART_PLACED;
            lastActionTick = currentTick;
        }
    }

    public void onFlintAndSteelUsed(long currentTick) {
        if (currentStage == SequenceStage.CART_PLACED) {
            currentStage = SequenceStage.FLINT_USED;
            lastActionTick = currentTick;
        }
    }

    public Long onCrossbowShot(long currentTick) {
        if (currentStage == SequenceStage.FLINT_USED) {
            long totalFrames = currentTick - startTick;
            reset();
            return totalFrames;
        }
        return null;
    }

    public void tick(long currentTick) {
        if (currentStage != SequenceStage.IDLE && (currentTick - lastActionTick > TIMEOUT_TICKS)) {
            reset();
        }
    }

    public void reset() {
        currentStage = SequenceStage.IDLE;
        startTick = 0;
        lastActionTick = 0;
    }

    public static void displayActionBar(PlayerEntity player, long frames) {
        if (!ModConfig.enabled) return;

        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(() -> {
            String frameString = frames + " Frames";
            MutableText frameText = Text.empty();

            ModConfig.ColorOption color = ModConfig.colorOption;

            int startHex = color.getStartHex();
            int endHex = color.getEndHex();

            int startR = (startHex >> 16) & 0xFF;
            int startG = (startHex >> 8) & 0xFF;
            int startB = startHex & 0xFF;

            int endR = (endHex >> 16) & 0xFF;
            int endG = (endHex >> 8) & 0xFF;
            int endB = endHex & 0xFF;

            int length = frameString.length();

            for (int i = 0; i < length; i++) {
                float ratio = (length > 1) ? (float) i / (length - 1) : 0;

                int r = (int) (startR + ratio * (endR - startR));
                int g = (int) (startG + ratio * (endG - startG));
                int b = (int) (startB + ratio * (endB - startB));

                int hexColor = (r << 16) | (g << 8) | b;

                frameText.append(Text.literal(String.valueOf(frameString.charAt(i)))
                        .styled(style -> style.withColor(hexColor).withBold(true)));
            }

            Text message = Text.literal("Cart Placement Speed: ")
                    .formatted(Formatting.GRAY)
                    .append(frameText);

            if (player != null) {
                player.sendMessage(message, true);
            }

            if (client.inGameHud != null) {
                client.inGameHud.setOverlayMessage(message, false);
            }
        });
    }
}