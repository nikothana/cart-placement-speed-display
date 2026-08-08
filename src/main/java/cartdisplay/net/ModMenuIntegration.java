package cartdisplay.net;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.literal("Cart Placement Speed Display Config"));

            ConfigCategory general = builder.getOrCreateCategory(Text.literal("General"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // Toggle for ON/OFF
            general.addEntry(entryBuilder.startBooleanToggle(
                            Text.literal("Enable Display"), ModConfig.enabled)
                    .setDefaultValue(true)
                    .setTooltip(Text.literal("Toggles displaying the frame count on the action bar."))
                    .setSaveConsumer(newValue -> ModConfig.enabled = newValue)
                    .build());

            // Color selection dropdown
            general.addEntry(entryBuilder.startEnumSelector(
                            Text.literal("Frames Text Color"),
                            ModConfig.ColorOption.class,
                            ModConfig.colorOption)
                    .setDefaultValue(ModConfig.ColorOption.LIGHT_PURPLE)
                    .setEnumNameProvider(option -> Text.literal(((ModConfig.ColorOption) option).getName()))
                    .setTooltip(Text.literal("Select the gradient color palette for the frames display."))
                    .setSaveConsumer(newValue -> ModConfig.colorOption = newValue)
                    .build());

            return builder.build();
        };
    }
}