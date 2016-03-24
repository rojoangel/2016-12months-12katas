package yahtzee;

import java.util.Map;

public class DiceScorer {
    private Category category;

    public DiceScorer(Category category) {
        this.category = category;
    }

    public int computeScore(Map<Die, Integer> dice) {
        return 3;
    }
}
