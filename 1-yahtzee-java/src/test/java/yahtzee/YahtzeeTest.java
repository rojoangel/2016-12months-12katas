package yahtzee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class YahtzeeTest {

    @Test
    public void testGame(){
        FakeConsole console = new FakeConsole();
        ConsoleNotifier notifier = new ConsoleNotifier(console);
        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll()).thenReturn(2, 4, 1, 6, 1,
                                          1, 5, 2,
                                          1, 5,
                                          2, 4, 1, 6, 1,
                                          2, 3,
                                          6, 1, 2);
        UserInputReader userInputReader = mock(UserInputReader.class);
        when(userInputReader.readLine()).thenReturn("D1 D2 D4",
                                                    "D2 D4",
                                                    "D2 D5",
                                                    "D3 D4 D5");
        DiceRoller diceRoller = new DiceRoller(dieRoller);

        Yahtzee yahtzee = new Yahtzee(console, notifier, userInputReader, diceRoller);
        yahtzee.play();

        List<String> outputLines = new ArrayList<String>();
        outputLines.add("Category: Ones");
        outputLines.add("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        outputLines.add("[1] Dice to re-run:");
        outputLines.add("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        outputLines.add("[2] Dice to re-run:");
        outputLines.add("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
        outputLines.add("Category Ones score: 4");
        outputLines.add("Category: Twos");
        outputLines.add("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        outputLines.add("[1] Dice to re-run:");
        outputLines.add("Dice: D1:2 D2:2 D3:1 D4:6 D5:3");
        outputLines.add("[2] Dice to re-run:");
        outputLines.add("Dice: D1:2 D2:2 D3:6 D4:1 D5:2");
        assertEquals(outputLines, console.getOutput());
    }

}