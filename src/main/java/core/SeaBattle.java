package core;

import java.util.ArrayList;
import java.util.List;

public class SeaBattle extends Card {
    public SeaBattle(Global.CardTypes type) {
        super(type);
    }

    private int numSwords = (Math.random() <= 0.5) ? 4 : 5;
    private int swordPoints = (Math.random() <= 0.5) ? 500 : 1000;

    @Override
    public void setNumSwords (int n) {
        numSwords = n;
    }

    @Override
    public int getNumSwords () {
        return numSwords;
    }

    @Override
    public int getSwordPoints () {
        return swordPoints;
    }

    @Override
    public void setSwordPoints (int n) {
        swordPoints = n;
    }

    @Override
    public String toString() {
        return super.getType().name() + " " + numSwords + " " + swordPoints;
    }
}