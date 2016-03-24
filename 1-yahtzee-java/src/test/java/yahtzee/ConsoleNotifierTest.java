package yahtzee;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConsoleNotifierTest {


    private Console console;
    private ConsoleNotifier consoleNotifier;

    @Before
    public void setUp() {
        console = new FakeConsole();
        consoleNotifier = new ConsoleNotifier(console);
    }

    @Test
    public void testNotifyRolledDice() throws Exception {

        Map<Die, Integer> rolledDice = new LinkedHashMap<Die, Integer>();
        rolledDice.put(Die.D1, 2);
        rolledDice.put(Die.D2, 4);
        rolledDice.put(Die.D3, 1);
        rolledDice.put(Die.D4, 6);
        rolledDice.put(Die.D5 ,1);

        consoleNotifier.notifyRolledDice(rolledDice);

        assertEquals(Collections.singletonList("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"), console.getOutput());
    }

    @Test
    public void testNotifyUserToIntroduceDiceToRerun() throws Exception {
        int rerunsSoFar= 1;
        consoleNotifier.notifyUserToIntroduceDiceToRerun(rerunsSoFar);
        assertEquals(Collections.singletonList("[2] Dice to re-run:"), console.getOutput());
    }
}