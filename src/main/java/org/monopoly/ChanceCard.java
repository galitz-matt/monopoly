package org.monopoly;

public class ChanceCard implements Card {

    private String id;
    private String prompt;
    private Action action;

    public ChanceCard(String id, String prompt, Action action) {
        this.id = id;
        this.prompt = prompt;
        this.action = action;
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
}
