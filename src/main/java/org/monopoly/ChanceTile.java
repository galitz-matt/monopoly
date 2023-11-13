package org.monopoly;

import java.util.Scanner;

public class ChanceTile implements Tile {

    private final String id;
    private static final Chance chance = Chance.getInstance();

    public ChanceTile(String id) {
        this.id = id;
    }

    public void interact(Player player) {
    }

    public String ID() {
        return id;
    }

    public String getName() { return "Chance"; }
}
