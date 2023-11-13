package org.monopoly;

public class CommunityChestTile implements Tile {
    private final String id;

    public CommunityChestTile(String id) {
        this.id = id;
    }
    public void interact(Player player) {
        //TODO: draw card and do action
    }

    public String ID() {
        return id;
    }
}
