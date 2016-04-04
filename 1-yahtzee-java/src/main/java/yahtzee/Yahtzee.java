package yahtzee;

public class Yahtzee {

    public static final int NUM_RERUNS = 2;
    private ConsoleNotifier notifier;
    private ScoresHistory scoresHistory;
    private GameFlow gameFlow;

    public Yahtzee(
            ConsoleNotifier notifier,
            ScoresHistory scoresHistory,
            GameFlow gameFlow
    ) {
        this.notifier = notifier;
        this.scoresHistory = scoresHistory;
        this.gameFlow = gameFlow;
    }

    public void play() {
        this.gameFlow.play(NUM_RERUNS);
        summarizeScores();
    }

    private void summarizeScores() {
        this.notifier.notifyGameScore(scoresHistory.maxScoresByCategory(), scoresHistory.finalScore());
    }
}
