package core;
import java.util.*;

public class Player {
    private String name = "";
    private List<Dice> diceArrayList = new ArrayList<Dice>(8);
    private Card card = null;

    public Player (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public void pickCard () {
        Global.CardTypes cardType = Global.randomEnum(Global.CardTypes.class);
        this.card = new Card(cardType);
    }

    public void clearCard () {
        this.card = null;
    }

    public Card getCard () {
        return this.card;
    }

    public void setCard (Global.CardTypes cardType) {
        this.card = new Card(cardType);
    }

    public void setDice (List<Dice> diceArrayList) {
        this.diceArrayList = diceArrayList;
    }

    public List<Dice> getDiceList () {
        return this.diceArrayList;
    }
}
