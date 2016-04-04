package yahtzee;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryRequesterTest {

    @Test
    public void testRequestTheUserToChooseCategory() {
        FakeConsole console = new FakeConsole();
        ConsoleNotifier notifier = new ConsoleNotifier(console);
        UserInputReader userInputReader = mock(UserInputReader.class);
        when(userInputReader.readLine()).thenReturn(
            "1");

        CategoryRequester categoryRequester = new CategoryRequester(notifier, userInputReader);

        categoryRequester.requestCategory();


        List<String> outputLines = new ArrayList<String>();
        outputLines.add("Available categories:");
        outputLines.add("[1] Ones");
        outputLines.add("[2] Twos");
        outputLines.add("[3] Threes");
        outputLines.add("Category to add points to: 1");
        assertThat(categoryRequester.chosenCategory(), is(Category.Ones));
        assertEquals(outputLines, console.getOutput());
    }
}
