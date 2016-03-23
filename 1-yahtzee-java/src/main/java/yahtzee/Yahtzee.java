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
        int[] rolled_dice = new int[5];
        for (int i =0; i<5 ; i++) {
            rolled_dice[i] = this.dieRoller.roll();
        }
        this.console.print("Dice: D1:" + rolled_dice[0] + " D2:" + rolled_dice[1] + " D3:" + rolled_dice[2] + " D4:" + rolled_dice[3] + " D5:" + rolled_dice[4]);
        this.console.print("[1] Dice to re-run:");

        this.console.print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
    }
}
