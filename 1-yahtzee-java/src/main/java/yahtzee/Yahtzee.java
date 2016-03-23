package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee {

    private FakeConsole console;
    private DieRoller dieRoller;
    private ConsoleNotifier notifier;

    public Yahtzee(FakeConsole console, DieRoller dieRoller, ConsoleNotifier notifier) {

        this.console = console;
        this.dieRoller = dieRoller;
        this.notifier = notifier;
    }

    public void play() {
        this.console.print("Category: Ones");
        roll(1, 2, 3, 4, 5);
        this.console.print("[1] Dice to re-run:");
        this.notifier.notifyRolledDice(generateRolledDice());
    }

    private void roll(int... dice) {
        Map<Integer, Integer> rolledDice = new HashMap<Integer, Integer>();
        for (int die : dice) {
            rolledDice.put(die, this.dieRoller.roll());
        }
        this.notifier.notifyRolledDice(rolledDice);
    }

    private Map<Integer, Integer> generateRolledDice() {
        Map<Integer, Integer> rolledDice = new HashMap<Integer, Integer>();
        rolledDice.put(1, 1);
        rolledDice.put(2, 5);
        rolledDice.put(3, 1);
        rolledDice.put(4, 2);
        rolledDice.put(5 ,1);
        return rolledDice;
    }

}
