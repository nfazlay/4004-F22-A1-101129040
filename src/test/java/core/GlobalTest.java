package core;

import junit.framework.TestCase;
import java.util.*;

public class GlobalTest extends TestCase {

    public void testRandomEnum () {
        Global.DiceSide side = Global.randomEnum(Global.DiceSide.class);
        assertTrue(side instanceof Global.DiceSide);
    }

    public void testPrintDiceList () {
        List<Dice> dices = new ArrayList<Dice>(2);
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.PARROT);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.PARROT);
        dices.add(d1);
        dices.add(d2);

        assertTrue(Global.printDiceList(dices));
    }
}
