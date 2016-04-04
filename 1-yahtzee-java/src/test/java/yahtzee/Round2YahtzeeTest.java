package yahtzee;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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

        assertThat(console.nextLine(), is("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"));
        assertThat(console.nextLine(), is("[1] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:1 D2:5 D3:1 D4:2 D5:1"));
        assertThat(console.nextLine(), is("[2] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:1 D2:1 D3:1 D4:5 D5:1"));
        assertThat(console.nextLine(), is("Available categories:"));
        assertThat(console.nextLine(), is("[1] Ones"));
        assertThat(console.nextLine(), is("[2] Twos"));
        assertThat(console.nextLine(), is("[3] Threes"));
        assertThat(console.nextLine(), is("Category to add points to: 1"));
    }
}
