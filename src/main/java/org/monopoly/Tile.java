package org.monopoly;

public interface Tile {
    void interact(Player player);
    String ID();
    int getPosition();
}
