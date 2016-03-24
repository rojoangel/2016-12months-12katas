package yahtzee;

import java.util.*;

public class Yahtzee {

    public static final int NUM_RERUNS = 2;
    private ConsoleNotifier notifier;
    private UserInputReader userInputReader;
    private DiceRoller diceRoller;

    public Yahtzee(
            ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller
    ) {

        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.diceRoller = diceRoller;
    }

    public void play() {
        for (Category category : Category.values()) {
            playCategory(category);
        }
    }

    private void playCategory(Category category) {
        this.notifier.notifyCurrentCategory(category);
        roll(Die.D1, Die.D2, Die.D3, Die.D4, Die.D5);
        doReruns();
        this.notifier.notifyCategoryScore(category, computeScore(category));
    }

    private int computeScore(Category category) {
        return new DiceScorer(category).computeScore(lastRolledDice());
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
