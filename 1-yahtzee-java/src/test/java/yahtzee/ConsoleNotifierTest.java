package yahtzee;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConsoleNotifierTest {

    @Test
    public void testNotifyRolledDice() throws Exception {

        Map<Die, Integer> rolledDice = new LinkedHashMap<Die, Integer>();
        rolledDice.put(Die.D1, 2);
        rolledDice.put(Die.D2, 4);
        rolledDice.put(Die.D3, 1);
        rolledDice.put(Die.D4, 6);
        rolledDice.put(Die.D5 ,1);

        Console console = new FakeConsole();
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);

        consoleNotifier.notifyRolledDice(rolledDice);

        assertEquals(Collections.singletonList("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"), console.getOutput());
    }

    @Test
    public void testNotifyUserToIntroduceDiceToRerun() throws Exception {
        Console console = new FakeConsole();
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);

        int rerunsSoFar= 1;
        consoleNotifier.notifyUserToIntroduceDiceToRerun(rerunsSoFar);
        assertEquals(Collections.singletonList("[2] Dice to re-run:"), console.getOutput());
    }
}