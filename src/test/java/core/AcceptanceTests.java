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
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 4800);
    }

    @Test
    public void test52 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.CAPTAIN);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,PARROT,PARROT,GOLD,GOLD,DIAMOND,DIAMOND};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 800);
    }

    @Test
    public void test53 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,PARROT,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{SWORD, MONKEY});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 300);
    }

    @Test
    public void test54 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,MONKEY,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 300);
    }

    @Test
    public void test55 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{DIAMOND,DIAMOND,DIAMOND,SKULL,SKULL,SWORD,MONKEY,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 500);
    }

    @Test
    public void test56 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.DIAMOND_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{GOLD,GOLD,GOLD,GOLD,SKULL,SKULL,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 700);
    }

    @Test
    public void test57 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.DIAMOND_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,PARROT,PARROT,PARROT,PARROT,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 400);
    }


}
