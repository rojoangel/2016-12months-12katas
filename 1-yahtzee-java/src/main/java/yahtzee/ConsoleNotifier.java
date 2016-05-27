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
        this.console.println(formattedDice.toString());
    }

    public void notifyUserToIntroduceDiceToRerun(int rerunsSoFar) {
        this.console.println("[" + (rerunsSoFar + 1) + "] Dice to re-run:");

    }

    public void notifyCurrentCategory(Category category) {
        this.console.println("Category: " + category);
    }

    public void notifyCategoryScore(Category category, int score) {
        this.console.println("Category " + category + " score: " + score);
    }

    public void notifyGameScore(Map<Category, Integer> maxScoresByCategory, int finalScore) {
        this.console.println("Yahtzee score");
        for (Category category : Category.values()) {
            this.console.println(category + ": " + maxScoresByCategory.get(category));

        }
        this.console.println("Final score: " + finalScore);

    }

    public void notifyAvailableCategories() {
        this.console.println("Available categories:");
        this.console.println("[1] Ones");
        this.console.println("[2] Twos");
        this.console.println("[3] Threes");
    }

    public void notifyUserToChooseCategory() {
        this.console.print("Category to add points to: ");
    }

    public void notifyChosenCategory(String chosenCategory) {
        this.console.println(chosenCategory);
    }
}