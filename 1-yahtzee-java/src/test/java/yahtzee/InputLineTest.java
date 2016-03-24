package yahtzee;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputLineTest {

    @Test
    public void testExtractDiceToRoll() throws Exception {
        InputLine inputLine = new InputLine("D1 D2 D4");
        assertArrayEquals(new Die[] {Die.D1, Die.D2, Die.D4}, inputLine.diceToRoll());
    }
}