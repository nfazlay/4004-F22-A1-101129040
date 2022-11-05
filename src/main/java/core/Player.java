package core;
import java.util.*;

public class Player implements Serializable {
    private String name = "";
    private boolean islandOfSkulls;
    private List<Dice> diceArrayList = new ArrayList<Dice>(8);
    private Card card = null;
    private int score;
    private int lastScore;

    String userResponse;
    public Player (String name) {
        this.name = name;
        score = 0;
        lastScore = 0;
        islandOfSkulls = false;
    }

    public String getName () {
        return this.name;
    }

    public void pickCard () {
        Global.CardTypes cardType = Global.randomEnum(Global.CardTypes.class);
        if (cardType == Global.CardTypes.CHEST) {
            this.card = new TreasureChest(cardType);
        }
        else {
            this.card = new Card(cardType);
        }
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

    public void setIslandOfSkulls (boolean b) {
        this.islandOfSkulls = b;
    }

    public boolean getIslandOfSkulls () {
        return this.islandOfSkulls;
    }

    public void roll() {
        for(int i =0; i < 8; i++) {
            Dice d = new Dice();
            d.roll();
            diceArrayList.add(d);
        }
    }

    public boolean reRoll(int[] positions) {
        for (int position : positions) {
            if (diceArrayList.get(position).getDice() == Global.DiceSide.SKULL ||
                    diceArrayList.get(position).setAside) {
                return false;
            }

        }
        for (int position : positions) {
            diceArrayList.get(position).roll();
        }
        return true;
    }

    public boolean setAside (int[] positions) {
        for (int position : positions) {
            Dice d = diceArrayList.get(position);
            if (d.getDice() == Global.DiceSide.SKULL ||
                    d.setAside == true) {
                return false;
            }
        }
        for (int position : positions) {
            Dice d = diceArrayList.get(position);
            d.setAside = true;
            card.addDice(d);
        }
        return true;
    }

    public int checkSkulls (List<Dice> list) {
        int count  = 0;
        for (int i =0; i < list.size(); i ++) {
            if (list.get(i).getDice() == Global.DiceSide.SKULL) {
                count++;
            }
        }
        return count;
    }

    public boolean reRoll(int[] positions, Global.DiceSide[] diceArray) { // same functionality as reroll but for rigged version
        for (int position : positions) {
            if (diceArrayList.get(position).getDice() == Global.DiceSide.SKULL) {
                return false;
            }
        }
        for (int i =0; i < positions.length; i++) {
            diceArrayList.get(positions[i]).setDice(diceArray[i]);
        }
        return true;
    }
}
