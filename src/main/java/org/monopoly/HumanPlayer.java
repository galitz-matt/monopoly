package org.monopoly;

public class HumanPlayer implements Player {
    private final String name;
    private Tile currentTile;
    private int balance;
    private boolean isInJail;

    public HumanPlayer(String name, Tile startingTile) {
        this.name = name;
        this.currentTile = startingTile;
        this.balance = 1500;
        this.isInJail = false;
    }

    public String getName() {
        return name;
    }
    public Tile getCurrentTile() {
        return currentTile;
    }
    public int getBalance() {
        return balance;
    }
    public void charge(int amount) {
        //TODO: account for if balance < amount
    }
    public void give(int amount) {
        balance += amount;
    }

    public void movePlayerTo(Tile destination) {
        currentTile = destination;
    }
    public boolean isInJail() {
        return isInJail;
    }
}
