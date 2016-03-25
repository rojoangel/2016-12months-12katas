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

    public class Reruns {

        private ConsoleNotifier notifier;
        private UserInputReader userInputReader;
        private DiceRoller diceRoller;

        public Reruns(
                ConsoleNotifier notifier,
                UserInputReader userInputReader,
                DiceRoller diceRoller) {
            this.notifier = notifier;
            this.userInputReader = userInputReader;
            this.diceRoller = diceRoller;
        }

        public void doReruns(int numReruns) {
            for (int rerunsSoFar = 0; rerunsSoFar < numReruns; rerunsSoFar++) {
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
            this.notifier.notifyRolledDice(Categories.this.diceRoller.lastRolledDice());
        }
    }
}
