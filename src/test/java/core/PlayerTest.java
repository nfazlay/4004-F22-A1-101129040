package core;

import core.Player;
import junit.framework.TestCase;
import java.util.*;

import java.util.ArrayList;

public class PlayerTest extends TestCase {
    Player player = new Player("John Cena");

    public void testPlayer() {
        assertEquals("John Cena", player.getName());
    }

    public void testPlayerCard () {
        assertNull(player.getCard());
        player.pickCard();
        assertNotNull(player.getCard());
        player.clearCard();
        assertNull(player.getCard());
        player.setCard(Global.CardTypes.GOLD_CARD);
        assertNotNull(player.getCard());
    }

    public void testGetDice () {
        assertNotNull(player.getDiceList());
    }
    public void testSetDice () {
        List<Dice> list = new ArrayList<Dice>(8);
        for(int i =0; i < 8; i++) {
            Dice d = new Dice();
            d.roll();
            list.add(d);
        }
        player.setDice(list);
        assertNotNull(player.getDiceList().get(0).getDice());
    }
}
