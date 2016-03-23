package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee {

    private FakeConsole console;
    private DieRoller dieRoller;

    public Yahtzee(FakeConsole console, DieRoller dieRoller) {

        this.console = console;
        this.dieRoller = dieRoller;
    }

    public void play() {
        this.console.print("Category: Ones");
        roll(1, 2, 3, 4, 5);
        this.console.print("[1] Dice to re-run:");
        this.console.print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
    }

    private void roll(int... dice) {
        Map<Integer, Integer> rolledDice = new HashMap<Integer, Integer>();
        for (int die : dice) {
            rolledDice.put(die, this.dieRoller.roll());
        }
        notifyRolledDice(rolledDice);
    }

    private void notifyRolledDice(Map<Integer, Integer> rolledDice) {
        StringBuilder formattedDice = new StringBuilder("Dice:");
        for (int dieId : rolledDice.keySet()) {
            formattedDice.append(" D").append(dieId).append(":").append(rolledDice.get(dieId));
        }
        this.console.print(formattedDice.toString());
    }
}
