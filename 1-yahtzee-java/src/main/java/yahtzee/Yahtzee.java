package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee {

    private FakeConsole console;
    private DieRoller dieRoller;
    private ConsoleNotifier notifier;
    private UserInputReader userInputReader;
    private DiceRoller diceRoller;

    public Yahtzee(
            FakeConsole console,
            DieRoller dieRoller,
            ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller
    ) {

        this.console = console;
        this.dieRoller = dieRoller;
        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.diceRoller = diceRoller;
    }

    public void play() {
        this.console.print("Category: Ones");
        roll(1, 2, 3, 4, 5);
        this.console.print("[1] Dice to re-run:");
        String diceToRoll = this.userInputReader.readLine();
        this.notifier.notifyRolledDice(generateRolledDice());
    }

    private void roll(int... dice) {
        this.diceRoller.roll(dice);
        Map<Integer, Integer> rolledDice = diceRoller.getRollResult();
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
