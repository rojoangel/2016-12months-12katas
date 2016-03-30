<?php

namespace Yahtzee;

class YahtzeeTest extends \PHPUnit_Framework_TestCase
{
    
    public function testGame()
    {
        $console = new FakeConsole();
        $yahtzee = new Yahtzee($console);

        $yahtzee->play();

        $outputLines = [
            "Category: Ones",
            "Dice: D1:2 D2:4 D3:1 D4:6 D5:1",
            "[1] Dice to re-run:"
        ];
        $this->assertEquals($outputLines, $console->output);
    }
}
