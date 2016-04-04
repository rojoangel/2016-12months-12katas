package yahtzee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Round1YahtzeeTest {

    @Test
    public void testRoundOneGame(){
        FakeConsole console = new FakeConsole();
        ConsoleNotifier notifier = new ConsoleNotifier(console);
        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll()).thenReturn(2, 4, 1, 6, 1,
                                          1, 5, 2,
                                          1, 5,
                                          2, 4, 1, 6, 1,
                                          2, 3,
                                          6, 1, 2,
                                          2, 4, 1, 6, 1,
                                          5, 1, 3, 2, 3,
                                          6, 2, 4);
        UserInputReader userInputReader = mock(UserInputReader.class);
        when(userInputReader.readLine()).thenReturn("D1 D2 D4",
                                                    "D2 D4",
                                                    "D2 D5",
                                                    "D3 D4 D5",
                                                    "D1 D2 D3 D4 D5",
                                                    "D1 D2 D4");
        DiceRoller diceRoller = new DiceRoller(dieRoller);
        ScoresHistory scoresHistory = new InMemoryScoresHistory();
        Reruns reruns = new Reruns(notifier, userInputReader, diceRoller);
        CategoriesGameFlow gameFlow = new CategoriesGameFlow(notifier, diceRoller, scoresHistory, reruns);
        Yahtzee yahtzee = new Yahtzee(notifier, scoresHistory, gameFlow);

        yahtzee.play();

        assertThat(console.nextLine(), is("Category: Ones"));
        assertThat(console.nextLine(), is("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"));
        assertThat(console.nextLine(), is("[1] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:1 D2:5 D3:1 D4:2 D5:1"));
        assertThat(console.nextLine(), is("[2] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:1 D2:1 D3:1 D4:5 D5:1"));
        assertThat(console.nextLine(), is("Category Ones score: 4"));
        assertThat(console.nextLine(), is("Category: Twos"));
        assertThat(console.nextLine(), is("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"));
        assertThat(console.nextLine(), is("[1] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:2 D2:2 D3:1 D4:6 D5:3"));
        assertThat(console.nextLine(), is("[2] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:2 D2:2 D3:6 D4:1 D5:2"));
        assertThat(console.nextLine(), is("Category Twos score: 3"));
        assertThat(console.nextLine(), is("Category: Threes"));
        assertThat(console.nextLine(), is("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"));
        assertThat(console.nextLine(), is("[1] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:5 D2:1 D3:3 D4:2 D5:3"));
        assertThat(console.nextLine(), is("[2] Dice to re-run:"));
        assertThat(console.nextLine(), is("Dice: D1:6 D2:2 D3:3 D4:4 D5:3"));
        assertThat(console.nextLine(), is("Category Threes score: 2"));
        assertThat(console.nextLine(), is("Yahtzee score"));
        assertThat(console.nextLine(), is("Ones: 4"));
        assertThat(console.nextLine(), is("Twos: 3"));
        assertThat(console.nextLine(), is("Threes: 2"));
        assertThat(console.nextLine(), is("Final score: 9"));
    }
}