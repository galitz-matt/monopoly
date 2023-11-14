package org.monopoly;

import static org.monopoly.PropertyType.UTILITY;
import static org.monopoly.PropertyType.RAILROAD;

public class Card {

    private final String prompt;
    private final Action action;
    private final int amount;
    private final Tile tile;
    private final PropertyType type;

    public Card(String prompt, Action action, Tile tile, int amount, PropertyType type) {
        this.tile = tile;
        this.prompt = prompt;
        this.action = action;
        this.amount = amount;
        this.type = type;
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

    public PropertyType getType() {
        return type;
    }

    public void interact(Player player) {
        switch (action) {
            case MOVE:
                player.moveTo(tile);
                break;
            case MOVE_NEAREST:
                f
        }
    }

    private Tile findNearest(int currentPosition, GameBoard gameBoard) {
        if (type == UTILITY) {
            var distanceToElectricCompany = Math.abs(currentPosition - 12);
            var distanceToWaterWorks = Math.abs(currentPosition - 28);
            if (distanceToElectricCompany < distanceToWaterWorks) {
                return gameBoard.getTileAtPosition(12);
            } else if (distanceToElectricCompany > distanceToWaterWorks) {
                return gameBoard.getTileAtPosition(28);
            } else {

            }

        }
    }
}
