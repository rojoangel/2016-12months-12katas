<?php

namespace Yahtzee;

class YahtzeeTest extends \PHPUnit_Framework_TestCase
{
    
    public function testGame()
    {
        $userInterface = new FakeUserInterface([
            [1, 2, 4],
            [2 , 4]
        ]);
        $dieRoller = new FakeDieRoller([2, 4, 1, 6, 1,
                                        1, 5 ,2,
                                        1,5]);
        $diceRoller = new DiceRoller($dieRoller);
        $yahtzee = new Yahtzee($userInterface, $diceRoller);

        $yahtzee->play();

        $outputLines = [
            "Category: Ones",
            "Dice: D1:2 D2:4 D3:1 D4:6 D5:1",
            "[1] Dice to re-run:",
            "Dice: D1:1 D2:5 D3:1 D4:2 D5:1",
            "[2] Dice to re-run:",
            "Dice: D1:1 D2:1 D3:1 D4:5 D5:1",
            "Category Ones score: 4"
        ];
        $this->assertEquals($outputLines, $userInterface->output);
    }
}
