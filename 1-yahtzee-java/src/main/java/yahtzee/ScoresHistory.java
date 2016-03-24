package yahtzee;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collections;

public class ScoresHistory {
    Multimap<Category, Integer> scoresHistory = LinkedListMultimap.create();

    public void annotateScore(Category category, int score) {
        this.scoresHistory.put(category, score);
    }

    public int maxScore(Category category) {
        return Collections.max(this.scoresHistory.get(category));
    }

    public int finalScore() {
        int finalScore = 0;
        for (Category category : Category.values()) {
            finalScore += this.maxScore(category);
        }
        return finalScore;
    }
}
