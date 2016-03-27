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

    private Map<Dice, Integer> generateRolledDice() {
        Map<Dice, Integer> rolledDice = new HashMap<Dice, Integer>();
        rolledDice.put(Dice.D1, 1);
        rolledDice.put(Dice.D2, 5);
        rolledDice.put(Dice.D3, 1);
        rolledDice.put(Dice.D4, 2);
        rolledDice.put(Dice.D5 ,1);
        return rolledDice;
    }

}