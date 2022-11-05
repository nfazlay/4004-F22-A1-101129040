package core;

import junit.framework.TestCase;

public class CardTest extends TestCase {

    public void testCard() {
        Card card = new Card(Global.CardTypes.BATTLE);
        assertEquals(Global.CardTypes.BATTLE, card.getType());
    }

    public void testTreasureChest () {
        Card tc = new TreasureChest(Global.CardTypes.CHEST);
        Dice d = new Dice();
        d.setDice(Global.DiceSide.GOLD);
        tc.addDice(d);
        Dice dt = tc.getList().get(0);
        assertEquals(Global.DiceSide.GOLD, dt.getDice());
    }

    public void testSorceres () {
        Card tc = new Sorceres(Global.CardTypes.SOCERESS);
        assertFalse(tc.usedCard);
    }

    public void testSkulls () {
        Card tc = new Skulls(Global.CardTypes.SKULLS_CARD);
        tc.setNumSkulls(2);
        assertEquals(2, tc.getNumSkulls());
    }
}
