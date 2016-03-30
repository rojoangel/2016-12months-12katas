<?php


namespace Yahtzee;


class DiceRoller
{
    /** @var array */
    private $dice;
    
    /** @var DieRoller */
    private $dieRoller;

    /**
     * @param DieRoller $dieRoller
     */
    public function __construct(DieRoller $dieRoller)
    {
        $this->dieRoller = $dieRoller;
    }
    
    /**
     * @return array
     */
    public function rollAll()
    {
        $this->dice = $this->rollDice([1, 2, 3, 4, 5]);
        return $this->dice;
    }
    
    /**
     * @param array $diceToRoll
     * @return array
     */
    private function rollDice($diceToRoll)
    {
        foreach ($diceToRoll as $die) {
            $this->dice[$die - 1] = $this->dieRoller->roll();
        }
        return $this->dice;
    }
}
