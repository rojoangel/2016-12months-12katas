package yahtzee;

import java.util.*;

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
        String userInput = this.userInputReader.readLine();
        String[] splittedUserInput = userInput.split(" ");
        List<Die> diceToRoll = new ArrayList<Die>();
        for (String userEnteredDie : splittedUserInput) {
            diceToRoll.add(Die.valueOf(userEnteredDie));
        }
        roll(diceToRoll.toArray(new Die[diceToRoll.size()]));
    }

    private void roll(Die... dice) {
        this.diceRoller.roll(dice);
        Map<Die, Integer> rolledDice = diceRoller.getRollResult();
        this.notifier.notifyRolledDice(rolledDice);
    }
}
