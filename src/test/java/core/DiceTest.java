package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {
    @Test
    public void testDice() {
        Dice dice = new Dice();
        dice.setDice(Global.DiceSide.DIAMOND);
        assertEquals(Global.DiceSide.DIAMOND, dice.getDice());
    }

    @Test
    public void testRoll() {
        Dice dice = new Dice();
        dice.roll();
        assertNotNull(dice.getDice());
    }

    @Test
    public void testToString () {
        Dice d = new Dice();
        d.setDice(Global.DiceSide.SKULL);
        assertEquals("SKULL", d.toString());
    }
}
