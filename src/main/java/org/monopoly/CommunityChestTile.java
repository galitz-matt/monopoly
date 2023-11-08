package org.monopoly;

public class CommunityChestTile implements Tile {

    private final int position;

    public CommunityChestTile(int position) {
        this.position = position;
    }

    public void interact(Player player) {
        //TODO: draw card and do action
    }

    public String Id() {
        return "communitychest";
    }

    public int getPosition() {
        return position;
    }

}
