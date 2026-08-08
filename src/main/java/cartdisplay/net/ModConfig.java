package cartdisplay.net;

public class ModConfig {
    public static boolean enabled = true;
    public static ColorOption colorOption = ColorOption.LIGHT_PURPLE;

    public enum ColorOption {
        BLACK("Black", 0x555555, 0x000000),
        DARK_BLUE("Dark Blue", 0x0000AA, 0x000055),
        DARK_GREEN("Dark Green", 0x00AA00, 0x005500),
        DARK_AQUA("Dark Aqua", 0x00AAAA, 0x005555),
        DARK_RED("Dark Red", 0xAA0000, 0x550000),
        DARK_PURPLE("Dark Purple", 0xAA00AA, 0x550055),
        GOLD("Gold", 0xFFAA00, 0x996600),
        GRAY("Gray", 0xAAAAAA, 0x555555),
        DARK_GRAY("Dark Gray", 0x555555, 0x222222),
        BLUE("Blue", 0x5555FF, 0x0000AA),
        GREEN("Green", 0x55FF55, 0x00AA00),
        AQUA("Aqua", 0x55FFFF, 0x00AAAA),
        RED("Red", 0xFF5555, 0xAA0000),
        LIGHT_PURPLE("Light Purple", 0xFF55FF, 0xAA00AA),
        YELLOW("Yellow", 0xFFFF55, 0xAAAA00),
        WHITE("White", 0xFFFFFF, 0xAAAAAA);

        private final String name;
        private final int startHex;
        private final int endHex;

        ColorOption(String name, int startHex, int endHex) {
            this.name = name;
            this.startHex = startHex;
            this.endHex = endHex;
        }

        public String getName() {
            return name;
        }

        public int getStartHex() {
            return startHex;
        }

        public int getEndHex() {
            return endHex;
        }
    }
}