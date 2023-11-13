import org.monopoly.CommunityChest;
import org.monopoly.JSONReader;

import org.junit.jupiter.api.Test;
public class CommunityChestTest {
    @Test
    public void getCard() {
        var communityChest = CommunityChest.getInstance();
        var card = communityChest.drawCard();
        System.out.println(card.getPrompt());
    }

    @Test
    public void getAnotherCard() {
        System.out.println("DRAW ANOTHER");
        var communityChest = CommunityChest.getInstance();
        System.out.println(communityChest.drawCard().getPrompt() + "CARD 1 in 2nd Test");
    }
}
