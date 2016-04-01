<?php


namespace Yahtzee;


class DiceRoller
{
    /** @var array */
    private $rollResult;
    
    /** @var DieRoller */
    private $dieRoller;

    /**
     * @param DieRoller $dieRoller
     */
    public function __construct(DieRoller $dieRoller)
    {
        $this->dieRoller = $dieRoller;
        $this->rollResult = [];
    }

    /**
     * @return array
     */
    public function lastRollResult()
    {
        return $this->rollResult;
    }

    public function rollAll()
    {
        $this->rollDice([1, 2, 3, 4, 5]);
    }

    /**
     * @param $diceToReRun
     */
    public function reRun($diceToReRun)
    {
        $this->rollDice($diceToReRun);
    }

    /**
     * @param array $diceToRoll
     */
    private function rollDice($diceToRoll)
    {
        foreach ($diceToRoll as $die) {
            $this->rollResult[$die - 1] = $this->dieRoller->roll();
        }
    }
}
