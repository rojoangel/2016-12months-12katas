package yahtzee;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputLineTest {

    @Test
    public void testExtractDiceToRoll() throws Exception {
        assertArrayEquals(new Die[] {Die.D1, Die.D2, Die.D4}, new InputLine("D1 D2 D4").diceToRoll());
        assertArrayEquals(new Die[] {Die.D3, Die.D5}, new InputLine("D3 D5").diceToRoll());
    }
}