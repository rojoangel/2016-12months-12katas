package yahtzee;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ConsoleNotifierTest {


    private FakeConsole console;
    private ConsoleNotifier consoleNotifier;

    @Before
    public void setUp() {
        console = new FakeConsole();
        consoleNotifier = new ConsoleNotifier(console);
    }

    @Test
    public void testNotifyRolledDice() throws Exception {
        consoleNotifier.notifyRolledDice(generateRolledDice());
        assertEquals(Collections.singletonList("Dice: D1:2 D2:4 D3:1 D4:6 D5:1"), console.getOutput());
    }

    @Test
    public void testNotifyUserToIntroduceDiceToRerun() throws Exception {
        int rerunsSoFar= 1;
        consoleNotifier.notifyUserToIntroduceDiceToRerun(rerunsSoFar);
        assertEquals(Collections.singletonList("[2] Dice to re-run:"), console.getOutput());
    }

    @Test
    public void testNotifyCurrentCategoryForOnes() throws Exception {
        consoleNotifier.notifyCurrentCategory(Category.Ones);
        assertEquals(Collections.singletonList("Category: Ones"), console.getOutput());
    }

    @Test
    public void testNotifyCurrentCategoryForTwos() throws Exception {
        consoleNotifier.notifyCurrentCategory(Category.Twos);
        assertEquals(Collections.singletonList("Category: Twos"), console.getOutput());
    }

    @Test
    public void testNotifyCategoryScoreForOnes() throws Exception {
        int score = 2;
        consoleNotifier.notifyCategoryScore(Category.Ones, score);
        assertEquals(Collections.singletonList("Category Ones score: " + score), console.getOutput());
    }

    @Test
    public void testNotifyCategoryScoreForTwos() throws Exception {
        int score = 5;
        consoleNotifier.notifyCategoryScore(Category.Twos, score);
        assertEquals(Collections.singletonList("Category Twos score: " + score), console.getOutput());
    }

    @Test
    public void testNotifyGameScore() throws Exception {

        Map<Category, Integer> maxScoresByCategory = generateMaxScoresByCategory();
        int finalScore = 10;

        consoleNotifier.notifyGameScore(maxScoresByCategory, finalScore);
        assertEquals(Arrays.asList(
                "Yahtzee score",
                "Ones: 3",
                "Twos: 5",
                "Threes: 2",
                "Final score: 10"
                ),
                console.getOutput());
    }

    private Map<Dice, Integer> generateRolledDice() {
        Map<Dice, Integer> rolledDice = new LinkedHashMap<Dice, Integer>();
        rolledDice.put(Dice.D1, 2);
        rolledDice.put(Dice.D2, 4);
        rolledDice.put(Dice.D3, 1);
        rolledDice.put(Dice.D4, 6);
        rolledDice.put(Dice.D5 ,1);
        return rolledDice;
    }

    private Map<Category, Integer> generateMaxScoresByCategory() {
        Map<Category, Integer> maxScoresByCategory = new LinkedHashMap<Category, Integer>();
        maxScoresByCategory.put(Category.Ones, 3);
        maxScoresByCategory.put(Category.Twos, 5);
        maxScoresByCategory.put(Category.Threes, 2);
        return maxScoresByCategory;
    }
}