package core;

import core.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import java.util.ArrayList;

public class PlayerTest {
    Player player = new Player("John Cena");


    @Test
    public void testPlayer() {
        assertEquals("John Cena", player.getName());
    }

    @Test
    public void testPlayerCard () {
        assertNull(player.getCard());
        player.pickCard();
        assertNotNull(player.getCard());
        player.clearCard();
        assertNull(player.getCard());
        player.setCard(Global.CardTypes.GOLD_CARD);
        assertNotNull(player.getCard());
    }

    @Test
    public void testGetDice () {
        assertNotNull(player.getDiceList());
    }

    @Test
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

    @Test
    public void testGetScore () {
        assertEquals(0, player.getScore());
    }

    @Test
    public void testSetScore () {
        player.setScore(1000);
        assertEquals(1000, player.getScore());
    }

    @Test
    public void testRoll () {
        player.roll();
        assertFalse(player.getDiceList().isEmpty());
    }

    @Test
    public void testReRoll () {
        List<Dice> diceArray= new ArrayList<Dice>(8);
        int[] pos = new int[] {1,2,3,4};
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.SKULL);
        diceArray.add(d1);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.SKULL);
        diceArray.add(d2);
        Dice d3 = new Dice();
        d3.setDice(Global.DiceSide.SKULL);
        diceArray.add(d3);
        Dice d4 = new Dice();
        d4.setDice(Global.DiceSide.PARROT);
        diceArray.add(d4);
        Dice d5 = new Dice();
        d5.setDice(Global.DiceSide.GOLD);
        diceArray.add(d5);
        Dice d6 = new Dice();
        d6.setDice(Global.DiceSide.DIAMOND);
        diceArray.add(d6);
        Dice d7 = new Dice();
        d7.setDice(Global.DiceSide.SWORD);
        diceArray.add(d7);
        Dice d8 = new Dice();
        d8.setDice(Global.DiceSide.MONKEY);
        diceArray.add(d8);

        player.setDice(diceArray);
        assertFalse(player.reRoll(pos));
        pos = new int [] {5,6,7};
        assertTrue(player.reRoll(pos));
    }

    @Test
    public void testIslandOfSkulls () {
        player.setIslandOfSkulls(true);
        assertTrue(player.getIslandOfSkulls());
    }

    @Test
    public void testCheckNumSide () {
        List<Dice> diceArray= new ArrayList<Dice>(8);
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.SKULL);
        diceArray.add(d1);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.SKULL);
        diceArray.add(d2);
        Dice d3 = new Dice();
        d3.setDice(Global.DiceSide.SKULL);
        diceArray.add(d3);
        Dice d4 = new Dice();
        d4.setDice(Global.DiceSide.PARROT);
        diceArray.add(d4);
        Dice d5 = new Dice();
        d5.setDice(Global.DiceSide.GOLD);
        diceArray.add(d5);
        Dice d6 = new Dice();
        d6.setDice(Global.DiceSide.DIAMOND);
        diceArray.add(d6);
        Dice d7 = new Dice();
        d7.setDice(Global.DiceSide.SWORD);
        diceArray.add(d7);
        Dice d8 = new Dice();
        d8.setDice(Global.DiceSide.MONKEY);
        diceArray.add(d8);

        int skulls = player.checkNumSide(diceArray, Global.DiceSide.SKULL);
        assertEquals(3, skulls);
    }

    @Test
    public void testIslandOfSkullsPoints () {
        List<Dice> diceArray= new ArrayList<Dice>(8);
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.SKULL);
        diceArray.add(d1);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.SKULL);
        diceArray.add(d2);
        Dice d3 = new Dice();
        d3.setDice(Global.DiceSide.SKULL);
        diceArray.add(d3);
        Dice d4 = new Dice();
        d4.setDice(Global.DiceSide.PARROT);
        diceArray.add(d4);
        Dice d5 = new Dice();
        d5.setDice(Global.DiceSide.GOLD);
        diceArray.add(d5);
        Dice d6 = new Dice();
        d6.setDice(Global.DiceSide.DIAMOND);
        diceArray.add(d6);
        Dice d7 = new Dice();
        d7.setDice(Global.DiceSide.SWORD);
        diceArray.add(d7);
        Dice d8 = new Dice();
        d8.setDice(Global.DiceSide.MONKEY);
        diceArray.add(d8);

        Card c = new Card(Global.CardTypes.CHEST);

        int points  = player.islandOfSkullsPoints(diceArray, c);
        assertEquals(300, points);

        c = new Card(Global.CardTypes.CAPTAIN);
        points  = player.islandOfSkullsPoints(diceArray, c);
        assertEquals(600, points);
    }

    @Test
    public void testCountPoints () {
        List<Dice> diceArray= new ArrayList<Dice>(8);
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.SKULL);
        diceArray.add(d1);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.SKULL);
        diceArray.add(d2);
        Dice d3 = new Dice();
        d3.setDice(Global.DiceSide.SKULL);
        diceArray.add(d3);
        Dice d4 = new Dice();
        d4.setDice(Global.DiceSide.PARROT);
        diceArray.add(d4);
        Dice d5 = new Dice();
        d5.setDice(Global.DiceSide.GOLD);
        diceArray.add(d5);
        Dice d6 = new Dice();
        d6.setDice(Global.DiceSide.DIAMOND);
        diceArray.add(d6);
        Dice d7 = new Dice();
        d7.setDice(Global.DiceSide.SWORD);
        diceArray.add(d7);
        Dice d8 = new Dice();
        d8.setDice(Global.DiceSide.MONKEY);
        diceArray.add(d8);

        Card c = new Card(Global.CardTypes.CHEST);

        int points  = player.countPoints(diceArray, c);
        assertEquals(300, points);

        c = new Card(Global.CardTypes.CAPTAIN);
        points  = player.countPoints(diceArray, c);
        assertEquals(600, points);
    }

    @Test
    public void testDied () {
        List<Dice> diceArray= new ArrayList<Dice>(8);
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.SKULL);
        diceArray.add(d1);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.SKULL);
        diceArray.add(d2);
        Dice d3 = new Dice();
        d3.setDice(Global.DiceSide.PARROT);
        diceArray.add(d3);
        Dice d4 = new Dice();
        d4.setDice(Global.DiceSide.PARROT);
        diceArray.add(d4);
        Dice d5 = new Dice();
        d5.setDice(Global.DiceSide.GOLD);
        diceArray.add(d5);
        Dice d6 = new Dice();
        d6.setDice(Global.DiceSide.DIAMOND);
        diceArray.add(d6);
        Dice d7 = new Dice();
        d7.setDice(Global.DiceSide.SWORD);
        diceArray.add(d7);
        Dice d8 = new Dice();
        d8.setDice(Global.DiceSide.MONKEY);
        diceArray.add(d8);

        Card c = new Card(Global.CardTypes.CHEST);

        assertFalse(player.died(diceArray, c, false));

        c = new Skulls(Global.CardTypes.SKULLS_CARD);
        c.numSkulls = 1;

        assertTrue(player.died(diceArray, c, false));
    }

    @Test
    public void testDeductScore () {
        player.setScore(400);
        player.deductScore(200);
        assertEquals(player.getScore(), 200);
    }

    @Test
    public void TestPickCard () {
        player.pickCard(Global.CardTypes.SOCERESS);
        assertEquals(player.getCard().getType(), Global.CardTypes.SOCERESS);
    }
}
