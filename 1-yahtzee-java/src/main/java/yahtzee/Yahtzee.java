package yahtzee;

import java.util.*;

public class Yahtzee {

    public static final int NUM_RERUNS = 2;
    private ConsoleNotifier notifier;
    private UserInputReader userInputReader;
    private DiceRoller diceRoller;
    private ScoresHistory scoresHistory;

    public Yahtzee(
            ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller,
            ScoresHistory scoresHistory
    ) {
        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.diceRoller = diceRoller;
        this.scoresHistory = scoresHistory;
    }

    public void play() {
        new Categories().play();
        summarizeScores();
    }

    private void playCategory(Category category) {
        this.notifier.notifyCurrentCategory(category);
        roll(Die.values());
        doReruns();
        int score = category.computeScore(lastRolledDice());
        this.scoresHistory.annotateScore(category, score);
        this.notifier.notifyCategoryScore(category, score);
    }

    private void summarizeScores() {
        this.notifier.notifyGameScore(scoresHistory.maxScoresByCategory(), scoresHistory.finalScore());
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

    private class Categories {
        public void play() {
            for (Category category : Category.values()) {
                playCategory(category);
            }
        }
    }
}
