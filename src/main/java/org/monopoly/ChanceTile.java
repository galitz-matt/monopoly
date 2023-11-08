package org.monopoly;

public class ChanceTile implements Tile {

    private final int position;

    public ChanceTile(int position) {
        this.position = position;
    }

    public void interact(Player player) {
        //TODO: draw card and do action
    }

    public String Id() {
        return "chance";
    }

    public int getPosition() {
        return position;
    }
}
