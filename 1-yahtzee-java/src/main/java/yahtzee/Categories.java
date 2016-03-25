package yahtzee;

public class Categories {
    private ConsoleNotifier notifier;
    private ScoresHistory scoresHistory;
    private DiceRoller diceRoller;
    private UserInputReader userInputReader;
    private Reruns reruns;

    public Categories(
            ConsoleNotifier notifier,
            UserInputReader userInputReader,
            DiceRoller diceRoller,
            ScoresHistory scoresHistory) {
        this.notifier = notifier;
        this.userInputReader = userInputReader;
        this.scoresHistory = scoresHistory;
        this.diceRoller = diceRoller;
        this.reruns = new Reruns(notifier, userInputReader, diceRoller);
    }

    public void play(int numReruns) {
        for (Category category : Category.values()) {
            this.notifier.notifyCurrentCategory(category);
            rollAll();
            this.reruns.doReruns(numReruns);
            int score = category.computeScore(this.diceRoller.lastRolledDice());
            this.scoresHistory.annotateScore(category, score);
            this.notifier.notifyCategoryScore(category, score);
        }
    }

    private void rollAll() {
        this.diceRoller.roll(Die.values());
        this.notifier.notifyRolledDice(this.diceRoller.lastRolledDice());
    }
}
