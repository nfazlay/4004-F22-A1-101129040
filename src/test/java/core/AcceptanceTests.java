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

    @Test
    public void test58 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,GOLD,GOLD,PARROT,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{3, 4}, new Global.DiceSide[]{GOLD, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 800);
    }

    @Test
    public void test59 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.CAPTAIN);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,GOLD,GOLD,PARROT,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{3, 4}, new Global.DiceSide[]{GOLD, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1200);
    }

    @Test
    public void test60 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,MONKEY,MONKEY,PARROT,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{1, 2}, new Global.DiceSide[]{SKULL, SWORD});
        p.reRoll(new int[]{3, 4}, new Global.DiceSide[]{MONKEY, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 600);
    }

    @Test
    public void test62 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1100);
    }

    @Test
    public void test63 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{PARROT,PARROT,PARROT,PARROT,PARROT,PARROT,PARROT,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 2100);
    }

    @Test
    public void test64 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{GOLD,GOLD,GOLD,GOLD,GOLD,GOLD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 5400);
    }

    @Test
    public void test65 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.DIAMOND_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{GOLD,GOLD,GOLD,GOLD,GOLD,GOLD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 5400);
    }

    @Test
    public void test66 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.CAPTAIN);
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 9000);
    }

    @Test
    public void test67 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{MONKEY, MONKEY});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 4600);
    }

    @Test
    public void test68 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.DIAMOND_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,PARROT,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{DIAMOND, DIAMOND});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 400);
    }

    @Test
    public void test69 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,DIAMOND,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{0, 1}, new Global.DiceSide[]{DIAMOND, DIAMOND});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 500);
    }

    @Test
    public void test70 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,GOLD,GOLD,MONKEY,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{GOLD, MONKEY, PARROT});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 600);
    }

    @Test
    public void test71 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.DIAMOND_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,GOLD,GOLD,MONKEY,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{GOLD, MONKEY, PARROT});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 500);
    }

    @Test
    public void test72 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,SKULL,SKULL,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 600);
    }

    @Test
    public void test77 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.SOCERESS);
        Global.DiceSide[] ds = new Global.DiceSide[]{DIAMOND,DIAMOND,SWORD,MONKEY,GOLD,PARROT,PARROT,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{SKULL, MONKEY, MONKEY});
        p.reRoll(new int[]{5}, new Global.DiceSide[]{MONKEY});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 500);
    }

    @Test
    public void test78 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.SOCERESS);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,PARROT,PARROT,PARROT,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{0}, new Global.DiceSide[]{PARROT});
        p.reRoll(new int[]{6,7}, new Global.DiceSide[]{PARROT, PARROT});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1000);
    }

    @Test
    public void test79 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.SOCERESS);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,PARROT,PARROT,PARROT,PARROT,MONKEY,MONKEY,MONKEY};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{SKULL, PARROT, PARROT});
        p.reRoll(new int[]{5}, new Global.DiceSide[]{PARROT});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 2000);
    }

    @Test
    public void test82 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.MONKEY_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,PARROT,PARROT,PARROT,SKULL,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1100);
    }

    @Test
    public void test83 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.MONKEY_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SWORD,SWORD,PARROT,PARROT,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{2,3}, new Global.DiceSide[]{MONKEY, PARROT});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1700);
    }

    @Test
    public void test84 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.MONKEY_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,PARROT,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test87 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.CHEST);
        Global.DiceSide[] ds = new Global.DiceSide[]{PARROT,PARROT,PARROT,SWORD,SWORD,DIAMOND,DIAMOND,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.setAside(new int[]{5,6,7});
        p.reRoll(new int[]{3,4}, new Global.DiceSide[]{PARROT, PARROT});
        p.setAside(new int[]{0,1,2,3,4});
        p.returnDice(new int[]{5,6,7});
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{SKULL, GOLD, PARROT});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1100);
    }

    @Test
    public void test92 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.CHEST);
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,PARROT,PARROT,PARROT,GOLD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.setAside(new int[]{5,6,7});
        p.reRoll(new int[]{2,3, 4}, new Global.DiceSide[]{DIAMOND, DIAMOND, GOLD});
        p.setAside(new int[]{4});
        p.reRoll(new int[]{2,3}, new Global.DiceSide[]{SKULL, GOLD});
        assertEquals(p.countPoints(p.getCard().getList(), p.getCard()), 600);
    }

    @Test
    public void test97 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,DIAMOND,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 400);
    }

    @Test
    public void test98 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.CAPTAIN);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1800);
    }

    @Test
    public void test99 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.GOLD_CARD);
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,SWORD,DIAMOND};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1000);
    }

    @Test
    public void test100 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.BATTLE);
        p.getCard().setNumSwords(2);
        p.getCard().setSwordPoints(300);

        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,PARROT,PARROT,SWORD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{4,5}, new Global.DiceSide[]{GOLD, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1200);
    }

    @Test
    public void test103 () {
        Player p = new Player("test47");
        p.pickCard(Global.CardTypes.MONKEY_CARD);
        p.getCard().setNumSwords(2);
        p.getCard().setSwordPoints(300);

        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,PARROT,GOLD,GOLD,DIAMOND,DIAMOND,DIAMOND};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{4,5}, new Global.DiceSide[]{GOLD, SWORD});
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 1200);
    }


    @Test
    public void test106 () {
        Player p = new Player("test45");
        p.pickCard(Global.CardTypes.SKULLS_CARD);
        p.getCard().setNumSkulls(2);
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test107 () {
        Player p = new Player("test45");
        p.pickCard(Global.CardTypes.SKULLS_CARD);
        p.getCard().setNumSkulls(1);
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test108 () {
        Player p = new Player("test45");
        p.pickCard(Global.CardTypes.SKULLS_CARD);
        p.getCard().setNumSkulls(2);
        Global.DiceSide[] ds = new Global.DiceSide[]{PARROT,PARROT,PARROT,MONKEY,MONKEY,MONKEY,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
        p.reRoll(new int[]{0,1,2}, new Global.DiceSide[]{SKULL, SKULL, SWORD});
        p.reRoll(new int[]{2,3,4,5}, new Global.DiceSide[]{SKULL, SKULL, SKULL, SWORD});
        assertEquals(p.islandOfSkullsPoints(p.getDiceList(), p.getCard()), 900);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test110 () {
        Player p = new Player("test45");
        p.pickCard(Global.CardTypes.CAPTAIN);

        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);

        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{SKULL, SKULL, GOLD});
        assertEquals(p.islandOfSkullsPoints(p.getDiceList(), p.getCard()), 1400);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }

    @Test
    public void test111 () {
        Player p = new Player("test45");
        p.pickCard(Global.CardTypes.SKULLS_CARD);
        p.getCard().setNumSkulls(2);

        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);

        p.reRoll(new int[]{3,4,5,6,7}, new Global.DiceSide[]{GOLD, GOLD, GOLD, GOLD, GOLD});
        assertEquals(p.islandOfSkullsPoints(p.getDiceList(), p.getCard()), 500);
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), 0);
    }
}
