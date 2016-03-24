package yahtzee;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiceRoller {

    private DieRoller dieRoller;
    private Map<Die, Integer> rollResult;

    public DiceRoller(DieRoller dieRoller) {
        this.rollResult = new LinkedHashMap<Die, Integer>();
        this.dieRoller = dieRoller;
    }

    public void roll(Die... dice) {
        for (Die die : dice) {
            rollResult.put(die, this.dieRoller.roll());
        }
    }

    public Map<Die, Integer> getRollResult() {
        return this.rollResult;
    }
}
