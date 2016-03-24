package yahtzee;


public interface ScoresHistory {

    void annotateScore(Category category, int score);

    int maxScore(Category category);

    int finalScore();
}
