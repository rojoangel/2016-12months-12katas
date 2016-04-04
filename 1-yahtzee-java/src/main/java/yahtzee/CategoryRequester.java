package yahtzee;

public class CategoryRequester {
    private final ConsoleNotifier notifier;
    private final UserInputReader userInputReader;
    private String chosenCategory;

    public CategoryRequester(ConsoleNotifier notifier, UserInputReader userInputReader) {
        this.notifier = notifier;
        this.userInputReader = userInputReader;
    }

    public void requestCategory() {
        this.notifier.notifyAvailableCategories();
        this.notifier.notifyUserToChooseCategory();
        chosenCategory = this.userInputReader.readLine();
        this.notifier.notifyChosenCategory(chosenCategory);
    }

    public Category chosenCategory() {
        return Category.create(chosenCategory);
    }
}
