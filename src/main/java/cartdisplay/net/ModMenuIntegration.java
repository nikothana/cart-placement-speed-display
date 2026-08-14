package cartdisplay.net;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ModMenuIntegration implements ModMenuApi {

    public static final StatsData STATS = new StatsData();

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.literal("Cart Placement Speed Display Config"));

            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // -----------------------------------------------------------
            // TAB 1: General Settings
            // -----------------------------------------------------------
            ConfigCategory general = builder.getOrCreateCategory(Text.literal("General"));

            general.addEntry(entryBuilder.startBooleanToggle(
                            Text.literal("Enable Display"), ModConfig.enabled)
                    .setDefaultValue(true)
                    .setTooltip(Text.literal("Toggles displaying the frame count on the action bar."))
                    .setSaveConsumer(newValue -> ModConfig.enabled = newValue)
                    .build());

            general.addEntry(entryBuilder.startEnumSelector(
                            Text.literal("Frames Text Color"),
                            ModConfig.ColorOption.class,
                            ModConfig.colorOption)
                    .setDefaultValue(ModConfig.ColorOption.LIGHT_PURPLE)
                    .setEnumNameProvider(option -> Text.literal(((ModConfig.ColorOption) option).getName()))
                    .setTooltip(Text.literal("Select the gradient color palette for the frames display."))
                    .setSaveConsumer(newValue -> ModConfig.colorOption = newValue)
                    .build());

            // -----------------------------------------------------------
            // TAB 2: Statistics
            // -----------------------------------------------------------
            ConfigCategory statsCategory = builder.getOrCreateCategory(Text.literal("Statistics"));

            String fastestText = (STATS.fastestFrames == Long.MAX_VALUE) ? "N/A" : STATS.fastestFrames + " Frames";
            String slowestText = (STATS.slowestFrames == 0) ? "N/A" : STATS.slowestFrames + " Frames";
            String avgText = String.format("%.1f Frames", STATS.getAverageFrames());

            statsCategory.addEntry(entryBuilder.startTextDescription(
                    Text.literal("Total CartPVP Combos: ").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(STATS.totalCombos)).formatted(Formatting.GOLD, Formatting.BOLD))
            ).build());

            statsCategory.addEntry(entryBuilder.startTextDescription(
                    Text.literal("Session Combos: ").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(STATS.sessionCombos)).formatted(Formatting.YELLOW))
            ).build());

            statsCategory.addEntry(entryBuilder.startTextDescription(
                    Text.literal("Fastest Cart Speed: ").formatted(Formatting.GRAY)
                            .append(Text.literal(fastestText).formatted(Formatting.GREEN, Formatting.BOLD))
            ).build());

            statsCategory.addEntry(entryBuilder.startTextDescription(
                    Text.literal("Slowest Cart Speed: ").formatted(Formatting.GRAY)
                            .append(Text.literal(slowestText).formatted(Formatting.RED))
            ).build());

            statsCategory.addEntry(entryBuilder.startTextDescription(
                    Text.literal("Average Cart Speed: ").formatted(Formatting.GRAY)
                            .append(Text.literal(avgText).formatted(Formatting.AQUA))
            ).build());

            statsCategory.addEntry(entryBuilder.startTextDescription(
                    Text.literal("Sub-10 Frame Combos: ").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(STATS.subTenCombos)).formatted(Formatting.LIGHT_PURPLE))
            ).build());

            statsCategory.addEntry(entryBuilder.startBooleanToggle(
                            Text.literal("Reset All Statistics"), false)
                    .setTooltip(Text.literal("Check this and save to clear all recorded combo timing stats."))
                    .setSaveConsumer(reset -> {
                        if (reset) {
                            STATS.reset();
                        }
                    })
                    .build());

            return builder.build();
        };
    }
}