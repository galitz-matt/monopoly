package org.monopoly;

import java.util.Map;
import java.util.HashMap;

public class JailTile implements Tile {

    private Map<Player, Integer> inmates;

    public JailTile() {
        inmates = new HashMap<>();
    }

    public void interact(Player player) {
        //TODO: if in Jail, attempt to roll doubles, release player if stayed 3 turns
    }

    public String ID() {
        return "jail";
    }

    public String getName() { return "Jail"; }

    public int getPosition() { return 10; }

    public void addInmate(Player player) {
        inmates.put(player, 0);
    }

    public void incrementTime(Player player) {
        inmates.put(player, inmates.get(player) + 1);
    }
}
