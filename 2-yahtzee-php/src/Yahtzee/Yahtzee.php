<?php


namespace Yahtzee;


class Yahtzee
{
    /** @var UserInterface */
    private $userInterface;
    
    /** @var DiceRoller */
    private $diceRoller;

    /**
     * @param UserInterface $userInterface
     * @param DiceRoller $diceRoller
     */
    public function __construct(UserInterface $userInterface, DiceRoller $diceRoller)
    {
        $this->userInterface = $userInterface;
        $this->diceRoller = $diceRoller;
    }
    
    public function play() {

        $this->userInterface->printLine("Category: Ones");

        $dice = $this->rollAllDice();
        $this->printDiceLine($dice);

        $this->userInterface->printLine("[1] Dice to re-run:");

        $diceToReRun = $this->getDiceToReRun();
        $dice = $this->reRunDice($diceToReRun);
        $this->printDiceLine($dice);

        $this->userInterface->printLine("[2] Dice to re-run:");

        $diceToReRun = $this->getDiceToReRun();
        $dice = $this->reRunDice($diceToReRun);
        $this->printDiceLine($dice);

        $this->printCategoryScore($dice);
    }

    /**
     * @param array $dice
     */
    private function printDiceLine($dice)
    {
        $this->userInterface->printLine(sprintf(
            "Dice: D1:%s D2:%s D3:%s D4:%s D5:%s", $dice[0], $dice[1], $dice[2], $dice[3], $dice[4]));
    }

    /**
     * @return array
     */
    private function getDiceToReRun()
    {
        return $this->userInterface->readDiceToRerun();
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

    /**
     * @param array $dice
     */
    private function printCategoryScore($dice)
    {
        $score = count(array_filter($dice, function ($die) { return $die == 1; }));
        $this->userInterface->printLine(sprintf("Category Ones score: %s", $score));
    }
}
