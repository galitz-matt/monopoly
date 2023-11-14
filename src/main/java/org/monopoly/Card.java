package org.monopoly;

import java.util.Scanner;

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
        // TODO: finish this and helpers
        var gameBoard = GameBoard.getInstance();
        switch (action) {
            case MOVE:
                player.moveTo(tile);
                break;
            case MOVE_NEAREST:
                var nearest = findNearest(player.getCurrentTile(), gameBoard);
                player.moveTo(nearest);
                break;
            case COLLECT:
                player.give(amount);
                break;
            case CHARGE:
                player.charge(amount);
                break;
            case PROPERTY_CHARGE:
                //TODO: charge per property, create AssetManager, read in values w/ JSONReader or BE LAZY
                break;
            case GIVE_TO_PLAYERS:
                //TODO: handle this, create Game singleton class, getPlayers method
                break;
            case GET_FROM_PLAYERS:
                //TODO: charge all players, create Game singleton class, getPlayers method
                break;
            case GET_OUT_OF_JAIL:
                //TODO: set hasGetOutOfJailCard to True, create AssetManager
                break;
            case JAIL:
                var jail = (JailTile) gameBoard.getTileAtPosition(10);
                player.moveTo(jail);
                player.setJailStatus(true);
                jail.addInmate(player);
                System.out.println("You are now in jail");
        }
    }

    private Tile findNearest(Tile tile, GameBoard gameBoard) {
        if (type.equals(UTILITY)) {
            var ecTile = gameBoard.getTileAtPosition(12);
            var wwTile = gameBoard.getTileAtPosition(28);
            var distanceToElectricCompany = tile.findDistanceToTile(ecTile);
            var distanceToWaterWorks = tile.findDistanceToTile(wwTile);

            if (distanceToElectricCompany < distanceToWaterWorks) {
                return ecTile;
            } else if (distanceToElectricCompany > distanceToWaterWorks) {
                return wwTile;
            } else {
                return askPlayerForTile(gameBoard);
            }
        }
        else {
            var nearestRRIndex = Math.floorDiv(tile.getPosition(), 10) * 10 + 5;
            return gameBoard.getTileAtPosition(nearestRRIndex);
        }
    }

    private Tile askPlayerForTile(GameBoard gameBoard) {
        var scanner = new Scanner(System.in);
        System.out.println("Move to Electric Company or Water Works? (Enter 1 for EC, 2 for WW)");
        String input = scanner.nextLine();
        while (!input.equals("1") && !input.equals("2")) {
            System.out.println("Enter a valid option please! (1 or 2)");
            input = scanner.nextLine();
        }
        return input.equals("1") ? gameBoard.getTileAtPosition(12) : gameBoard.getTileAtPosition(28);
    }

    public static void main(String[] args) {
        var card = new Card("prompt", Action.MOVE_NEAREST, null, 0, UTILITY);
        var player = new HumanPlayer("name", new GoTile());
        card.interact(player);
    }
}
