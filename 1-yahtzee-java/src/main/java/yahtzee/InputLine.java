package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class InputLine {

    private String line;

    public InputLine(String line) {
        this.line = line;
    }

    public Dice[] diceToRoll() {
        String[] splittedUserInput = this.line.split(" ");
        List<Dice> userInputDice = new ArrayList<Dice>();
        for (String userEnteredDie : splittedUserInput) {
            userInputDice.add(Dice.valueOf(userEnteredDie));
        }
        return userInputDice.toArray(new Dice[userInputDice.size()]);

    }
}
