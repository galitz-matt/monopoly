package org.monopoly;

import java.util.List;

public interface Player {

    void movePlayerTo(Tile destination);
    Tile getCurrentTile();
    int getBalance();
    void charge(int amount);
    void give(int amount);
    boolean isInJail();
}
