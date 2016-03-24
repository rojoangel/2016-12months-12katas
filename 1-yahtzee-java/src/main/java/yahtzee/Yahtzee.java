package yahtzee;

import java.util.*;

public class Yahtzee {

    public static final int NUM_RERUNS = 2;
    private ConsoleNotifier notifier;
    private UserInputReader userInputReader;
    private DiceRoller diceRoller;
    private Console console;
    private Map<Category, Integer> scoresHistory;

    public Yahtzee(
            Console console, ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller
    ) {
        this.console = console;
        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.diceRoller = diceRoller;
        this.scoresHistory = new LinkedHashMap<Category, Integer>();
    }

    public void play() {
        for (Category category : Category.values()) {
            playCategory(category);
        }
        summarizeScores();
    }

    private void summarizeScores() {
        this.console.print("Yahtzee score");
        this.console.print(Category.Ones + ": " + this.scoresHistory.get(Category.Ones));
        this.console.print(Category.Twos + ": " + this.scoresHistory.get(Category.Twos));
        this.console.print(Category.Threes + ": " + this.scoresHistory.get(Category.Threes));
        this.console.print("Final score: 9");
    }

    private void playCategory(Category category) {
        this.notifier.notifyCurrentCategory(category);
        roll(Die.D1, Die.D2, Die.D3, Die.D4, Die.D5);
        doReruns();
        int score = category.computeScore(lastRolledDice());
        anotateScore(category, score);
        this.notifier.notifyCategoryScore(category, score);
    }

    private void anotateScore(Category category, int score) {
        this.scoresHistory.put(category, score);
    }

    private void doReruns() {
        for (int rerunsSoFar = 0; rerunsSoFar < NUM_RERUNS; rerunsSoFar++) {
            this.notifier.notifyUserToIntroduceDiceToRerun(rerunsSoFar);
            roll(obtainDiceToRoll());
        }
    }

    private Die[] obtainDiceToRoll() {
        InputLine inputLine = new InputLine(this.userInputReader.readLine());
        return inputLine.diceToRoll();
    }

    private void roll(Die... dice) {
        this.diceRoller.roll(dice);
        this.notifier.notifyRolledDice(lastRolledDice());
    }

    private Map<Die, Integer> lastRolledDice() {
        return diceRoller.getRollResult();
    }
}
