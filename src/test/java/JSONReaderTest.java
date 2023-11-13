import org.monopoly.JSONReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JSONReaderTest {

    private static JSONReader jsonReader;

    @BeforeAll
    public static void setup() {
        jsonReader = new JSONReader();
    }
    @Test
    public void getAllProperties() {
        var properties = jsonReader.getPropertyTiles();
        properties.forEach((id,property) -> System.out.println(id));
    }

    @Test
    public void getOrderedTilesByIDTest() {
        var tileIDs = jsonReader.getOrderedIDs();
        System.out.println(tileIDs);
    }

    @Test
    public void getCards_chance_test() {
        var chanceCards = jsonReader.getCards("chance");
        System.out.println(chanceCards);
    }

    @Test
    public void getCards_communityChest_test() {
        var communityChestCards = jsonReader.getCards("communitychest");
        System.out.println(communityChestCards);
    }

    @Test
    public void getNonPropertyTiles_test() {
        var nonPropertyTiles = jsonReader.getNonPropertyTiles();
    }
}
