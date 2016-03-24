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
        playAllCategories();
        summarizeScores();
    }

    private void playAllCategories() {
        for (Category category : Category.values()) {
            playCategory(category);
        }
    }

    private void playCategory(Category category) {
        showCategory(category);
        rollAllDice();
        doReruns();
        int score = computeScore(category);
        anotateScore(category, score);
        showCategoryScore(category, score);
    }

    private void summarizeScores() {
        this.notifier.notifyGameScore(scoresHistory.maxScoresByCategory(), scoresHistory.finalScore());
    }
    
    private void showCategoryScore(Category category, int score) {
        this.notifier.notifyCategoryScore(category, score);
    }

    private int computeScore(Category category) {
        return category.computeScore(lastRolledDice());
    }

    private void rollAllDice() {
        roll(Die.values());
    }

    private void showCategory(Category category) {
        this.notifier.notifyCurrentCategory(category);
    }

    private void anotateScore(Category category, int score) {
        this.scoresHistory.annotateScore(category, score);
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
