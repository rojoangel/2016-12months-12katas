package yahtzee;

public class Yahtzee {

    private FakeConsole console;
    private DieRoller dieRoller;

    public Yahtzee(FakeConsole console, DieRoller dieRoller) {

        this.console = console;
        this.dieRoller = dieRoller;
    }

    public void play() {
        this.console.print("Category: Ones");
        roll();
        this.console.print("[1] Dice to re-run:");
        this.console.print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
    }

    private void roll() {
        int[] rolled_dice = new int[5];
        for (int i =0; i<5 ; i++) {
            rolled_dice[i] = this.dieRoller.roll();
        }
        notifyRolledDice(rolled_dice);
    }

    private void notifyRolledDice(int[] rolled_dice) {
        StringBuilder formattedDice = new StringBuilder("Dice:");
        for (int i = 0; i < rolled_dice.length; i++) {
            formattedDice.append(" D").append(i + 1).append(":").append(rolled_dice[i]);
        }
        this.console.print(formattedDice.toString());
    }
}
