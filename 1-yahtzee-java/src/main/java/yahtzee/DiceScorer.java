package yahtzee;

import java.util.Map;

public class DiceScorer {
    private Category category;

    public DiceScorer(Category category) {
        this.category = category;
    }

    public int computeScore(Map<Die, Integer> dice) {
        int score = 0;
        for (Integer value : dice.values()) {
            if (value.equals(category.getValue())) {
                score++;
            }
        }
        return score;
    }
}
