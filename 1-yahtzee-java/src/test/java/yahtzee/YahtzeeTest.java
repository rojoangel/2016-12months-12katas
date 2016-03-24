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
                                          1, 5);
        UserInputReader userInputReader = mock(UserInputReader.class);
        when(userInputReader.readLine()).thenReturn("D1 D2 D4",
                                                    "D2 D4");
        DiceRoller diceRoller = new DiceRoller(dieRoller);

        Yahtzee yahtzee = new Yahtzee(console, notifier, userInputReader, diceRoller);
        yahtzee.play();

        List<String> l = new ArrayList<String>();
        l.add("Category: Ones");
        l.add("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        l.add("[1] Dice to re-run:");
        l.add("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        l.add("[2] Dice to re-run:");
        l.add("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
        assertEquals(l, console.getOutput());
    }

}