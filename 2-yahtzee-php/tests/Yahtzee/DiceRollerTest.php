<?php


namespace Yahtzee;


class DiceRollerTest extends \PHPUnit_Framework_TestCase
{

    public function testRollAll()
    {
        $dieRoller = new FakeDieRoller([1, 3, 6, 2, 5]);
        $diceRoller = new DiceRoller($dieRoller);

        $diceRoller->rollAll();

        $expectedRollResult = [
            (string) Dice::D1() => 1,
            (string) Dice::D2() => 3,
            (string) Dice::D3() => 6,
            (string) Dice::D4() => 2,
            (string) Dice::D5() => 5
        ];
        $this->assertEquals($expectedRollResult, $diceRoller->lastRollResult());
    }

    public function testRerun() {
        $dieRoller = new FakeDieRoller([1, 3, 6, 2, 5,
                                        5, 4]);
        $diceRoller = new DiceRoller($dieRoller);

        $diceRoller->rollAll();
        $diceRoller->reRun([Dice::D2(), Dice::D4()]);

        $expectedRollResult = [
            (string) Dice::D1() => 1,
            (string) Dice::D2() => 5,
            (string) Dice::D3() => 6,
            (string) Dice::D4() => 4,
            (string) Dice::D5() => 5
        ];
        $this->assertEquals($expectedRollResult, $diceRoller->lastRollResult());
    }
}
