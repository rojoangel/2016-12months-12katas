package yahtzee;


import org.hamcrest.CoreMatchers;
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

        assertThat(console.nextLine(), CoreMatchers.is("Available categories:"));
        assertThat(console.nextLine(), CoreMatchers.is("[1] Ones"));
        assertThat(console.nextLine(), CoreMatchers.is("[2] Twos"));
        assertThat(console.nextLine(), CoreMatchers.is("[3] Threes"));
        assertThat(console.nextLine(), CoreMatchers.is("Category to add points to: 1"));
        assertThat(categoryRequester.chosenCategory(), is(Category.Ones));
    }
}
