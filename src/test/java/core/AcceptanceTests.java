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

    @Test
    public void test46 () {
        Player p = new Player("test46");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{PARROT,PARROT,PARROT,PARROT,SKULL,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{5, 6, 7}, new Global.DiceSide[]{SKULL, SKULL, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test47 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{SKULL, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test48 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{5, 6, 7}, new Global.DiceSide[]{SKULL, MONKEY, MONKEY});
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{SKULL, MONKEY});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test50 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,PARROT,PARROT,SWORD,SWORD,SWORD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{1, 2}, new Global.DiceSide[]{GOLD, GOLD});
        p.reRoll(new int[]{3, 4, 5}, new Global.DiceSide[]{GOLD, GOLD, GOLD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }


}
