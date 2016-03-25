package yahtzee;

public class RandomizedDieRoller implements DieRoller {
    public int roll() {
        return (int)(Math.random()*6) + 1;
    }
}
