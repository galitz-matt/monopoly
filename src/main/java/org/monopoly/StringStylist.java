package org.monopoly;

public class StringStylist {
    public static String bold(String string) {
        return "\u001B[1m" + string + "\u001B[0m";
    }

    public static String italic(String string) {
        return "\u001B[3m" + string + "\u001B[0m";
    }
}
