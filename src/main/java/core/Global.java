package core;
import java.util.*;

public class Global {

    public static final int NUMPLAYER = 3;

    public static Map<Integer, Integer> identicalPoints = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 0);
        put(2, 0);
        put(3, 100);
        put(4, 200);
        put(5, 500);
        put(6, 1000);
        put(7, 2000);
        put(8, 4000);
    }};

    public static enum CardTypes {
        CHEST,CAPTAIN,SOCERESS,BATTLE,GOLD_CARD,DIAMOND_CARD,MONKEY_CARD,SKULLS_CARD
    }

    public static enum DiceSide {
        SKULL,SWORD,MONKEY,DIAMOND,GOLD,PARROT
    }

    public static Map countIdentical (List<Dice> d) {
        Map<DiceSide, Integer> countMap = new HashMap<DiceSide, Integer>();
        DiceSide[] dSideArr = DiceSide.values();
        for(DiceSide dSide: dSideArr) {
            countMap.put(dSide, 0);
        }
        for(Dice dice: d) {
            DiceSide tempSide = dice.getDice();
            countMap.put(tempSide, countMap.get(tempSide) + 1);
        }
        return countMap;
    }

    // taken from https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random r = new Random();
        int x = r.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static Player highestScore(List<Player> l) {
        Player p = l.get(0);
        for (Player pl: l) {
            if (pl.getScore() > p.getScore()) {
                p = pl;
            }
        }
        return p;
    }

    public static boolean printDiceList (List list) {
        System.out.println("Dices:");
        String format = "";
        List<Integer> idx = new ArrayList<Integer>();
        for (int i =0; i < list.size(); i++) {
            idx.add(i);
            format += "%10s";
        }
        format += "\n";
        System.out.format(format,idx.toArray());
        System.out.format(format,list.toArray());

        return true;
    }
}
