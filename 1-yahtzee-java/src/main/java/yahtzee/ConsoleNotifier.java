package yahtzee;

import java.util.Map;

public class ConsoleNotifier {
    private final Console console;

    public ConsoleNotifier(Console console) {
        this.console = console;
    }

    void notifyRolledDice(Map<Integer, Integer> rolledDice) {
        StringBuilder formattedDice = new StringBuilder("Dice:");
        for (int dieId : rolledDice.keySet()) {
            formattedDice.append(" D").
                    append(dieId).
                    append(":").
                    append(rolledDice.get(dieId));
        }
        this.console.print(formattedDice.toString());
    }
}