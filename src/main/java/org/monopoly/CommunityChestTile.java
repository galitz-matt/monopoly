package org.monopoly;

public class CommunityChestTile implements Tile {
    private final String id;
    private final int position;

    public CommunityChestTile(String id, int position) {
        this.id = id;
        this.position = position;
    }
    public void interact(Player player) {
        //TODO: draw card and do action
    }

    public String ID() {
        return id;
    }

    public String getName() { return "Community Chest"; }

    public int getPosition() { return position; }
}
