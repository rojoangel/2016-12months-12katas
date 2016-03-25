package yahtzee;

public class Yahtzee {

    public static final int NUM_RERUNS = 2;
    private ConsoleNotifier notifier;
    private ScoresHistory scoresHistory;
    private Categories categories;

    public Yahtzee(
            ConsoleNotifier notifier,
            ScoresHistory scoresHistory,
            Categories categories
    ) {
        this.notifier = notifier;
        this.scoresHistory = scoresHistory;
        this.categories = categories;
    }

    public void play() {
        this.categories.play(NUM_RERUNS);
        summarizeScores();
    }

    private void summarizeScores() {
        this.notifier.notifyGameScore(scoresHistory.maxScoresByCategory(), scoresHistory.finalScore());
    }
}
