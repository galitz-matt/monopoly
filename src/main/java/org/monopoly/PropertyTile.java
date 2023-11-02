package org.monopoly;

public class PropertyTile implements Tile {

    private final Property property;
    private final String id;

    public PropertyTile(Property property, String id) {
        this.property = property;
        this.id = id;
    }
    public void interact(Player player) {
        //TODO: buy or auction
    }

    public String Id() {
        return id;
    }

}
