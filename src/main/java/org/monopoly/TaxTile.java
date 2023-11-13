package org.monopoly;

public class TaxTile implements Tile {
    private final String id;
    private final int tax;

    public TaxTile(String id, int tax) {
        this.id = id;
        this.tax = tax;
    }

    public void interact(Player player) {
        //TODO: charge tax to player
    }

    public String ID() {
        return id;
    }
    public int Tax() {
        return tax;
    }
}
