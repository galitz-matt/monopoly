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
        System.out.printf("""
                Current position %s
                Drawing card...
                """, StringStylist.bold(getName()));
        var card = chance.drawCard();
        System.out.printf("Your card says: %s\n", card.getPrompt());

    }

    public String ID() {
        return id;
    }

    public String getName() { return "Chance"; }

    public int getPosition() { return position; }
}
