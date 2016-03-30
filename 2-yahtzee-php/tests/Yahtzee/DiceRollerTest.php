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

    public function testRerun() {
        $dieRoller = new FakeDieRoller([1, 3, 6, 2, 5,
                                        5, 4]);
        $diceRoller = new DiceRoller($dieRoller);
        $diceRoller->rollAll();
        $this->assertEquals([1, 5, 6, 4, 5], $diceRoller->reRun([2, 4]));
    }
}
