package org.monopoly;

import org.json.JSONObject;

public class TileFactory {
    public Tile getTile(JSONObject rawTile) {
        var ID = rawTile.getString("id");
        var position = rawTile.getInt("position");
        return switch (ID) {
            case "go" -> new GoTile();
            case "incometax", "luxurytax" -> new TaxTile(ID, rawTile.getString("name"), rawTile.getInt("tax"), position);
            case "jail" -> new JailTile();
            case "freeparking" -> new FreeParkingTile();
            case "communitychest1", "communitychest2", "communitychest3" -> new CommunityChestTile(ID, position);
            case "chance1", "chance2", "chance3" -> new ChanceTile(ID, position);
            case "gotojail" -> new GoToJailTile();
            default -> null;
       };
    }
}
