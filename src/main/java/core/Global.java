package core;
import java.util.*;

public class Global {
    public static enum CardTypes {
        CHEST,CAPTAIN,SOCERESS,BATTLE,GOLD_CARD,DIAMOND_CARD,MONKEY_CARD,SKULLS_CARD
    }

    public static enum DiceSide {
        SKULL,SWORD,MONKEY,DIAMOND,GOLD,PARROT
    }

    // taken from https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random r = new Random();
        int x = r.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
