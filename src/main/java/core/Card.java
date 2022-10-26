package core;

public class Card {
    private Global.CardTypes type;

    public Card(Global.CardTypes type) {
        this.type = type;
    }

    public Global.CardTypes getType() {
        return this.type;
    }
}
