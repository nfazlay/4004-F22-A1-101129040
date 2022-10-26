package core;

import junit.framework.TestCase;

public class DiceTest extends TestCase {
    public void testDice() {
        Dice dice = new Dice();
        dice.setDice(5);
        assertEquals(5, dice.getDice());
    }
}
