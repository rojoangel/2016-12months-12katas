package yahtzee;

public enum Category {
    Ones(1),
    Twos(2);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
