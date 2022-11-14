import core.Dice;
import core.Global;
import core.Player;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static core.Global.CardTypes.*;
import static core.Global.DiceSide.*;
import static org.junit.jupiter.api.Assertions.*;

public class SinglePlayerSteps {
    Player p;


    @Given("That a player is initialized")
    public void thatAPlayerIsInitialized() {
        p = new Player("Test Player");
    }

    @When("Player picks GOLD card")
    public void playerPicksGOLDCard() {
        p.pickCard();
        p.pickCard(GOLD_CARD);
    }

    @And("Player rolls 3 SKULLS and 5 SWORDS")
    public void playerRollsSKULLSAndSWORDS() {
        p.roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,SWORD,SWORD,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.setDice(dices);
    }

    @Then("PLayer dies with score {int}")
    public void playerDiesWithScore(int arg0) {
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), arg0);
    }

    @And("Player rolls one SKULL and four PARROTS and three SWORDS")
    public void playerRollsOneSKULLAndFourPARROTSAndThreeSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{PARROT,PARROT,PARROT,PARROT,SKULL,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls three SWORDS, get two SKULLS and one SWORD")
    public void playerRerollsThreeSWORDSGetTwoSKULLSAndOneSWORD() {
        p.reRoll(new int[]{5, 6, 7});
        p.reRoll(new int[]{5, 6, 7}, new Global.DiceSide[]{SKULL, SKULL, SWORD});
    }

    @And("Player rolls two SKULL and four PARROTS and two SWORDS")
    public void playerRollsTwoSKULLAndFourPARROTSAndTwoSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,PARROT,PARROT,PARROT,PARROT,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two SWORDS, get one SKULL and one SWORD")
    public void playerRerollsTwoSWORDSGetOneSKULLAndOneSWORD() {
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{SKULL, SWORD});
    }

    @And("Player rerolls three SWORDS, get one SKULL and two MONKEY")
    public void playerRerollsThreeSWORDSGetOneSKULLAndOneMONKEY() {
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{SKULL, MONKEY, MONKEY});
    }

    @And("Player rerolls two MONKEYS, get one SKULL and one MONKEY")
    public void playerRerollsTwoMONKEYSGetOneSKULLAndOneMONKEY() {
        p.reRoll(new int[]{6,7}, new Global.DiceSide[]{SKULL, MONKEY});
    }

    @And("Player rolls one SKULL and two PARROTS and three SWORDS and two GOLD COIN")
    public void playerRollsOneSKULLAndTwoPARROTSAndThreeSWORDSAndTwoGOLDCOIN() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,PARROT,PARROT,SWORD,SWORD,SWORD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two PARROTS, get two GOLD COIN")
    public void playerRerollsTwoPARROTSGetTwoGOLDCOIN() {
        p.reRoll(new int[]{1, 2}, new Global.DiceSide[]{GOLD, GOLD});
    }

    @And("Player rerolls three SWORDS, get three GOLD COIN")
    public void playerRerollsThreeSWORDSGetThreeGOLDCOIN() {
        p.reRoll(new int[]{3, 4, 5}, new Global.DiceSide[]{GOLD, GOLD, GOLD});
    }

    @Then("PLayer scores {int}")
    public void playerScores(int arg0) {
        assertEquals(p.countPoints(p.getDiceList(), p.getCard()), arg0);
    }

    @When("Player picks CAPTAIN card")
    public void playerPicksCAPTAINCard() {
        p.pickCard();
        p.pickCard(CAPTAIN);
    }

    @And("Player rolls two MONKEYS and two PARROTS and two DIAMONDS and two GOLD COIN")
    public void playerRollsTwoMONKEYSAndTwoPARROTSAndTwoDIAMONDSAndTwoGOLD_COIN() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,PARROT,PARROT,DIAMOND,DIAMOND,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls two MONKEYS and two SKULLS and two SWORDS and two PARROTS")
    public void playerRollsOneMONKEYSAndTwoSKULLSAndThreeSWORDSAndTwoPARROTS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,PARROT,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two PARROTS, get one SWORD and one MONKEY")
    public void playerRerollsTwoPARROTSGetOneSWORDAndOneMONKEY() {
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{SWORD, MONKEY});
    }

    @And("Player rolls three MONKEYS and three SWORDS and two SKULLS")
    public void playerRollsThreeMONKEYSAndThreeSWORDSAndTwoSKULLS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,SWORD,SWORD,SWORD,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls three DIAMONDS and two SKULLS and one MONKEY and one SWORD and one PARROT")
    public void playerRollsThreeDIAMONDSAndTwoSKULLSAndOneMONKEYAndOneSWORDAndOnePARROT() {
        Global.DiceSide[] ds = new Global.DiceSide[]{DIAMOND,DIAMOND,DIAMOND,SKULL,SKULL,MONKEY,SWORD,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @When("Player picks DIAMOND")
    public void playerPicksDIAMOND() {
        p.pickCard();
        p.pickCard(DIAMOND_CARD);
    }

    @And("Player rolls four GOLD COIN and two SKULLS and two SWORDS")
    public void playerRollsFourGOLDCOINAndTwoSKULLSAndTwoSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{GOLD,GOLD,GOLD,GOLD,SKULL,SKULL,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls three SWORDS and four PARROTS and one SKULL")
    public void playerRollsThreeSWORDSAndFourPARROTSAndOneSKULL() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,PARROT,PARROT,PARROT,PARROT,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls one SKULL and two GOLD COIN and two PARROTS and three SWORDS")
    public void playerRollsOneSKULLAndTwoGOLDCOINAndTwoPARROTSAndThreeSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,GOLD,GOLD,PARROT,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two PARROTS, get one SWORD and one GOLD COIN")
    public void playerRerollsTwoPARROTSGetOneSWORDAndOneGOLDCOIN() {
        p.reRoll(new int[]{3, 4}, new Global.DiceSide[]{SWORD, GOLD});
    }

    @And("Player rolls one SKULL and two MONKEY and two PARROTS and three SWORDS")
    public void playerRollsOneSKULLAndTwoMONKEYAndTwoPARROTSAndThreeSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,MONKEY,MONKEY,SWORD,SWORD,SWORD, PARROT, PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two MONKEYS, get one SKULL and one SWORD")
    public void playerRerollsTwoMONKEYSGetOneSKULLAndOneSWORD() {
        p.reRoll(new int[]{1, 2}, new Global.DiceSide[]{SKULL, SWORD});
    }

    @And("Player rolls six MONKEYS and two SKULL")
    public void playerRollsSixMONKEYSAndTwoSKULL() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls seven PARROTS and one SKULL")
    public void playerRollsSevenPARROTSAndOneSKULL() {
        Global.DiceSide[] ds = new Global.DiceSide[]{PARROT,PARROT,PARROT,PARROT,PARROT,PARROT,PARROT,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls eight GOLD COINS")
    public void playerRollsEightGOLDCOINS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{GOLD,GOLD,GOLD,GOLD,GOLD,GOLD,GOLD,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls eight SWORDS")
    public void playerRollsEightSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rolls six MONKEYS and two SWORDS")
    public void playerRollsSixMONKEYSAndTwoSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two SWORDS, get two MONKEYS")
    public void playerRerollsTwoSWORDSGetTwoMONKEYS() {
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{MONKEY, MONKEY});
    }

    @And("Player rerolls two PARROTS, get two DIAMOND")
    public void playerRerollsTwoPARROTSGetTwoDIAMOND() {
        p.reRoll(new int[]{6, 7}, new Global.DiceSide[]{DIAMOND, DIAMOND});
    }

    @And("Player rolls two MONKEYS and two SKULLS and two SWORDS and one DIAMOND and one PARROT")
    public void playerRollsTwoMONKEYSAndTwoSKULLSAndTwoSWORDSAndOneDIAMONDAndOnePARROT() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,SKULL,SKULL,SWORD,SWORD,DIAMOND,PARROT};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls two MONKEYS, get two DIAMONDS")
    public void playerRerollsTwoMONKEYSGetTwoDIAMONDS() {
        p.reRoll(new int[]{0, 1}, new Global.DiceSide[]{DIAMOND, DIAMOND});
    }

    @And("Player rolls one SKULL and two GOLD COIN and one MONKEY and one PARROT and three SWORDS")
    public void playerRollsOneSKULLAndTwoGOLDCOINAndOneMONKEYAndOnePARROTAndThreeSWORDS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,GOLD,GOLD,MONKEY,PARROT,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }

    @And("Player rerolls three SWORDS, get one GOLD COIN and one MONKEY and one PARROT")
    public void playerRerollsThreeSWORDSGetOneGOLDCOINAndOneMONKEYAndOnePARROT() {
        p.reRoll(new int[]{5,6,7}, new Global.DiceSide[]{GOLD, MONKEY, PARROT});
    }

    @And("Player rolls four MONKEYS and two COINS and two SKULLS")
    public void playerRollsFourMONKEYSAndTwoCOINSAndTwoSKULLS() {
        Global.DiceSide[] ds = new Global.DiceSide[]{MONKEY,MONKEY,MONKEY,MONKEY,GOLD,GOLD,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        p.roll();
        p.setDice(dices);
    }
}
