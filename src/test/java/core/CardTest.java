package core;

import junit.framework.TestCase;

public class CardTest extends TestCase {

    public void testCard() {
        Card card = new Card(Global.CardTypes.BATTLE);
        assertEquals(Global.CardTypes.BATTLE, card.getType());
    }
}
