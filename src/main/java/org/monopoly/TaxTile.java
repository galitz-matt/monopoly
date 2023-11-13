package org.monopoly;

public class TaxTile implements Tile {
    private final String id;
    private final String name;
    private final int tax;

    public TaxTile(String id, String name, int tax) {
        this.id = id;
        this.name = name;
        this.tax = tax;
    }

    public void interact(Player player) {
        System.out.printf("""
                You landed on: %s
                You must pay %s
                """, name, tax);
        player.charge(tax);
        System.out.printf("Current Balance: %d\n", player.getBalance());
    }

    public String ID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int Tax() {
        return tax;
    }
}
