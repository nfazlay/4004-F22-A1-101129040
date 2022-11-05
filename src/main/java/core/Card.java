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
    protected boolean usedCard;
    protected int numSwords;
    protected int swordPoints;
    protected int numSkulls;
    protected void setNumSkulls(int s) {}
    protected int getNumSkulls() {return -1;}
    protected int getNumSwords() {return -1;}
    protected int getSwordPoints() {return -1;}
    protected void setNumSwords(int n) {}
    protected void setSwordPoints(int n) {}

    public List<Dice> getList() {
        return null;
    }

    @Override
    public String toString() {
        return type.name();
    }
}

