package yahtzee;

public class Categories {
    private ConsoleNotifier notifier;
    private ScoresHistory scoresHistory;
    private DiceRoller diceRoller;
    private Reruns reruns;

    public Categories(
            ConsoleNotifier notifier,
            DiceRoller diceRoller,
            ScoresHistory scoresHistory,
            Reruns reruns
    ) {
        this.notifier = notifier;
        this.scoresHistory = scoresHistory;
        this.diceRoller = diceRoller;
        this.reruns = reruns;
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
        this.diceRoller.roll(Dice.values());
        this.notifier.notifyRolledDice(this.diceRoller.lastRolledDice());
    }
}
