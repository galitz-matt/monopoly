package org.monopoly;

public class PropertyTile implements Tile {
    private final String id;
    private final Property property;
    private final int position;

    public PropertyTile(String id, Property property, int position) {
        this.id = id;
        this.property = property;
        this.position = position;
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

    public int getPosition() { return position; }

    public String getName() {
        return property.getName();
    }

    public int getPrice() {
        return property.getPrice();
    }
}
