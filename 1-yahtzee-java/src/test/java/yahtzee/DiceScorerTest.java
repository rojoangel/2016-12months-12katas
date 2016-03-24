package yahtzee;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DiceScorerTest {

    @Test
    public void testComputesDiceScoreForOnes() throws Exception {
        DiceScorer diceScorer = new DiceScorer(Category.Ones);
        assertEquals(3, diceScorer.computeScore(generateRolledDice()));
    }

    @Test
    public void testComputesDiceScoreForTwos() throws Exception {
        DiceScorer diceScorer = new DiceScorer(Category.Twos);
        assertEquals(1, diceScorer.computeScore(generateRolledDice()));
    }

    @Test
    public void testComputesDiceScoreForThrees() throws Exception {
        DiceScorer diceScorer = new DiceScorer(Category.Threes);
        assertEquals(0, diceScorer.computeScore(generateRolledDice()));
    }

    private Map<Die, Integer> generateRolledDice() {
        Map<Die, Integer> rolledDice = new HashMap<Die, Integer>();
        rolledDice.put(Die.D1, 1);
        rolledDice.put(Die.D2, 5);
        rolledDice.put(Die.D3, 1);
        rolledDice.put(Die.D4, 2);
        rolledDice.put(Die.D5 ,1);
        return rolledDice;
    }
}