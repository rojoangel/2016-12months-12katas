package yahtzee;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InMemoryScoresHistoryTest {

    @Test
    public void testMaxScore() throws Exception {

        InMemoryScoresHistory history = new InMemoryScoresHistory();
        annotateSeveralScores(history);

        assertEquals(3, history.maxScore(Category.Ones));
        assertEquals(4, history.maxScore(Category.Twos));
        assertEquals(5, history.maxScore(Category.Threes));
    }

    @Test
    public void testFinalScore() throws Exception {

        InMemoryScoresHistory history = new InMemoryScoresHistory();
        annotateSeveralScores(history);

        assertEquals(12, history.finalScore());
    }

    @Test
    public void testMaxScoresByCategory() throws Exception {
        InMemoryScoresHistory history = new InMemoryScoresHistory();
        annotateSeveralScores(history);

        Map<Category, Integer> maxScoresByCategory = generateMaxScoresByCategory();
        assertEquals(maxScoresByCategory, history.maxScoresByCategory());

    }

    private void annotateSeveralScores(InMemoryScoresHistory history) {
        history.annotateScore(Category.Ones, 3);
        history.annotateScore(Category.Twos, 2);
        history.annotateScore(Category.Threes, 1);
        history.annotateScore(Category.Twos, 4);
        history.annotateScore(Category.Threes, 5);
        history.annotateScore(Category.Twos, 3);
        history.annotateScore(Category.Twos, 1);
        history.annotateScore(Category.Threes, 3);
    }

    private Map<Category, Integer> generateMaxScoresByCategory() {
        Map<Category, Integer> maxScoresByCategory = new HashMap<Category, Integer>();
        maxScoresByCategory.put(Category.Ones, 3);
        maxScoresByCategory.put(Category.Twos, 4);
        maxScoresByCategory.put(Category.Threes, 5);
        return maxScoresByCategory;
    }
}