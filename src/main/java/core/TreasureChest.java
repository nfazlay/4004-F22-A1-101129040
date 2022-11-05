package core;

import java.util.ArrayList;
import java.util.List;

public class TreasureChest extends Card {

    private List<Dice> diceArrayList = new ArrayList<Dice>(8);

    public TreasureChest(Global.CardTypes type) {
        super(type);
    }

    public void addDice (Dice d) {
        diceArrayList.add(d);
    }

    public List<Dice> getList () {
        return diceArrayList;
    }
}
