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

        DieRoller dieRoller = generateADieRollerWithRollingValues(1, 5, 1, 2, 1);

        DiceRoller diceRoller = new DiceRoller(dieRoller);

        diceRoller.roll(Die.values());

        assertEquals(generateExpectedRolledDice(), diceRoller.getRollResult());
    }

    @Test
    public void testRollsOnlyTheDesiredDiceKeepingThePreviousValueForTheOthers() throws Exception {

        DieRoller dieRoller = generateADieRollerWithRollingValues(6, 5, 4, 2, 3, 1, 1, 1);

        DiceRoller diceRoller = new DiceRoller(dieRoller);

        diceRoller.roll(Die.values());

        diceRoller.roll(Die.D1, Die.D3, Die.D5);

        assertEquals(generateExpectedRolledDice(), diceRoller.getRollResult());

    }

    private DieRoller generateADieRollerWithRollingValues(Integer value, Integer... values) {
        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll()).thenReturn(value, values);
        return dieRoller;
    }

    private Map<Die, Integer> generateExpectedRolledDice() {
        Map<Die, Integer> rolledDice = new HashMap<Die, Integer>();
        rolledDice.put(Die.D1, 1);
        rolledDice.put(Die.D2, 5);
        rolledDice.put(Die.D3, 1);
        rolledDice.put(Die.D4, 2);
        rolledDice.put(Die.D5 ,1);
        return rolledDice;
    }

}