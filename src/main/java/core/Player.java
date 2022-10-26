package core;
import java.util.*;

public class Player {
    private String name = "";
    private List<Dice> diceArrayList = new ArrayList<Dice>(8);
    private Card card = null;
    private int score = 0;

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

    public int getScore () {
        return this.score;
    }

    public void setScore (int score) {
        this.score = score;
    }

    public void roll() {
        for(int i =0; i < 8; i++) {
            Dice d = new Dice();
            d.roll();
            diceArrayList.add(d);
        }
    }

    public boolean reRoll(int[] positions) {
        for (int i =0; i < positions.length; i++) {
            if (diceArrayList.get(positions[i]).getDice() == Global.DiceSide.SKULL) {
                return false;
            }
        }
        for (int i =0; i < positions.length; i++) {
            diceArrayList.get(positions[i]).roll();
        }
        return true;
    }

    public boolean reRoll(int[] positions, Global.DiceSide[] diceArray) { // same functionality as reroll but for rigged version
        for (int i =0; i < positions.length; i++) {
            if (diceArrayList.get(positions[i]).getDice() == Global.DiceSide.SKULL) {
                return false;
            }
        }
        for (int i =0; i < positions.length; i++) {
            diceArrayList.get(positions[i]).setDice(diceArray[i]);
        }
        return true;
    }
}
