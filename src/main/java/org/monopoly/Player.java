package org.monopoly;

import java.util.List;

public interface Player {

    String getName();

    void movePlayerTo(Tile destination);

    Tile getCurrentTile();

    int getBalance();

    void charge(int amount);

    void give(int amount);

    boolean isInJail();
}
