<?php


namespace Yahtzee;


class Yahtzee
{
    /** @var Console */
    private $console;
    
    /** @var DieRoller */
    private $dieRoller;

    /** @var DiceRoller */
    private $diceRoller;

    /**
     * @param Console $console
     * @param DieRoller $dieRoller
     */
    public function __construct(Console $console, DieRoller $dieRoller)
    {
        $this->console = $console;
        $this->dieRoller = $dieRoller;
        $this->diceRoller = new DiceRoller($dieRoller);
    }
    
    public function play() {

        $this->console->printLine("Category: Ones");

        $dice = $this->rollAllDice();
        $this->printDiceLine($dice);

        $this->console->printLine("[1] Dice to re-run:");

        $diceToReRun = $this->getDiceToReRun();
        $dice = $this->reRunDice($diceToReRun);
        $this->printDiceLine($dice);
    }

    /**
     * @param array $dice
     */
    private function printDiceLine($dice)
    {
        $this->console->printLine(sprintf(
            "Dice: D1:%s D2:%s D3:%s D4:%s D5:%s", $dice[0], $dice[1], $dice[2], $dice[3], $dice[4]));
    }

    /**
     * @return array
     */
    private function getDiceToReRun()
    {
        return [1, 2, 4];
    }

    /**
     * @return array
     */
    private function rollAllDice()
    {
        return $this->diceRoller->rollAll();
    }

    /**
     * @param $diceToReRun
     * @return array
     */
    private function reRunDice($diceToReRun)
    {
        return $this->diceRoller->reRun($diceToReRun);
    }
}
