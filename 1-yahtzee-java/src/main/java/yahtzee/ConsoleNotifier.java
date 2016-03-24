package yahtzee;

import java.util.Map;

public class ConsoleNotifier {
    private final Console console;

    public ConsoleNotifier(Console console) {
        this.console = console;
    }

    void notifyRolledDice(Map<Die, Integer> rolledDice) {
        StringBuilder formattedDice = new StringBuilder("Dice:");
        for (Die die : rolledDice.keySet()) {
            formattedDice.append(" ")
                    .append(die)
                    .append(":")
                    .append(rolledDice.get(die));
        }
        this.console.print(formattedDice.toString());
    }
}