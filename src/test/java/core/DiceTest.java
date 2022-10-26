package core;

import junit.framework.TestCase;

public class DiceTest extends TestCase {
    public void testDice() {
        Dice dice = new Dice();
        dice.setDice(Global.DiceSide.DIAMOND);
        assertEquals(Global.DiceSide.DIAMOND, dice.getDice());
    }
}
