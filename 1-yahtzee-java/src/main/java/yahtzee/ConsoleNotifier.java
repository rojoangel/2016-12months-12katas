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

    public void notifyUserToIntroduceDiceToRerun(int rerunsSoFar) {
        this.console.print("[" + (rerunsSoFar + 1) + "] Dice to re-run:");

    }

    public void notifyCurrentCategory(Category category) {
        this.console.print("Category: " + category);
    }

    public void notifyCategoryScore(Category category, int score) {
        this.console.print("Category " + category + " score: " + score);
    }

    public void notifyGameScore(Map<Category, Integer> maxScoresByCategory, int finalScore) {
        this.console.print("Yahtzee score");
        for (Category category : Category.values()) {
            this.console.print(category + ": " + maxScoresByCategory.get(category));

        }
        this.console.print("Final score: " + finalScore);

    }
}