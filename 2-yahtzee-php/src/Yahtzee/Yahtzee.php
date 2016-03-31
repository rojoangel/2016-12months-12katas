<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;
    
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

        $this->printCategory();

        $dice = $this->rollAllDice();
        $this->printDiceLine($dice);

        for ($reRunAttempt = 1; $reRunAttempt <= self::RERUN_ATTEMPTS; $reRunAttempt++) {
            $diceToReRun = $this->requestDiceToReRun($reRunAttempt);
            $dice = $this->reRunDice($diceToReRun);
            $this->printDiceLine($dice);
        }

        $this->printCategoryScore($dice);
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

    private function printCategory()
    {
        $this->userInterface->printLine("Category: Ones");
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
     * @param array $dice
     */
    private function printCategoryScore($dice)
    {
        $score = count(array_filter($dice, function ($die) { return $die == 1; }));
        $this->userInterface->printLine(sprintf("Category Ones score: %s", $score));
    }

    /**
     * @param $reRunAttempt
     */
    private function printReRunAttempt($reRunAttempt)
    {
        $this->userInterface->printLine(sprintf("[%s] Dice to re-run:", $reRunAttempt));
    }

    /**
     * @param $reRunAttempt
     * @return array
     */
    private function requestDiceToReRun($reRunAttempt)
    {
        $this->printReRunAttempt($reRunAttempt);
        $diceToReRun = $this->getDiceToReRun();
        return $diceToReRun;
    }
}
