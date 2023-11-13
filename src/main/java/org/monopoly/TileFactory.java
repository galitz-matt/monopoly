package org.monopoly;

import org.json.JSONObject;

public class TileFactory {
    public Tile getTile(JSONObject rawTile) {
       return switch (rawTile.getString("id")) {
            case "go" -> new GoTile();
            case "incometax", "luxurytax" -> new TaxTile(rawTile.getString("id"), rawTile.getInt("tax"));
            case "jail" -> new JailTile();
            case "freeparking" -> new FreeParkingTile();
            case "communitychest" -> new CommunityChestTile();
            case "chance" -> new ChanceTile();
            case "gotojail" -> new GoToJailTile();
            default -> null;
       };
    }
}
