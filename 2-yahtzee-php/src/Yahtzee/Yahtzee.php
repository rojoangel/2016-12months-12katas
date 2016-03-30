<?php


namespace Yahtzee;


class Yahtzee
{
    /**
     * @var Console
     */
    private $console;
    
    /**
     * @var DieRoller
     */
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
        $dice = $this->reRunDice($diceToReRun, $dice);
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
     * @param array $dice
     * @return array
     */
    private function rollDice($dice)
    {
        $rolledDice = [];
        for ($i = 0; $i < count($dice); $i++) {
            $rolledDice[] = $this->dieRoller->roll();
        }
        return $rolledDice;
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
     * @param $dice
     * @return mixed
     */
    private function reRunDice($diceToReRun, $dice)
    {
        $reRunDice = $this->rollDice($diceToReRun);

        for ($i = 0; $i < count($diceToReRun); $i++) {
            $dice[$diceToReRun[$i] - 1] = $reRunDice[$i];
        }
        return $dice;
    }
}
