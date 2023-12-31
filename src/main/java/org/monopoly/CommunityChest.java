package org.monopoly;

import java.util.List;
import java.util.Collections;

public class CommunityChest {
    private static CommunityChest instance;
    private final List<Card> deck;
    private int draws = 0;
    private final int DECK_SIZE = 16;

    private CommunityChest() {
        deck = new JSONReader().getCards("communitychest");
    }

    public static CommunityChest getInstance() {
        if (instance == null) {
            instance = new CommunityChest();
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
