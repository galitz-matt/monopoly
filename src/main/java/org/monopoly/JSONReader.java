package org.monopoly;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JSONReader {
    private final JSONObject jsonRoot = getJSONRoot();

    private JSONObject getJSONRoot() {
        try (var bufferedReader = new BufferedReader(new FileReader("AllTiles.json"))) {
            var fileContent = bufferedReader.lines().collect(Collectors.joining("\n"));
            return new JSONObject(fileContent);
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public List<String> getOrderedTileIDs() {
        var tilesIDsRoot = jsonRoot.getJSONArray("tiles");
        var tileIDs = new ArrayList<String>();
        for (int i = 0; i < tilesIDsRoot.length(); i++) {
            var tileID = tilesIDsRoot.getJSONObject(i).get("id").toString();
            tileIDs.add(tileID);
        }
        return tileIDs;
    }

    public Map<String, Property> getAllProperties() {
        var properties = new HashMap<String, Property>();
        var rawProperties = jsonRoot.getJSONArray("properties");
        for (int i = 0; i < rawProperties.length(); i++) {
            var rawProperty = rawProperties.getJSONObject(0);

        }
        return properties;
    }
}
