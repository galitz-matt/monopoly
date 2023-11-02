package org.monopoly;

public class TaxTile implements Tile {

    private final String name;
    private final int tax;

    public TaxTile(String name, int tax) {
        this.name = name;
        this.tax = tax;
    }

    public void interact() {
        //TODO: charge tax to player
    }
}
