package org.monopoly;

public class CardBuilder {

    private String id;
    private String prompt;
    private Action action;
    private int amount;
    public Card build() {
        return new Card(id, prompt, action, amount);
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setAmount(int amount) { this.amount = amount; }
}
