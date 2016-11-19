package yahtzee;

import java.util.Scanner;

public class CommandLineUserInputReader implements UserInputReader {
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
