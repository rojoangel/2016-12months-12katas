package yahtzee;

public class CommandLineYahtzee {

    private Yahtzee yahtzee;

    public CommandLineYahtzee() {
            Console console = new CommandLineConsole();
            ConsoleNotifier notifier = new ConsoleNotifier(console);
            ScoresHistory scoresHistory = new InMemoryScoresHistory();
            DieRoller dieRoller = new RandomizedDieRoller();
            DiceRoller diceRoller = new DiceRoller(dieRoller);
            UserInputReader userInputReader = new CommandLineUserInputReader();
            Reruns reruns = new Reruns(notifier, userInputReader, diceRoller);
            Categories categories = new Categories(notifier, diceRoller, scoresHistory, reruns);
            this.yahtzee = new Yahtzee(notifier, scoresHistory, categories);
    }

    public void play() {
        this.yahtzee.play();
    }

    public static void main(String[] args) {
        new CommandLineYahtzee().play();
    }

}
