import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.monopoly.JSONReader;

public class JSONReaderTest {

    private static JSONReader jsonReader;

    @BeforeAll
    public static void setup() {
        jsonReader = new JSONReader();
    }
    @Test
    public void getAllProperties() {
        var properties = jsonReader.getAllProperties();
        properties.forEach((id,property) -> System.out.println(id));
    }

    @Test
    public void getOrderedTilesByIDTest() {
        var tileIDs = jsonReader.getOrderedTilesByIDs();
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
}
