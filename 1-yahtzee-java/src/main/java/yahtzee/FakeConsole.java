package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class FakeConsole implements Console {

    List<String> lines = new ArrayList<String>();

    public void print(String line) {
         lines.add(line);
    }

    public List<String> getOutput() {
        return lines;
    }
}
