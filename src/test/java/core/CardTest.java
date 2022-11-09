package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCard() {
        Card card = new Card(Global.CardTypes.BATTLE);
        assertEquals(Global.CardTypes.BATTLE, card.getType());
    }

    @Test
    public void testTreasureChest () {
        Card tc = new TreasureChest(Global.CardTypes.CHEST);
        Dice d = new Dice();
        d.setDice(Global.DiceSide.GOLD);
        tc.addDice(d);
        Dice dt = tc.getList().get(0);
        assertEquals(Global.DiceSide.GOLD, dt.getDice());
    }

    @Test
    public void testSorceres () {
        Card tc = new Sorceres(Global.CardTypes.SOCERESS);
        assertFalse(tc.usedCard);
    }

    @Test
    public void testSkulls () {
        Card tc = new Skulls(Global.CardTypes.SKULLS_CARD);
        tc.setNumSkulls(2);
        assertEquals(2, tc.getNumSkulls());
    }

    @Test
    public void testSeaBattle () {
        Card tc = new SeaBattle(Global.CardTypes.BATTLE);
        assertTrue(tc.getSwordPoints() == 500 || tc.getSwordPoints() == 1000);
        assertTrue(tc.getNumSwords() == 4 || tc.getNumSwords() == 5);
    }
}
