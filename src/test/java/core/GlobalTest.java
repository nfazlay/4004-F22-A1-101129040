package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class GlobalTest {


    @Test
    public void testRandomEnum () {
        Global.DiceSide side = Global.randomEnum(Global.DiceSide.class);
        assertTrue(side instanceof Global.DiceSide);
    }

    @Test
    public void testPrintDiceList () {
        List<Dice> dices = new ArrayList<Dice>(2);
        Dice d1 = new Dice();
        d1.setDice(Global.DiceSide.PARROT);
        Dice d2 = new Dice();
        d2.setDice(Global.DiceSide.PARROT);
        dices.add(d1);
        dices.add(d2);

        assertTrue(Global.printDiceList(dices));
    }

    @Test
    public void testCountIdentical () {
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

        Map testMap = Global.countIdentical(diceArray);
        System.out.println(testMap);
        assertEquals(testMap.get(Global.DiceSide.SKULL), 3);
    }
}
