public class Color {
    // ANSI colors
    public static String reset = "\u001B[0m";
    public static String white = "\u001B[37m"; // White
    public static String blue = "\u001B[34m"; // Blue
    public static String green = "\u001B[32m"; // Green
    public static String red = "\u001B[31m"; // Red
    public static String black = "\u001B[30m"; // Black
    public static String yellow = "\u001B[33m"; // Yellow
    public static String purple = "\u001B[35m"; // Purple
    public static String cyan = "\u001B[36m"; // Cyan
    // Bright text colors
    public static String brightBlack = "\u001B[90m";
    public static String brightRed = "\u001B[91m";
    public static String brightGreen = "\u001B[92m";
    public static String brightYellow = "\u001B[93m";
    public static String brightBlue = "\u001B[94m";
    public static String brightPurple = "\u001B[95m";
    public static String brightCyan = "\u001B[96m";
    public static String brightWhite = "\u001B[97m";
    // ANSI background colors
    public static String blackBackground = "\u001B[40m";
    public static String redBackground = "\u001B[41m";
    public static String greenBackground = "\u001B[42m";
    public static String yellowBackground = "\u001B[43m";
    public static String blueBackground = "\u001B[44m";
    public static String purpleBackground = "\u001B[45m";
    public static String cyanBackground = "\u001B[46m";
    public static String whiteBackground = "\u001B[47m";
    // Bright background colors
    public static String brightBlackBackground = "\u001B[100m";
    public static String brightRedBackground = "\u001B[101m";
    public static String brightGreenBackground = "\u001B[102m";
    public static String brightYellowBackground = "\u001B[103m";
    public static String brightBlueBackground = "\u001B[104m";
    public static String brightPurpleBackground = "\u001B[105m";
    public static String brightCyanBackground = "\u001B[106m";
    public static String brightWhiteBackground = "\u001B[107m";
    // ANSI text styles
    public static String bold = "\u001B[1m";
    public static String underline = "\u001B[4m";
    public static String inverted = "\u001B[7m";
    public static String invisible = "\u001B[8m";

    public static String colorText(String color, String text) {
        return color + text + reset;
    }

    public static String white(String text) {
        return colorText(white, text);
    }

    public static String blue(String text) {
        return colorText(blue, text);
    }

    public static String green(String text) {
        return colorText(green, text);
    }

    public static String red(String text) {
        return colorText(red, text);
    }

    public static String black(String text) {
        return colorText(black, text);
    }

    public static String yellow(String text) {
        return colorText(yellow, text);
    }

    public static String purple(String text) {
        return colorText(purple, text);
    }

    public static String cyan(String text) {
        return colorText(cyan, text);
    }

    // Bright text colors
    public static String brightBlack(String text) {
        return colorText(brightBlack, text);
    }

    public static String brightRed(String text) {
        return colorText(brightRed, text);
    }

    public static String brightGreen(String text) {
        return colorText(brightGreen, text);
    }

    public static String brightYellow(String text) {
        return colorText(brightYellow, text);
    }

    public static String brightBlue(String text) {
        return colorText(brightBlue, text);
    }

    public static String brightPurple(String text) {
        return colorText(brightPurple, text);
    }

    public static String brightCyan(String text) {
        return colorText(brightCyan, text);
    }

    public static String brightWhite(String text) {
        return colorText(brightWhite, text);
    }

    // ANSI background colors
    public static String blackBackground(String text) {
        return colorText(blackBackground, text);
    }

    public static String redBackground(String text) {
        return colorText(redBackground, text);
    }

    public static String greenBackground(String text) {
        return colorText(greenBackground, text);
    }

    public static String yellowBackground(String text) {
        return colorText(yellowBackground, text);
    }

    public static String blueBackground(String text) {
        return colorText(blueBackground, text);
    }

    public static String purpleBackground(String text) {
        return colorText(purpleBackground, text);
    }

    public static String cyanBackground(String text) {
        return colorText(cyanBackground, text);
    }

    public static String whiteBackground(String text) {
        return colorText(whiteBackground, text);
    }

    // Bright background colors
    public static String brightBlackBackground(String text) {
        return colorText(brightBlackBackground, text);
    }

    public static String brightRedBackground(String text) {
        return colorText(brightRedBackground, text);
    }

    public static String brightGreenBackground(String text) {
        return colorText(brightGreenBackground, text);
    }

    public static String brightYellowBackground(String text) {
        return colorText(brightYellowBackground, text);
    }

    public static String brightBlueBackground(String text) {
        return colorText(brightBlueBackground, text);
    }

    public static String brightPurpleBackground(String text) {
        return colorText(brightPurpleBackground, text);
    }

    public static String brightCyanBackground(String text) {
        return colorText(brightCyanBackground, text);
    }

    public static String brightWhiteBackground(String text) {
        return colorText(brightWhiteBackground, text);
    }

    // ANSI text styles
    public static String bold(String text) {
        return colorText(bold, text);
    }

    public static String underlined(String text) {
        return colorText(underline, text);
    }

    public static String inverted(String text) {
        return colorText(inverted, text);
    }

    public static String invisible(String text) {
        return colorText(invisible, text);
    }
}