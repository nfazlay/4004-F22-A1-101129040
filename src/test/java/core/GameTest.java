package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    Game game = new Game();

    @Test
    public void testCheckSkulls () {
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

        int skulls = game.checkSkulls(diceArray);
        assertEquals(3, skulls);
    }
}
