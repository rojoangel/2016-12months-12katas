package yahtzee;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiceRoller {

    private DieRoller dieRoller;
    private Map<Dice, Integer> rollResult;

    public DiceRoller(DieRoller dieRoller) {
        this.rollResult = new LinkedHashMap<Dice, Integer>();
        this.dieRoller = dieRoller;
    }

    public void roll(Dice... dice) {
        for (Dice die : dice) {
            rollResult.put(die, this.dieRoller.roll());
        }
    }

    public Map<Dice, Integer> lastRolledDice() {
        return this.rollResult;
    }
}
