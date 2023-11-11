package org.monopoly;

public class CommunityChestCard implements Card {

    private final String id;
    private final String prompt;
    private final Action action;

    public CommunityChestCard(String id, String prompt, Action action) {
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
