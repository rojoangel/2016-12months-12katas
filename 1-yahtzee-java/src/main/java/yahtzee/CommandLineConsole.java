package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class CommandLineConsole implements Console {

    List<String> lines = new ArrayList<String>();

    public void print(String line) {
        System.out.println(line);
        lines.add(line);
    }

    public List<String> getOutput() {
        return lines;
    }
}
