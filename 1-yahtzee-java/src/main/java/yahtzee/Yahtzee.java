package yahtzee;

import java.util.*;

public class Yahtzee {

    public static final int NUM_RERUNS = 2;
    private ConsoleNotifier notifier;
    private UserInputReader userInputReader;
    private DiceRoller diceRoller;
    private ScoresHistory scoresHistory;
    private Categories categories;

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
        this.categories = new Categories();
    }

    public void play() {
        new Categories().play();
        summarizeScores();
    }

    private void summarizeScores() {
        this.notifier.notifyGameScore(scoresHistory.maxScoresByCategory(), scoresHistory.finalScore());
    }

    private class Categories {
        public void play() {
            for (Category category : Category.values()) {
                Yahtzee.this.notifier.notifyCurrentCategory(category);
                roll(Die.values());
                doReruns();
                int score = category.computeScore(lastRolledDice());
                Yahtzee.this.scoresHistory.annotateScore(category, score);
                Yahtzee.this.notifier.notifyCategoryScore(category, score);
            }
        }

        private void roll(Die... dice) {
            Yahtzee.this.diceRoller.roll(dice);
            Yahtzee.this.notifier.notifyRolledDice(lastRolledDice());
        }

        private void doReruns() {
            for (int rerunsSoFar = 0; rerunsSoFar < NUM_RERUNS; rerunsSoFar++) {
                Yahtzee.this.notifier.notifyUserToIntroduceDiceToRerun(rerunsSoFar);
                roll(obtainDiceToRoll());
            }
        }

        private Die[] obtainDiceToRoll() {
            InputLine inputLine = new InputLine(Yahtzee.this.userInputReader.readLine());
            return inputLine.diceToRoll();
        }

        private Map<Die, Integer> lastRolledDice() {
            return diceRoller.getRollResult();
        }

    }
}
