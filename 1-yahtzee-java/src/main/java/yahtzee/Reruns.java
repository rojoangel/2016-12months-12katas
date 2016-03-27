package yahtzee;

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

    private Dice[] obtainDiceToRoll() {
        InputLine inputLine = new InputLine(this.userInputReader.readLine());
        return inputLine.diceToRoll();
    }

    private void roll(Dice... dice) {
        this.diceRoller.roll(dice);
        this.notifier.notifyRolledDice(this.diceRoller.lastRolledDice());
    }
}
