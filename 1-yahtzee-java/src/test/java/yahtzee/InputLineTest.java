package yahtzee;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputLineTest {

    @Test
    public void testExtractDiceToRoll() throws Exception {
        assertArrayEquals(new Dice[] {Dice.D1, Dice.D2, Dice.D4}, new InputLine("D1 D2 D4").diceToRoll());
        assertArrayEquals(new Dice[] {Dice.D3, Dice.D5}, new InputLine("D3 D5").diceToRoll());
    }
}