package core;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable {
    private Global.CardTypes type;

    public Card(Global.CardTypes type) {
        this.type = type;
    }

    public Global.CardTypes getType() {
        return this.type;
    }

    public void addDice (Dice d) {}

    public List<Dice> getList() {
        return null;
    }

    @Override
    public String toString() {
        return type.name();
    }
}

