package org.monopoly;

public interface Player {

    String getName();

    void moveTo(Tile destination);

    Tile getCurrentTile();

    int getPosition();

    int getBalance();

    void charge(int amount);

    void give(int amount);

    boolean isInJail();
}
