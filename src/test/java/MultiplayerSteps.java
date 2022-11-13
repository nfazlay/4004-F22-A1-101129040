import core.Dice;
import core.GameServer;
import core.Global;
import core.Player;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static core.Global.DiceSide.*;
import static org.junit.jupiter.api.Assertions.*;

import java.net.SocketException;
import java.util.List;

public class MultiplayerSteps {

    GameServer gs;
    int numPlayers;
    int scoreToDeduct;
    Player dinner;

    @Given("That the server is initiated")
    public void thatTheServerIsInitiated() throws SocketException {
        gs = new GameServer(8080);
    }

    @And("Three players are added")
    public void threePlayersAreAdded() {
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
        gs.players.add(p1);
        gs.players.add(p2);
        gs.players.add(p2);
    }

    @When("I query server for number of players")
    public void iQueryServerForNumberOfPlayers() {
        numPlayers = gs.players.size();
    }

    @Then("it is {int}")
    public void itIs(int arg0) {
        assertEquals(arg0, numPlayers);
    }

    @And("Player {int} picks FC CAPTAIN")
    public void playerPicksFCCAPTAIN(int arg0) {
        gs.players.get(arg0 -1).pickCard();
        gs.players.get(arg0 -1).pickCard(Global.CardTypes.CAPTAIN);
    }

    @And("Player {int} picks FC SKULL {int}")
    public void playerPicksFCSKULL(int arg0, int arg1) {
        gs.players.get(arg0-1).pickCard();
        gs.players.get(arg0 -1).pickCard(Global.CardTypes.SKULLS_CARD);
        gs.players.get(arg0 -1).getCard().setNumSkulls(arg1);
    }

    @And("Player {int} rolls 7 swords and 1 skull")
    public void playerRollsSwordsAndSkull(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Player {int} picks FC COIN")
    public void playerPicksFCCoin(int arg0) {
        gs.players.get(arg0 -1).pickCard();
        gs.players.get(arg0 -1).pickCard(Global.CardTypes.GOLD_CARD);
    }

    @And("Player {int} rolls 3 skulls and 5 monkeys")
    public void playerRollsSkullsAndMonkeys(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,MONKEY,MONKEY,MONKEY,MONKEY,MONKEY};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Calculate score of all players")
    public void calculateScoreOfAllPlayers() {
        for (Player p: gs.players) {
            p.setScore(p.countPoints(p.getDiceList(), p.getCard()));
        }
    }


    @And("find winner")
    public void findWinner() {
        dinner = Global.highestScore(gs.players);
    }

    @Then("I find that {string} is the winner")
    public void iFindThatIsTheWinner(String arg0) {
        assertEquals(arg0, dinner.getName());
    }

    @And("close server")
    public void closeServer() {
        gs.closeSocket();
    }

    @And("Player {int} rolls 6 skulls and 2 parrots")
    public void playerRollsSkullsAndParrots(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,MONKEY,MONKEY};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Deduct score of Player {int}")
    public void deductScoreOfPlayer(int arg0) {
        gs.players.get(arg0 -1).deductScore(scoreToDeduct);
    }

    @And("Player {int} rolls 4 monkeys and 4 parrots")
    public void playerRollsMonkeysAndParrots(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,MONKEY,MONKEY};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Player {int} rolls 8 swords")
    public void playerRollsSwords(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SWORD};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Player {int} rolls 6 swords and 2 skulls")
    public void playerRollsSwordsAndSkulls(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SWORD,SWORD,SWORD,SWORD,SWORD,SWORD,SKULL,SKULL};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Player {int} picks FC SORCERESS")
    public void playerPicksFCSORCERESS(int arg0) {
        gs.players.get(arg0 -1).pickCard();
        gs.players.get(arg0 -1).pickCard(Global.CardTypes.SOCERESS);
    }

    @And("Player {int} rolls 7 skull and 1 coin")
    public void playerRollsSkullAndCoin(int arg0) {
        gs.players.get(arg0 -1).roll();
        Global.DiceSide[] ds = new Global.DiceSide[]{SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,SKULL,GOLD};
        List<Dice> dices = Global.createDiceList(ds);
        gs.players.get(arg0 -1).setDice(dices);
    }

    @And("Player {int} rerolls 1 skull to parrot using Sorceress")
    public void playerRerollsSkullToParrotUsingSorceress(int arg0) {
        gs.players.get(arg0 -1).reRoll(new int[]{0}, new Global.DiceSide[]{PARROT});
        gs.players.get(arg0 -1).getCard().usedCard = true;
    }

    @And("Player {int} rerolls coin and parrot to get two skulls")
    public void playerRerollsCoinAndParrotToGetTwoSkulls(int arg0) {
        gs.players.get(arg0 -1).reRoll(new int[]{0, 7}, new Global.DiceSide[]{SKULL, SKULL});
        gs.players.get(arg0 -1).getCard().usedCard = true;
    }

    @And("Player {int} sets islandOfSkulls points")
    public void playerSetsIslandOfSkullsPoints(int arg0) {
        scoreToDeduct = gs.players.get(arg0 -1).islandOfSkullsPoints(gs.players.get(arg0 -1).getDiceList(), gs.players.get(arg0 -1).getCard());
    }
}
