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
import static org.monopoly.Action.*;
public class JSONReader {
    private final JSONObject jsonRoot;

    public JSONReader() {
        this.jsonRoot = getJSONRoot();
    }

    private JSONObject getJSONRoot() {
        try (var bufferedReader = new BufferedReader(new FileReader("C:\\Users\\16097\\Documents\\projects\\monopoly\\src\\main\\resources\\AllTiles.json"))) {
            var fileContent = bufferedReader.lines().collect(Collectors.joining("\n"));
            return new JSONObject(fileContent);
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public List<String> getOrderedIDs() {
        var tilesIDsRoot = jsonRoot.getJSONArray("tiles");
        return IntStream.range(0, tilesIDsRoot.length())
                .mapToObj(i -> tilesIDsRoot.getJSONObject(i).getString("id"))
                .collect(Collectors.toList());
    }

    public Map<String, Tile> getAllTiles() {
        var tiles = getPropertyTiles();
        tiles.putAll(getNonPropertyTiles());
        return tiles;
    }

    public Map<String, Tile> getPropertyTiles() {
        var rawProperties = jsonRoot.getJSONArray("properties");
        return IntStream.range(0, rawProperties.length())
                .mapToObj(i -> buildPropertyTile(rawProperties.getJSONObject(i)))
                .collect(Collectors.toMap(Tile::ID, Function.identity()));
    }

    public List<Card> getCards(String cardType) {
        var rawCards = jsonRoot.getJSONArray(cardType);
        return new ArrayList<>(IntStream.range(0, rawCards.length())
                .mapToObj(i -> buildCard(rawCards.getJSONObject(i)))
                .toList());
    }

    public Map<String, Tile> getNonPropertyTiles() {
        var rawTiles = jsonRoot.getJSONArray("otherTiles");
        return IntStream.range(0, rawTiles.length())
                .mapToObj(i -> buildNonPropertyTile(rawTiles.getJSONObject(i)))
                .collect(Collectors.toMap(Tile::ID, Function.identity()));
    }

    private Tile buildPropertyTile(JSONObject rawProperty) {
        var propertyBuilder = new PropertyBuilder();
        propertyBuilder.setID(rawProperty.getString("id"));
        propertyBuilder.setName(rawProperty.getString("name"));
        propertyBuilder.setPropertyType(parseType(rawProperty.getString("group")));
        var price = rawProperty.getInt("price");
        propertyBuilder.setPrice(price);
        propertyBuilder.setMortgageValue(price / 2);
        var rent = parseRentList(rawProperty.getJSONArray("rent"));
        propertyBuilder.setRentList(rent);
        propertyBuilder.setBuildCost(rawProperty.getInt("housecost"));
        var property = propertyBuilder.build();
        return new PropertyTile(property.ID(), property, rawProperty.getInt("position"));
    }

    private Tile buildNonPropertyTile(JSONObject rawTile) {
        var tileFactory = new TileFactory();
        return tileFactory.getTile(rawTile);
    }

    private PropertyType parseType(String rawType) {
        return switch (rawType) {
            case "purple" -> BROWN;
            case "lightgreen" -> GRAY;
            case "Violet" -> PINK;
            case "Orange" -> ORANGE;
            case "Red" -> RED;
            case "Yellow" -> YELLOW;
            case "darkgreen" -> GREEN;
            case "darkblue" -> BLUE;
            case "Utilities", "utility" -> UTILITY;
            case "Railroad", "railroad" -> RAILROAD;
            default -> null;
        };
    }

    private List<Integer> parseRentList(JSONArray rent) {
        return new ArrayList<>(IntStream.range(0, rent.length())
                .mapToObj(rent::getInt)
                .toList());
    }

    private Card buildCard(JSONObject rawCard) {
        var cardBuilder = new CardBuilder();
        cardBuilder.setPrompt(rawCard.getString("title"));
        var action = parseAction(rawCard.getString("action"));
        cardBuilder.setAction(action);
        var tiles = getAllTiles();
        cardBuilder.setTile(rawCard.has("tileid") ? tiles.get(rawCard.getString("tileid")) : null);
        cardBuilder.setAmount(rawCard.has("amount") ? rawCard.getInt("amount") : 0);
        cardBuilder.setType(rawCard.has("groupid") ? parseType(rawCard.getString("groupid")) : null);
        return cardBuilder.build();
    }

    private Action parseAction(String rawAction) {
        return switch (rawAction) {
            case "move" -> MOVE;
            case "movenearest" -> MOVE_NEAREST;
            case "addfunds" -> COLLECT;
            case "jail" -> JAIL;
            case "propertycharges" -> PROPERTY_CHARGE;
            case "removefunds" -> CHARGE;
            case "removefundstoplayers" -> GIVE_TO_PLAYERS;
            case "getout" -> GET_OUT_OF_JAIL;
            case "addfundsfromplayers" -> GET_FROM_PLAYERS;
            default -> null;
        };
    }
}
