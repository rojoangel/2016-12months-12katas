package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class DiceRoller {

    private DieRoller dieRoller;
    private Map<Integer, Integer> rollResult;

    public DiceRoller(DieRoller dieRoller) {

        this.dieRoller = dieRoller;
    }

    public void rollAll() {
        this.roll(1, 2, 3, 4, 5);
    }

    public void roll(int... dice) {
        this.rollResult = new HashMap<Integer, Integer>();
        for (int die : dice) {
            rollResult.put(die, this.dieRoller.roll());
        }
    }

    public Map<Integer,Integer> getRollResult() {
        return this.rollResult;
    }
}
