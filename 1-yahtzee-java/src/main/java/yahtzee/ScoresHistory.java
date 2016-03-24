package yahtzee;


import java.util.Map;

public interface ScoresHistory {

    void annotateScore(Category category, int score);

    int maxScore(Category category);

    int finalScore();

    Map<Category, Integer> maxScoresByCategory();
}
