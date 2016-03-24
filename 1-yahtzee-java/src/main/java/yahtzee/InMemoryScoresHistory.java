package yahtzee;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InMemoryScoresHistory implements ScoresHistory {
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

    public Map<Category, Integer> maxScoresByCategory() {
        Map<Category, Integer> maxScoresByCategory = new HashMap<Category, Integer>();
        for (Category category : Category.values()) {
            maxScoresByCategory.put(category, this.maxScore(category));
        }
        return maxScoresByCategory;
    }
}
