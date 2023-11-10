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
    public void getAllPropertiesByIDTest() {
        var properties = jsonReader.getAllPropertiesByID();
        properties.forEach((id,property) -> System.out.println(id));
    }

    @Test
    public void getOrderedTilesByIDTest() {
        var tileIDs = jsonReader.getOrderedTilesByIDs();
        System.out.println(tileIDs);
    }
}
