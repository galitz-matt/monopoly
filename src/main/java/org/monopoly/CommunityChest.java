package org.monopoly;

import java.util.List;
import java.util.Collections;

public class CommunityChest {
    private static CommunityChest instance;
    private final List<Card> deck;
    private int draws;
    private int DECK_SIZE = 16;

    private CommunityChest(JSONReader jsonReader) {
        deck = jsonReader.getCards("communitychest");
        draws = 0;
    }

    public static CommunityChest getInstance() {
        if (instance == null) {
            instance = new CommunityChest(new JSONReader());
        }
        return instance;
    }

    public Card drawCard() {
        if (draws % DECK_SIZE == 0) {
            Collections.shuffle(deck);
        }
        draws++;
        return deck.get(draws % DECK_SIZE);
    }

}
