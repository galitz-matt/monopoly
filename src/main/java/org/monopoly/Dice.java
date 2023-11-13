package org.monopoly;

import java.lang.Math;

public class Dice {
    public static int[] rollDice() {
        return new int[] {rollDie(), rollDie()};
    }

    private static int rollDie() {
        return (int) Math.floor((Math.random() * 6) + 1);
    }
}
