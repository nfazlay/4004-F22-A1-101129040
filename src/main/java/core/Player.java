package core;
import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    private String name = "";
    private boolean islandOfSkulls;
    private List<Dice> diceArrayList = new ArrayList<Dice>(8);
    private Card card = null;
    private int score;
    private int lastScore;

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
        Global.CardTypes cardType = Global.CardTypes.SKULLS_CARD;
        if (cardType == Global.CardTypes.CHEST) {
            this.card = new TreasureChest(cardType);
        }
        else if (cardType == Global.CardTypes.SOCERESS) {
            this.card = new Sorceres(cardType);
        }
        else if (cardType == Global.CardTypes.SKULLS_CARD) {
            this.card = new Skulls(cardType);
        }
        else {
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

    public void setIslandOfSkulls (boolean b) {
        this.islandOfSkulls = b;
    }

    public boolean getIslandOfSkulls () {
        return this.islandOfSkulls;
    }

    public void roll() {
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

    public int checkSkulls (List<Dice> list) {
        int count  = 0;
        for (int i =0; i < list.size(); i ++) {
            if (list.get(i).getDice() == Global.DiceSide.SKULL) {
                count++;
            }
        }
        return count;
    }

    public int countPoints (List diceArray, Card card, boolean islandOfSkulls) {
        int points = 0;
        if(islandOfSkulls) {
            points = checkSkulls(diceArray)*100;
        }
        else {}
        if (card.getType() == Global.CardTypes.CAPTAIN) {
            points = points*2;
        }
        return points;
    }

    public boolean reRoll(int[] positions, Global.DiceSide[] diceArray) { // same functionality as reroll but for rigged version
        for (int position : positions) {
            if (diceArrayList.get(position).getDice() == Global.DiceSide.SKULL) {
                return false;
            }
        }
        for (int i =0; i < positions.length; i++) {
            diceArrayList.get(positions[i]).setDice(diceArray[i]);
        }
        return true;
    }

    public boolean rollSorceres (Scanner sc, List<Dice> diceArray) {
        System.out.print("Please select which dice to reroll or -1 to exit. For example: 1 will set reroll 1st dice: ");
        int number = Integer.parseInt(sc.nextLine());
        if (number == -1) {
            return true;
        }
        try {
            if (diceArray.get(number).getDice() != Global.DiceSide.SKULL) {
                System.out.println("Please select a skull. Try again");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Please try again");
            return false;
        }
        diceArray.get(number).roll();
        return true;
    }

    public boolean keepTOChest (Scanner sc) {
        System.out.print("Please select which dice to set aside. For example: 1 will set aside 1st dice: ");
        String[] numberStrs = sc.nextLine().split(",");
        int[] numbers = new int[numberStrs.length];
        for(int i = 0;i < numberStrs.length;i++)
        {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }
        if (numbers.length != 1) {
            System.out.println("Select only one dice");
            return false;
        }
        else if (!this.setAside(numbers)) {
            System.out.println("Sorry you are trying to set aside a skull or dice already set aside. Please try again");
            return false;
        }
        return true;
    }

    public boolean rollPlay (Scanner sc) {
        System.out.print("Please select which dice to re-roll. For example: 1,3,4,5 will roll 1st, 3rd, 4th and 5th dice: ");
        String[] numberStrs = sc.nextLine().split(",");
        int[] numbers = new int[numberStrs.length];
        for(int i = 0;i < numberStrs.length;i++)
        {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }
        if (numbers.length < 2 || numbers.length > 8) {
            System.out.println("Range should be between 2<=x<=8");
            return false;
        }
        else if (!this.reRoll(numbers)) {
            System.out.println("Sorry you are trying to reroll a skull or a set asid dice. Please try again");
            return false;
        }
        return true;
    }


    public void play () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Picking a card");
        this.pickCard();
        Global.CardTypes cardType = card.getType();
        System.out.println("Card picked: " + this.getCard());
        System.out.println("Rolling the first dice");
        this.roll();
        Global.printDiceList(diceArrayList);
        int numSkulls = checkSkulls(diceArrayList) + (cardType == Global.CardTypes.SKULLS_CARD? card.getNumSkulls() : 0);
        if (numSkulls > 3 && cardType != Global.CardTypes.BATTLE) {
            System.out.println("You have entered the island of skulls");
            islandOfSkulls = true;
        }

        while (true) {
            if (cardType == Global.CardTypes.SOCERESS && card.usedCard == false) {
                System.out.print("Do you want to use sorceress power? \"Yes\" or \"No\" : ");
                userResponse = sc.nextLine();
                if (userResponse.equals("Yes")) {
                    card.usedCard = true;
                    while(!rollSorceres(sc, diceArrayList)) {}
                    Global.printDiceList(diceArrayList);
                }
            }
            System.out.println("Num skulls: " + numSkulls);
            if (numSkulls >= 3 && !islandOfSkulls) { //Turn over because got more skulls
                System.out.println("You got three skulls. Turn Over");
                break;
            }
            if (cardType == Global.CardTypes.CHEST) { // Keeping dice in chest
                System.out.print("Do you want set aside dice? \"Yes\" or \"No\" : ");
                userResponse = sc.nextLine();
                if (userResponse.equals("Yes")) {
                    while(!keepTOChest(sc)){};
                }
            }
            System.out.print("Do you want to re-roll the dice? \"Yes\" or \"No\" : ");
            userResponse = sc.nextLine();
            if (userResponse.equals("Yes")) {
                if (islandOfSkulls) {
                    System.out.println("Playing Island of skulls");
                    if (this.rollPlay(sc)) {
                        System.out.println("Rolled inside island of dice");
                        int newNumSkulls = checkSkulls(diceArrayList);
                        if (!(newNumSkulls > numSkulls)) {
                            System.out.println("You received less skulls. Kicking out of Island of Skulls");
                            break;
                        }
                    }
                }
                else {
                    if (this.rollPlay(sc)) {

                    }
                }
            }
            else {
                Global.printDiceList(diceArrayList);
                break;
            }
            numSkulls = checkSkulls(diceArrayList) + (cardType == Global.CardTypes.SKULLS_CARD? card.getNumSkulls() : 0);
            Global.printDiceList(diceArrayList);
        }
    }
}