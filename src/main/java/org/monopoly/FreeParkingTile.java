package org.monopoly;

public class FreeParkingTile implements Tile {

    public void interact(Player player) {
        System.out.println("Current Tile: Free Parking");
    }

    public String ID() {
        return "freeparking";
    }

    public int getPosition() {
        return 20;
    }
}
