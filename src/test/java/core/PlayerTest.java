package core;

import core.Player;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    public void testPlayer() {
        Player player = new Player("John Cena");
        assertEquals("John Cena", player.getName());
    }
}
