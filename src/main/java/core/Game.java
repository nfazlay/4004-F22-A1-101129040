package core;
import java.util.*;

public class Game {

    public int checkSkulls (List<Dice> list) {
        int count  = 0;
        for (int i =0; i < list.size(); i ++) {
            if (list.get(i).getDice() == Global.DiceSide.SKULL) {
                count++;
            }
        }
        return count;
    }
}
