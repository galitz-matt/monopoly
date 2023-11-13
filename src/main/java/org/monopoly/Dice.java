package org.monopoly;

import java.lang.Math;

public class Dice {
    public static int[] roll() {
        return new int[] {rollDice(), rollDice()};
    }

    private static int rollDice() {
        return (int) Math.floor((Math.random() * 6) + 1);
    }
}
