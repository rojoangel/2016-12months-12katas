package yahtzee;

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
        this.categories = new Categories(notifier, userInputReader, diceRoller, scoresHistory);
    }

    public void play() {
        this.categories.play(NUM_RERUNS);
        summarizeScores();
    }

    private void summarizeScores() {
        this.notifier.notifyGameScore(scoresHistory.maxScoresByCategory(), scoresHistory.finalScore());
    }
}
