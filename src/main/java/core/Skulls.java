package core;

import java.util.ArrayList;
import java.util.List;

public class Skulls extends Card {
    public Skulls(Global.CardTypes type) {
        super(type);
    }

    public int numSkulls = (Math.random() <= 0.5) ? 1 : 2 ;

    public void setNumSkulls (int skulls) {
        numSkulls = skulls;
    }

    public int getNumSkulls() {
        return numSkulls;
    }

    @Override
    public String toString() {
        return super.getType().name() + " " + numSkulls;
    }

}
