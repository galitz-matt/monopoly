package org.monopoly;

import java.util.Collections;
import java.util.List;

public class Chance {
    private static Chance instance;
    private final List<Card> deck;
    private int draws = 0;
    private final int DECK_SIZE = 16;

    private Chance(JSONReader jsonReader) {
        deck = jsonReader.getCards("chance");
    }

    public static Chance getInstance() {
        if (instance == null) {
            instance = new Chance(new JSONReader());
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
