package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class FakeConsole implements Console {
    List<String> lines = new ArrayList<String>();
    private String incompleteLine = "";

    public void println(String line) {
        lines.add(incompleteLine + line);
        incompleteLine = "";
    }

    @Override
    public void print(String line) {
        incompleteLine += line;
    }

    public List<String> getOutput() {
        return lines;
    }
}
