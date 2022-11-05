package core;


import java.io.Serializable;

public class Dice implements Serializable {
    Global.DiceSide side = null;
    public boolean setAside = false;

    public void setDice(Global.DiceSide side) {
        this.side = side;
    }

    public Global.DiceSide getDice() {
        return this.side;
    }

    public void roll () {
        this.side = Global.randomEnum(Global.DiceSide.class);
    }

    @Override
    public String toString() {
        return side.name();
    }
}
