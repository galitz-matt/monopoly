package org.monopoly;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.Function;

import static org.monopoly.PropertyType.*;
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
        return IntStream.range(0, tilesIDsRoot.length())
                .mapToObj(i -> tilesIDsRoot.getJSONObject(i).getString("id"))
                .collect(Collectors.toList());
    }

    public Map<String, Property> getAllProperties() {
        var rawProperties = jsonRoot.getJSONArray("properties");
        return IntStream.range(0, rawProperties.length())
                .mapToObj(i -> buildProperty(rawProperties.getJSONObject(i)))
                .collect(Collectors.toMap(Property::ID, Function.identity()));
    }

    private Property buildProperty(JSONObject rawProperty) {
        var propertyBuilder = new PropertyBuilder();
        propertyBuilder.setID(rawProperty.getString("id"));
        propertyBuilder.setName(rawProperty.getString("name"));
        propertyBuilder.setPropertyType(parseType(rawProperty.getString("group")));
        var price = rawProperty.getInt("price");
        propertyBuilder.setPrice(price);
        propertyBuilder.setMortgageValue(price / 2);
        var rent = parseRentList(rawProperty.getInt("rent"), rawProperty.getJSONArray("multipliedrent"));
        propertyBuilder.setRentList(rent);
        propertyBuilder.setBuildCost(rawProperty.getInt("housecost"));
        return propertyBuilder.getProperty();
    }

    private PropertyType parseType(String group) {
        return switch (group) {
            case "purple" -> BROWN;
            case "lightgreen" -> GRAY;
            case "Violet" -> PINK;
            case "Orange" -> ORANGE;
            case "Red" -> RED;
            case "Yellow" -> YELLOW;
            case "darkgreen" -> GREEN;
            case "darkblue" -> BLUE;
            case "Utilities" -> UTILITY;
            case "Railroad" -> RAILROAD;
            default -> null;
        };
    }

    private List<Integer> parseRentList(int rent, JSONArray multipliedRent) {
        var rentList = new ArrayList<>(List.of(rent));
        rentList.addAll(IntStream.range(0, multipliedRent.length())
                .mapToObj(multipliedRent::getInt)
                .toList());
        return rentList;
    }
}
