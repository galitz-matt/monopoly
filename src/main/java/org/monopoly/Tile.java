package org.monopoly;

public interface Tile {
    void interact(Player player);
    String ID();
    int getPosition();

    default int findDistanceToTile(Tile tile) {
        var rawDistance = Math.abs(getPosition() - tile.getPosition());
        return Math.min(rawDistance, 40 - rawDistance);
    }
}
