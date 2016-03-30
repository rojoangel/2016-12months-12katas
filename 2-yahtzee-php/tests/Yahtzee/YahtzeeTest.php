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
            "Category: Ones"
        ];
        $this->assertEquals($outputLines, $console->output);
    }
}
