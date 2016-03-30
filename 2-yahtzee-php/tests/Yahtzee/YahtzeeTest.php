<?php

namespace Yahtzee;

class YahtzeeTest extends \PHPUnit_Framework_TestCase
{
    
    public function testGame()
    {
        $console = new FakeConsole();
        $dieRoller = new FakeDieRoller([2, 4, 1, 6, 1,
                                        1, 5 ,2]);
        $diceRoller = new DiceRoller($dieRoller);
        $yahtzee = new Yahtzee($console, $diceRoller);

        $yahtzee->play();

        $outputLines = [
            "Category: Ones",
            "Dice: D1:2 D2:4 D3:1 D4:6 D5:1",
            "[1] Dice to re-run:",
            "Dice: D1:1 D2:5 D3:1 D4:2 D5:1"
        ];
        $this->assertEquals($outputLines, $console->output);
    }
}
