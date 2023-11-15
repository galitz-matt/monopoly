package org.monopoly;

import java.util.Map;
import java.util.HashMap;

public class JailTile implements Tile {
    public void interact(Player player) {
        System.out.printf("""
                Current Tile: %s
                """, StringStylist.bold("Jail"));
    }

    public String ID() {
        return "jail";
    }

    public String getName() { return "Jail"; }

    public int getPosition() { return 10; }
}
