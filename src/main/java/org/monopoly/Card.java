package org.monopoly;

public class Card {

    private final Tile tile;
    private final String prompt;
    private final Action action;
    private final int amount;

    public Card(Tile tile, String prompt, Action action, int amount) {
        this.tile = tile;
        this.prompt = prompt;
        this.action = action;
        this.amount = amount;
    }
    public Tile moveToTile() {
        return tile;
    }

    public String getPrompt() {
        return prompt;
    }

    public Action getAction() {
        return action;
    }

    public int getAmount() {
        return amount;
    }

    public void interact(Player player) {
        switch (action) {
            case MOVE:

        }
    }
}
