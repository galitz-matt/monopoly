package org.monopoly;

public class Card {

    private final String id;
    private final String prompt;
    private final Action action;
    private final int amount;

    public Card(String id, String prompt, Action action, int amount) {
        this.id = id;
        this.prompt = prompt;
        this.action = action;
        this.amount = amount;
    }
    public String ID() {
        return id;
    }
    public String getPrompt() {
        return prompt;
    }
    public Action getAction() {
        return action;
    }

    public int getAmount() {
        return amount;
    }
}
