package org.monopoly;

public class CommunityChestTile implements Tile {
    private final String id;
    private final int position;
    private static final CommunityChest communityChest = CommunityChest.getInstance();

    public CommunityChestTile(String id, int position) {
        this.id = id;
        this.position = position;
    }
    public void interact(Player player) {
        System.out.printf("""
                Current position %s
                Drawing card...
                """, StringStylist.bold(getName()));
        var card = communityChest.drawCard();
        System.out.printf("Your card says: %s\n", card.getPrompt());
        card.interact(player);
    }

    public String ID() {
        return id;
    }

    public String getName() { return "Community Chest"; }

    public int getPosition() { return position; }
}
