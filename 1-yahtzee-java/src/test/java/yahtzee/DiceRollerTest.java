package yahtzee;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceRollerTest {

    @Test
    public void testRollAll() throws Exception {

        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll())
                .thenReturn(1)
                .thenReturn(5)
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(1);

        DiceRoller diceRoller = new DiceRoller(dieRoller);

        diceRoller.rollAll();

        assertEquals(generateExpectedRolledDice(), diceRoller.getRollResult());
    }

    @Test
    public void testRollsOnlyTheDesiredDiceKeepingThePreviousValueForTheOthers() throws Exception {

        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll())
                .thenReturn(6)
                .thenReturn(5)
                .thenReturn(4)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(1)
                .thenReturn(1)
                .thenReturn(1);


        DiceRoller diceRoller = new DiceRoller(dieRoller);

        diceRoller.rollAll();

        diceRoller.roll(1, 3, 5);

        assertEquals(generateExpectedRolledDice(), diceRoller.getRollResult());

    }

    private Map<Integer, Integer> generateExpectedRolledDice() {
        Map<Integer, Integer> rolledDice = new HashMap<Integer, Integer>();
        rolledDice.put(1, 1);
        rolledDice.put(2, 5);
        rolledDice.put(3, 1);
        rolledDice.put(4, 2);
        rolledDice.put(5 ,1);
        return rolledDice;
    }

}