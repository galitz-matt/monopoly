package org.monopoly;

public class PropertyTile implements Tile {
    private final String id;
    private final Property property;

    public PropertyTile(String id, Property property) {
        this.id = id;
        this.property = property;
    }
    public void interact(Player player) {
        //TODO: buy or auction
    }

    public String ID() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public String getName() {
        return property.getName();
    }

    public int getPrice() {
        return property.getPrice();
    }
}
