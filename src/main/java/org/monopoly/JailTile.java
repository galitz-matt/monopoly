package org.monopoly;

public class JailTile implements Tile {

    //TODO: Create inJail and JustVisiting List<Player> fields

    public void interact(Player player) {
        //TODO: if in Jail, attempt to roll doubles, release player if stayed 3 turns
    }

    public String Id() {
        return "jail";
    }

    public int getPosition() {
        return 10;
    }

    //TODO: Implement addToJail() and releaseFromJail() methods
}
