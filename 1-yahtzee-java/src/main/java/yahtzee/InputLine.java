package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class InputLine {

    private String line;

    public InputLine(String line) {
        this.line = line;
    }

    public Die[] diceToRoll() {
        String[] splittedUserInput = this.line.split(" ");
        List<Die> userInputDice = new ArrayList<Die>();
        for (String userEnteredDie : splittedUserInput) {
            userInputDice.add(Die.valueOf(userEnteredDie));
        }
        return userInputDice.toArray(new Die[userInputDice.size()]);

    }
}
