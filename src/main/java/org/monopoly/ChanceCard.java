package org.monopoly;

public class ChanceCard {

    private final String prompt;
    private final Action action;
    private final Integer amount;

    public ChanceCard(String prompt, Action action, int amount) {
        this.prompt = prompt;
        this.action = action;
        this.amount = amount;
    }

    public ChanceCard(String prompt, Action action) {
        this.prompt = prompt;
        this.action = action;
        this.amount = null;
    }

    public Action getAction() {
        return action;
    }

}
