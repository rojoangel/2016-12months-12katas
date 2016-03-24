package yahtzee;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoresHistoryTest {

    @Test
    public void testMaxScore() throws Exception {
        ScoresHistory history = new ScoresHistory();

        history.annotateScore(Category.Ones, 3);
        history.annotateScore(Category.Twos, 2);
        history.annotateScore(Category.Threes, 1);
        history.annotateScore(Category.Twos, 4);
        history.annotateScore(Category.Threes, 5);
        history.annotateScore(Category.Twos, 3);
        history.annotateScore(Category.Twos, 1);
        history.annotateScore(Category.Threes, 3);

        assertEquals(3, history.maxScore(Category.Ones));
        assertEquals(4, history.maxScore(Category.Twos));
        assertEquals(5, history.maxScore(Category.Threes));
    }
}