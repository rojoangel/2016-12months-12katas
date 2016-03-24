package yahtzee;

import java.util.Map;

public enum Category {
    Ones(1),
    Twos(2),
    Threes(3);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int computeScore(Map<Die, Integer> dice) {
        int score = 0;
        for (Integer value : dice.values()) {
            if (value.equals(this.getValue())) {
                score++;
            }
        }
        return score;
    }
}
