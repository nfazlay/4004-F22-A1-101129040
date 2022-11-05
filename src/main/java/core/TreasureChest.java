package core;

import java.util.ArrayList;
import java.util.List;

public class TreasureChest extends Card {

    private List<Dice> diceArrayList = new ArrayList<Dice>(8);

    public TreasureChest(Global.CardTypes type) {
        super(type);
    }

    @Override
    public void addDice (Dice d) {
        diceArrayList.add(d);
    }

    @Override
    public List<Dice> getList () {
        return diceArrayList;
    }
}
