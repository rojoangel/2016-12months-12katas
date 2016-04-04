package yahtzee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Round2YahtzeeTest {

    @Test
    public void testRoundTwoGame() {
        FakeConsole console = new FakeConsole();
        ConsoleNotifier notifier = new ConsoleNotifier(console);
        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll()).thenReturn(
            2, 4, 1, 6, 1,
            1, 5, 2,
            1, 5);
        UserInputReader userInputReader = mock(UserInputReader.class);
        when(userInputReader.readLine()).thenReturn(
            "D1 D2 D4",
            "D2 D4",
            "1");
        DiceRoller diceRoller = new DiceRoller(dieRoller);
        ScoresHistory scoresHistory = new InMemoryScoresHistory();
        Reruns reruns = new Reruns(notifier, userInputReader, diceRoller);
        CategoryRequester categoryRequester = new CategoryRequester(notifier, userInputReader);
        GameFlow gameFlow = new CategoryChoiceGameFlow(
            notifier, diceRoller, scoresHistory, reruns, categoryRequester
        );
        Yahtzee yahtzee = new Yahtzee(notifier, scoresHistory, gameFlow);
        yahtzee.play();

        List<String> outputLines = new ArrayList<String>();
        outputLines.add("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        outputLines.add("[1] Dice to re-run:");
        outputLines.add("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        outputLines.add("[2] Dice to re-run:");
        outputLines.add("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
        outputLines.add("Available categories:");
        outputLines.add("[1] Ones");
        outputLines.add("[2] Twos");
        outputLines.add("[3] Threes");
        outputLines.add("Category to add points to: 1");


        assertEquals(outputLines, console.getOutput());
    }
}
