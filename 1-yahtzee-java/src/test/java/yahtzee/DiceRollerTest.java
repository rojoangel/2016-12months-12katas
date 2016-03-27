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

        diceRoller.roll(Dice.values());

        assertEquals(generateExpectedRolledDice(), diceRoller.lastRolledDice());
    }

    @Test
    public void testRollsOnlyTheDesiredDiceKeepingThePreviousValueForTheOthers() throws Exception {

        DieRoller dieRoller = generateADieRollerWithRollingValues(6, 5, 4, 2, 3, 1, 1, 1);

        DiceRoller diceRoller = new DiceRoller(dieRoller);

        diceRoller.roll(Dice.values());

        diceRoller.roll(Dice.D1, Dice.D3, Dice.D5);

        assertEquals(generateExpectedRolledDice(), diceRoller.lastRolledDice());

    }

    private DieRoller generateADieRollerWithRollingValues(Integer value, Integer... values) {
        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll()).thenReturn(value, values);
        return dieRoller;
    }

    private Map<Dice, Integer> generateExpectedRolledDice() {
        Map<Dice, Integer> rolledDice = new HashMap<Dice, Integer>();
        rolledDice.put(Dice.D1, 1);
        rolledDice.put(Dice.D2, 5);
        rolledDice.put(Dice.D3, 1);
        rolledDice.put(Dice.D4, 2);
        rolledDice.put(Dice.D5 ,1);
        return rolledDice;
    }

}