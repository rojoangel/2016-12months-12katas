<?php


namespace Yahtzee;


class DiceRollerTest extends \PHPUnit_Framework_TestCase
{

    public function testRollAll()
    {
        $dieRoller = new FakeDieRoller([1, 3, 6, 2, 5]);
        $diceRoller = new DiceRoller($dieRoller);
        $this->assertEquals([1, 3, 6, 2, 5], $diceRoller->rollAll());
    }
}
