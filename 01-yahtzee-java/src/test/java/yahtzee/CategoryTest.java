package yahtzee;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void testComputeScoreForOnes() throws Exception {
        Category ones = Category.Ones;
        assertEquals(3, ones.computeScore(generateRolledDice()));
    }

    @Test
    public void testComputeScoreForTwos() throws Exception {
        Category threes = Category.Threes;
        assertEquals(0, threes.computeScore(generateRolledDice()));
    }

    @Test
    public void Threes() throws Exception {
        Category twos = Category.Twos;
        assertEquals(1, twos.computeScore(generateRolledDice()));
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