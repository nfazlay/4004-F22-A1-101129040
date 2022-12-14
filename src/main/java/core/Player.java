package core;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    private String name = "";
    private boolean islandOfSkulls;
    private List<Dice> diceArrayList = new ArrayList<Dice>(8);
    private Card card = null;
    private int score;
    public int lastScore;
    public boolean rigged = false;
    public boolean gameover = false;

    String userResponse;
    public Player (String name) {
        this.name = name;
        score = 0;
        lastScore = 0;
        islandOfSkulls = false;
    }

    public String getName () {
        return this.name;
    }
    
    public void pickCard () {
        Global.CardTypes cardType = Global.randomEnum(Global.CardTypes.class);
        switch (cardType) {
            case CHEST:
                this.card = new TreasureChest(cardType);
                break;
            case SOCERESS:
                this.card = new Sorceres(cardType);
                break;
            case SKULLS_CARD:
                this.card = new Skulls(cardType);
                break;
            case BATTLE:
                this.card = new SeaBattle(cardType);
                break;
            default:
                this.card = new Card(cardType);
        }
    }

    public void pickCard (Global.CardTypes c) {
        Global.CardTypes cardType = c;
        switch (cardType) {
            case CHEST:
                this.card = new TreasureChest(cardType);
                break;
            case SOCERESS:
                this.card = new Sorceres(cardType);
                break;
            case SKULLS_CARD:
                this.card = new Skulls(cardType);
                break;
            case BATTLE:
                this.card = new SeaBattle(cardType);
                break;
            default:
                this.card = new Card(cardType);
        }
    }

    public void clearCard () {
        this.card = null;
    }

    public Card getCard () {
        return this.card;
    }

    public void setCard (Global.CardTypes cardType) {
        this.card = new Card(cardType);
    }

    public void setDice (List<Dice> diceArrayList) {
        this.diceArrayList = diceArrayList;
    }

    public List<Dice> getDiceList () {
        return this.diceArrayList;
    }

    public int getScore () {
        return this.score;
    }

    public void setScore (int score) {
        this.score = score;
    }

    public void deductScore (int s) {
        this.score = this.score == 0 ? 0 : this.score - s;
    }

    public void setIslandOfSkulls (boolean b) {
        this.islandOfSkulls = b;
    }

    public boolean getIslandOfSkulls () {
        return this.islandOfSkulls;
    }

    public void roll() {
        diceArrayList = new ArrayList<Dice>(8);
        for(int i =0; i < 8; i++) {
            Dice d = new Dice();
            d.roll();
            diceArrayList.add(d);
        }
    }

    public boolean reRoll(int[] positions) {
        for (int position : positions) {
            if (diceArrayList.get(position).getDice() == Global.DiceSide.SKULL ||
                    diceArrayList.get(position).setAside) {
                return false;
            }

        }
        for (int position : positions) {
            diceArrayList.get(position).roll();
        }
        return true;
    }

    public boolean setAside (int[] positions) {
        for (int position : positions) {
            Dice d = diceArrayList.get(position);
            if (d.getDice() == Global.DiceSide.SKULL ||
                    d.setAside == true) {
                return false;
            }
        }
        for (int position : positions) {
            Dice d = diceArrayList.get(position);
            d.setAside = true;
            card.addDice(d);
        }
        return true;
    }

    public boolean returnDice (int[] positions) {
        for (int position : positions) {
            Dice d = diceArrayList.get(position);
            if (d.getDice() == Global.DiceSide.SKULL ||
                    d.setAside == false) {
                return false;
            }
        }
        for (int position : positions) {
            Dice d = diceArrayList.get(position);
            d.setAside = false;
            card.removeDice(d);
        }
        return true;
    }

    public int checkNumSide (List<Dice> list, Global.DiceSide side) {
        int count  = 0;
        for (int i =0; i < list.size(); i ++) {
            if (list.get(i).getDice() == side) {
                count++;
            }
        }
        return count;
    }

    public int islandOfSkullsPoints (List diceArray, Card card) {
        int points = 0;
        points = (checkNumSide(diceArray, Global.DiceSide.SKULL) + (card.getType() == Global.CardTypes.SKULLS_CARD ? card.getNumSkulls() : 0)) *100;
        if (card.getType() == Global.CardTypes.CAPTAIN) {
            points = points * 2;
        }
        return points;
    }


    public int checkFullHouse (List<Dice> l, Card c) {
        int numDicePoints = 0;
        int score = 0;
        if (checkNumSide(l, Global.DiceSide.SKULL) != 0 ) {
            score = 0;
        }
        else {
            Map<Global.DiceSide, Integer> countMap = Global.countIdentical(l);
            System.out.println(countMap);
            for (Global.DiceSide d: countMap.keySet()) {
                if (countMap.get(d) < 3) {
                    if (d == Global.DiceSide.GOLD || d == Global.DiceSide.DIAMOND) {
                        System.out.print(d);
                        System.out.println(countMap.get(d));
                        numDicePoints += countMap.get(d);
                    } else if (d == Global.DiceSide.SWORD) {
                        if (card.getType() == Global.CardTypes.BATTLE) {
                            if (card.getNumSwords() == countMap.get(d)) {
                                numDicePoints += countMap.get(d);
                            }
                        }
                    } else if (d == Global.DiceSide.MONKEY || d == Global.DiceSide.PARROT) {
                        if (card.getType() == Global.CardTypes.MONKEY_CARD) {
                            if (countMap.get(Global.DiceSide.MONKEY) + countMap.get(Global.DiceSide.PARROT) >= 3) {
                                numDicePoints += countMap.get(Global.DiceSide.MONKEY) + countMap.get(Global.DiceSide.PARROT);
                                countMap.put(d == Global.DiceSide.MONKEY? Global.DiceSide.PARROT: Global.DiceSide.MONKEY, 0);
                            }
                        }
                    }
                }
                else {
                    System.out.print(d);
                    System.out.println(countMap.get(d));
                    numDicePoints += countMap.get(d);
                }
            }
            if (numDicePoints >= 8) {
                score += 500;
                System.out.println("Added points for full house");
            }
        }
        System.out.println(numDicePoints);
        return score;
    }

    public int countPoints (List diceArray, Card card) {
        if (died(this.getDiceList(),card, islandOfSkulls)) {
            if (card.getType() != Global.CardTypes.CHEST) {
                return 0;
            }
        }
        int points = 0;
        Map<Global.DiceSide, Integer> countMap = Global.countIdentical(diceArray);

        if (card.getType() == Global.CardTypes.GOLD_CARD) {
            countMap.put(Global.DiceSide.GOLD, countMap.get(Global.DiceSide.GOLD) + 1);
        }

        if (card.getType() == Global.CardTypes.DIAMOND_CARD) {
            countMap.put(Global.DiceSide.DIAMOND, countMap.get(Global.DiceSide.DIAMOND) + 1);
        }

        if (card.getType() == Global.CardTypes.MONKEY_CARD) {
            points += (Global.identicalPoints.get(countMap.get(Global.DiceSide.MONKEY)
                    + (countMap.get(Global.DiceSide.PARROT))));
            System.out.println("Added points for Monkey card" + points);
        }
        else {
            points += (Global.identicalPoints.get(countMap.get(Global.DiceSide.MONKEY))
                    + Global.identicalPoints.get((countMap.get(Global.DiceSide.PARROT))));
            System.out.println("Added points for not Monkey card" + points);
        }

        for (Global.DiceSide d: countMap.keySet()) {
            if (d != Global.DiceSide.MONKEY && d != Global.DiceSide.PARROT && d != Global.DiceSide.SKULL) {
                points += Global.identicalPoints.get(countMap.get(d));
                System.out.println("Added points for sets of " + d + " " + points);
            }
        }

        points += (countMap.get(Global.DiceSide.GOLD) + countMap.get(Global.DiceSide.DIAMOND)) * 100;
        System.out.println("Added points for Gold and Diamond " + points + " " +
                (countMap.get(Global.DiceSide.GOLD) + countMap.get(Global.DiceSide.DIAMOND)));

        points += checkFullHouse(diceArray, card);

        if (card.getType() == Global.CardTypes.BATTLE && checkSeaBattle(diceArray, card)) {
            points += card.getSwordPoints();
        }

        if (card.getType() == Global.CardTypes.CAPTAIN) {
            points = points * 2;
            System.out.println("Added points for Captain " + points);
        }
        return points;
    }

    public boolean checkSeaBattle (List<Dice> l, Card card) {
        if (card.getType() == Global.CardTypes.BATTLE) {
            int numSword = checkNumSide(l, Global.DiceSide.SWORD);
            if (card.getNumSwords() > numSword || died(l, card, false)) {
                System.out.println(name + ": " + "Did not receive correct swords or died. Losing "
                        + card.getSwordPoints() + " points");
                return false;
            }
        }
        return true;
    }

    public boolean reRoll(int[] positions, Global.DiceSide[] diceArray) { // same functionality as reroll but for rigged version
        for (int i =0; i < positions.length; i++) {
            diceArrayList.get(positions[i]).setDice(diceArray[i]);
        }
        return true;
    }

    public boolean died (List<Dice> d, Card c, boolean islandOfSkulls) {
        int numSkulls = checkNumSide(d, Global.DiceSide.SKULL) + (c.getType() == Global.CardTypes.SKULLS_CARD? c.getNumSkulls() : 0);
        if (numSkulls >= 3 && !islandOfSkulls) { //Turn over because got more skulls
            System.out.println(name +": " + "You got three skulls. Turn Over");
            return true;
        }
        return false;
    }

    public boolean rollSorceres (Scanner sc, List<Dice> diceArray) {
        System.out.print(name +": " + "Please select which dice to reroll or -1 to exit. For example: 1 will set reroll 1st dice: ");
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
            if (number == -1) {
                return true;
            }
            if (diceArray.get(number).getDice() != Global.DiceSide.SKULL) {
                System.out.println(name +": " + "Please select a skull. Try again");
                return false;
            }
        } catch (Exception e) {
            System.out.println(name +": " + "Please try again");
            return false;
        }
        diceArray.get(number).roll();
        return true;
    }

    public boolean keepTOChest (Scanner sc, boolean flag) {
        String s = flag ? "take out" : "set aside";
        System.out.print(name +": " + "Please select which dice to " + s + ". For example: 1 will " + s + " 1st dice: ");
        try {
            String[] numberStrs = sc.nextLine().split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }
            if (numbers.length < 1 || numbers.length > 8) {
                System.out.println(name +": " + "Range should be between 1<=x<=8");
                return false;
            }
            else if ((flag? !this.setAside(numbers) : !this.returnDice(numbers))) {
                System.out.println(name +": " + "Sorry you are trying to " + s + " a skull or dice already " + s + ". Please try again");
                return false;
            }
        } catch (Exception e) {
            System.out.println(name +": " + "Please try again");
            return false;
        }
        return true;
    }

    public boolean riggedRoll (Scanner sc) {
        Global.DiceSide[] diceSideArray = Global.DiceSide.values();
        System.out.print(name +": " + "Please select sequence of dice: " + Arrays.toString(diceSideArray));
        List<Dice> dl = new ArrayList<>();
        try {
            String[] numberStrs = sc.nextLine().split(",");
            int[] numbers = new int[numberStrs.length];
            for (int i = 0; i < numberStrs.length; i++) {
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }
            if (numbers.length < 8) {
                System.out.println(name +": " + "8 dices required");
                return false;
            } else {
                for (int i: numbers) {
                    Dice d = new Dice();
                    d.setDice(diceSideArray[i]);
                    dl.add(d);
                }
            }
        } catch (Exception e) {
            System.out.println(name +": " + "Please try again");
            return false;
        }
        diceArrayList = dl;
        return true;
    }

    public boolean rollPlay (Scanner sc) {
        System.out.print(name +": " + "Please select which dice to re-roll. For example: 1,3,4,5 will roll 1st, 3rd, 4th and 5th dice: ");
        try {
            String[] numberStrs = sc.nextLine().split(",");
            int[] numbers = new int[numberStrs.length];
            for (int i = 0; i < numberStrs.length; i++) {
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }
            if (numbers.length < 2 || numbers.length > 8) {
                System.out.println(name +": " + "Range should be between 2<=x<=8");
                return false;
            } else if (!this.reRoll(numbers)) {
                System.out.println(name +": " + "Sorry you are trying to reroll a skull or a set asid dice. Please try again");
                return false;
            }
        } catch (Exception e) {
            System.out.println(name +": " + "Please try again");
            return false;
        }
        return true;
    }

    public void play () {
        System.out.println(name + ": Your turn start");
        Boolean isDead = false;
        Scanner sc = new Scanner(System.in);
        System.out.println(name +": " + "Picking a card");
        if (rigged) {
            System.out.println("Please select card " + Arrays.toString(Global.CardTypes.values()));
            int idx = Integer.parseInt(sc.nextLine());
            this.pickCard(Global.CardTypes.values()[idx]);
            if (this.card.getType() == Global.CardTypes.SKULLS_CARD) {
                System.out.println("Please select num skulls");
                int numSkulls = Integer.parseInt(sc.nextLine());
                this.card.setNumSkulls(numSkulls);
            }
        }
        else {
            this.pickCard();
        }
        Global.CardTypes cardType = card.getType();
        System.out.println(name +": " + "Card picked: " + this.getCard());
        System.out.println(name +": " + "Rolling the first dice");
        if (rigged) {
            this.riggedRoll(sc);
        }
        else {
            this.roll();
        }
        Global.printDiceList(diceArrayList);
        int numSkulls = checkNumSide(diceArrayList, Global.DiceSide.SKULL) + (cardType == Global.CardTypes.SKULLS_CARD? card.getNumSkulls() : 0);
        if (numSkulls > 3 && cardType != Global.CardTypes.BATTLE) {
            System.out.println(name +": " + "You have entered the island of skulls");
            islandOfSkulls = true;
        }

        while (true) {
            if (cardType == Global.CardTypes.SOCERESS && card.usedCard == false) {
                System.out.print(name +": " + "Do you want to use sorceress power? \"Yes\" or \"No\" : ");
                userResponse = sc.nextLine();
                if (userResponse.equals("Yes")) {
                    card.usedCard = true;
                    while(rigged? !this.riggedRoll(sc) :!rollSorceres(sc, diceArrayList)) {}
                    Global.printDiceList(diceArrayList);
                }
            }
            System.out.println(name +": " + "Num skulls: " + numSkulls);
            if (died(diceArrayList, card, islandOfSkulls)) { //Turn over because got more skulls
                isDead = true;
                break;
            }
            if (cardType == Global.CardTypes.CHEST) { // Keeping dice in chest
                System.out.print(name +": " + "Do you want set aside dice? \"Yes\" or \"No\" : ");
                userResponse = sc.nextLine();
                if (userResponse.equals("Yes")) {
                    while(!keepTOChest(sc, true)){}
                }
                System.out.print(name +": " + "Do you want set take out dice? \"Yes\" or \"No\" : ");
                userResponse = sc.nextLine();
                if (userResponse.equals("Yes")) {
                    while(!keepTOChest(sc, false)){}
                }
            }
            System.out.print(name +": " + "Do you want to re-roll the dice? \"Yes\" or \"No\" : ");
            userResponse = sc.nextLine();
            if (userResponse.equals("Yes")) {
                if (islandOfSkulls) {
                    System.out.println(name +": " + "Playing Island of skulls");
                    if (rigged? this.riggedRoll(sc) : this.rollPlay(sc)) {
                        System.out.println(name +": " + "Rolled inside island of dice");
                        int newNumSkulls = checkNumSide(diceArrayList, Global.DiceSide.SKULL);
                        if (!(newNumSkulls > numSkulls)) {
                            System.out.println(name +": " + "You received less skulls. Kicking out of Island of Skulls");
                            lastScore = islandOfSkullsPoints(diceArrayList, card);
                            break;
                        }
                    }
                }
                else {
                    if (rigged) {
                        this.riggedRoll(sc);
                    }
                    else {
                        this.rollPlay(sc);
                    }
                }
            }
            else {
                lastScore = islandOfSkullsPoints(diceArrayList, card);
                Global.printDiceList(diceArrayList);
                break;
            }
            numSkulls = checkNumSide(diceArrayList, Global.DiceSide.SKULL) + (cardType == Global.CardTypes.SKULLS_CARD? card.getNumSkulls() : 0);
            Global.printDiceList(diceArrayList);
        }
        System.out.println("Previous score: " + score);
        if (!islandOfSkulls) {
            if (cardType == Global.CardTypes.CHEST && isDead) {
                score += countPoints(card.getList(), card);
            }
            else if (checkSeaBattle(diceArrayList, card)) {
                score += countPoints(diceArrayList, card);
            }
            else {
                System.out.println("You received less swords. All dices ignored and " + card.getSwordPoints()
                        + " deducted from your score" );
                this.deductScore(card.getSwordPoints());
            }
        }
        System.out.println(name + ": Your turn ended. Waiting for other players to finish");
        System.out.println(name + ": " + "Your score is: " + score);
        System.out.println("");
    }
}