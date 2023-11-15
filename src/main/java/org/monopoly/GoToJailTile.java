package org.monopoly;

public class GoToJailTile implements Tile {

    public void interact(Player player) {

    }

    public String ID() {
        return "gotojail";
    }

    public String getName() { return "Go To Jail"; }

    public int getPosition() { return 30; }

    @Override
    public int findDistanceToTile(Tile tile) {
        return Tile.super.findDistanceToTile(tile);
    }
}
