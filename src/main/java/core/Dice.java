package core;

public class Dice {
    Global.DiceSide side;

    public void setDice(Global.DiceSide side) {
        this.side = side;
    }

    public Global.DiceSide getDice() {
        return this.side;
    }

    public void roll () {
        this.side = Global.randomEnum(Global.DiceSide.class);
    }
}
