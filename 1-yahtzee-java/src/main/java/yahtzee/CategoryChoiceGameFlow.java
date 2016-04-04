package yahtzee;

public class CategoryChoiceGameFlow implements GameFlow {
    private final ConsoleNotifier notifier;
    private final DiceRoller diceRoller;
    private final ScoresHistory scoresHistory;
    private final Reruns reruns;

    public CategoryChoiceGameFlow(ConsoleNotifier notifier, DiceRoller diceRoller, ScoresHistory scoresHistory, Reruns reruns) {
        this.notifier = notifier;
        this.diceRoller = diceRoller;
        this.scoresHistory = scoresHistory;
        this.reruns = reruns;
    }

    @Override
    public void play(int numReruns) {
        rollAll();
        this.reruns.doReruns(numReruns);
        this.notifier.notifyAvailableCategories();
    }

    private void rollAll() {
        this.diceRoller.roll(Die.values());
        this.notifier.notifyRolledDice(this.diceRoller.lastRolledDice());
    }
}
