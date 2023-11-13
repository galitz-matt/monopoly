package org.monopoly;

import java.util.Scanner;

public class ChanceTile implements Tile {

    private static final Chance chance = Chance.getInstance();

    public void interact(Player player) {
    }

    public String ID() {
        return "chance";
    }
}
