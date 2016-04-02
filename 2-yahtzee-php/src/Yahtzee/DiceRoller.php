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
        $this->rollDice(Dice::all());
    }

    /**
     * @param Dice[] $diceToReRun
     */
    public function reRun($diceToReRun)
    {
        $this->rollDice($diceToReRun);
    }

    /**
     * @param Dice[] $diceToRoll
     */
    private function rollDice($diceToRoll)
    {
        foreach ($diceToRoll as $die) {
            $this->rollResult[(string) $die] = $this->dieRoller->roll();
        }
    }
}
