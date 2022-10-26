package core;

import core.Player;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    public void testPlayer() {
        Player player = new Player("John Cena");
        assertEquals("John Cena", player.getName());
    }

    public void testPlayerCard () {
        Player player = new Player("John Cena");
        assertNull(player.getCard());
        player.pickCard();
        assertNotNull(player.getCard());
        player.clearCard();
        assertNull(player.getCard());
        player.setCard(Global.CardTypes.GOLD_CARD);
        assertNotNull(player.getCard());
    }
}
