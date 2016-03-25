package yahtzee;

import java.util.Map;

public class Categories {
    private ConsoleNotifier notifier;
    private ScoresHistory scoresHistory;
    private DiceRoller diceRoller;
    private UserInputReader userInputReader;

    public Categories(
            ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller,
            ScoresHistory scoresHistory) {
        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.scoresHistory = scoresHistory;
        this.diceRoller = diceRoller;
    }

    public void play(int numReruns) {
        for (Category category : Category.values()) {
            this.notifier.notifyCurrentCategory(category);
            roll(Die.values());
            doReruns(numReruns);
            int score = category.computeScore(lastRolledDice());
            this.scoresHistory.annotateScore(category, score);
            this.notifier.notifyCategoryScore(category, score);
        }
    }

    private void roll(Die... dice) {
        this.diceRoller.roll(dice);
        this.notifier.notifyRolledDice(lastRolledDice());
    }

    private void doReruns(int numReruns) {
        for (int rerunsSoFar = 0; rerunsSoFar < numReruns; rerunsSoFar++) {
            this.notifier.notifyUserToIntroduceDiceToRerun(rerunsSoFar);
            roll(obtainDiceToRoll());
        }
    }

    private Die[] obtainDiceToRoll() {
        InputLine inputLine = new InputLine(this.userInputReader.readLine());
        return inputLine.diceToRoll();
    }

    private Map<Die, Integer> lastRolledDice() {
        return this.diceRoller.getRollResult();
    }

}
