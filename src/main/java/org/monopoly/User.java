package org.monopoly;

public class User implements Player {

    private String name;
    private Tile currentTile;
    private int balance;
    private boolean isInJail;
    //TODO: create property manager field

    public User(String name) {
        this.name = name;
        //TODO: set currentTile to first tile on GameBoard
        this.balance = 0;
    }
    public void movePlayerTo(Tile destinationTile) {
        currentTile = destinationTile;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public int getBalance() {
        return 0;
    }

    public void charge(int amount) {
        if (amount > balance) {
            //TODO: mortgage properties
            //TODO: in Game class, check if player is bankrupt, if so remove from Game
        }
        balance -= amount;
    }

    public void give(int amount) {
        balance += amount;
    }

    public boolean isInJail() {
        return isInJail;
    }
}
