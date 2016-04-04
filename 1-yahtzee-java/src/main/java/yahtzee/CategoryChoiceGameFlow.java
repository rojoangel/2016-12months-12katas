package yahtzee;

public class CategoryChoiceGameFlow implements GameFlow {
    private final ConsoleNotifier notifier;
    private final DiceRoller diceRoller;
    private final ScoresHistory scoresHistory;
    private final Reruns reruns;
    private CategoryRequester categoryRequester;

    public CategoryChoiceGameFlow(
        ConsoleNotifier notifier,
        DiceRoller diceRoller,
        ScoresHistory scoresHistory,
        Reruns reruns,
        CategoryRequester categoryRequester) {
        this.notifier = notifier;
        this.diceRoller = diceRoller;
        this.scoresHistory = scoresHistory;
        this.reruns = reruns;
        this.categoryRequester = categoryRequester;
    }

    @Override
    public void play(int numReruns) {
        rollAll();
        this.reruns.doReruns(numReruns);
        categoryRequester.requestCategory();
    }

    private void rollAll() {
        this.diceRoller.roll(Die.values());
        this.notifier.notifyRolledDice(this.diceRoller.lastRolledDice());
    }
}
