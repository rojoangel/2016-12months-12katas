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

    public int computeScore(Map<Dice, Integer> dice) {
        int score = 0;
        for (Integer value : dice.values()) {
            if (value.equals(this.value)) {
                score++;
            }
        }
        return score;
    }
}
