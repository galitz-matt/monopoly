package org.monopoly;

public class CardBuilder {
    private Tile tile;
    private String prompt;
    private Action action;
    private int amount;
    private PropertyType type;

    public Card build() {
        return new Card(prompt, action, tile, amount, type);
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setAmount(int amount) { this.amount = amount; }

    public void setType(PropertyType type) { this.type = type; }
}
