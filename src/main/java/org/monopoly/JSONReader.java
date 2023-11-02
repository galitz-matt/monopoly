package org.monopoly;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JSONReader {

    private final String filePath = "C:\\Users\\16097\\Documents\\projects\\monopoly\\src\\main\\resources\\AllTiles.json";
    private final JSONObject jsonRoot = getJSONRoot();

    private JSONObject getJSONRoot() {
        try (var bufferedReader = new BufferedReader(new FileReader(filePath))) {
            var fileContent = bufferedReader.lines().collect(Collectors.joining("\n"));
            return new JSONObject(fileContent);
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public List<String> getOrderedTileIDs() {
        var tilesRoot = jsonRoot.getJSONArray("tiles");
        var tileIDs = new ArrayList<String>();
        for (int i = 0; i < tilesRoot.length(); i++) {
            var tileID = tilesRoot.getJSONObject(i).get("id").toString();
            tileIDs.add(tileID);
        }
        return tileIDs;
    }
}
