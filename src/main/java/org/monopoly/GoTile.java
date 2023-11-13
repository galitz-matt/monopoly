package org.monopoly;

public class GoTile implements Tile {

    public void interact(Player player) {
        //TODO: Give 200 to player if passed
    }

    public String ID() {
        return "go";
    }

    public String getName() { return "Go"; }

    public int getPosition() { return 0; }
}
