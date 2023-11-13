package org.monopoly;

import java.util.Scanner;

public class ChanceTile implements Tile {
    private final String id;
    private final int position;

    private static final Chance chance = Chance.getInstance();

    public ChanceTile(String id, int position) {
        this.id = id;
        this.position = position;
    }

    public void interact(Player player) {
    }

    public String ID() {
        return id;
    }

    public String getName() { return "Chance"; }

    public int getPosition() { return position; }
}
