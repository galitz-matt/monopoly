package org.monopoly;

public class CommunityChestCard {

    private final String prompt;
    private final Action action;
    private final Integer amount;

    public CommunityChestCard(String prompt, Action action, int amount) {
        this.prompt = prompt;
        this.action = action;
        this.amount = amount;
    }

    public CommunityChestCard(String prompt, Action action) {
        this.prompt = prompt;
        this.action = action;
        this.amount = null;
    }
}
