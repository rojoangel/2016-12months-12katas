package yahtzee;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConsoleNotifierTest {

    @Test
    public void testNotifyRolledDice() throws Exception {

        Map<Integer, Integer> rolledDice = new HashMap<Integer, Integer>();
        rolledDice.put(1, 2);
        rolledDice.put(2, 4);
        rolledDice.put(3, 1);
        rolledDice.put(4, 6);
        rolledDice.put(5 ,1);

        Console console = new FakeConsole();
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);

        consoleNotifier.notifyRolledDice(rolledDice);

        assertEquals(Collections.singletonList("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"), console.getOutput());
    }
}