package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static core.Global.DiceSide.*;
import static org.junit.jupiter.api.Assertions.*;

public class AcceptanceTests {

    @Test
    public void test45 () {
        Player p = new Player("test45");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SKULL,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }
}
