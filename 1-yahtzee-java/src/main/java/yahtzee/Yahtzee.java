package yahtzee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

public class Yahtzee {

    private FakeConsole console;
    private ConsoleNotifier notifier;
    private UserInputReader userInputReader;
    private DiceRoller diceRoller;

    public Yahtzee(
            FakeConsole console,
            ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller
    ) {

        this.console = console;
        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.diceRoller = diceRoller;
    }

    public void play() {
        this.console.print("Category: Ones");
        roll(Die.D1, Die.D2, Die.D3, Die.D4, Die.D5);
        this.console.print("[1] Dice to re-run:");
        String diceToRoll = this.userInputReader.readLine();
        this.notifier.notifyRolledDice(generateRolledDice());
    }

    private void roll(Die... dice) {
        this.diceRoller.roll(dice);
        Map<Die, Integer> rolledDice = diceRoller.getRollResult();
        this.notifier.notifyRolledDice(rolledDice);
    }

    private Map<Die, Integer> generateRolledDice() {
        Map<Die, Integer> rolledDice = new LinkedHashMap<Die, Integer>();
        rolledDice.put(Die.D1, 1);
        rolledDice.put(Die.D2, 5);
        rolledDice.put(Die.D3, 1);
        rolledDice.put(Die.D4, 2);
        rolledDice.put(Die.D5 ,1);
        return rolledDice;
    }

}
