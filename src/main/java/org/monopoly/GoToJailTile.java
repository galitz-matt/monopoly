package org.monopoly;

public class GoToJailTile implements Tile {

    public void interact(Player player) {
        //Send player to jail
    }

    public String Id() {
        return "gotojail";
    }

    public int getPosition() {
        return 30;
    }
}
