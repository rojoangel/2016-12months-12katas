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

        $categoryTitle = "Ones";
        $categoryValue = 1;

        $this->printCategory($categoryTitle);

        $dice = $this->rollAllDice();
        $this->printDiceLine($dice);

        for ($reRunAttempt = 1; $reRunAttempt <= self::RERUN_ATTEMPTS; $reRunAttempt++) {
            $diceToReRun = $this->requestDiceToReRun($reRunAttempt);
            $dice = $this->reRunDice($diceToReRun);
            $this->printDiceLine($dice);
        }

        $categoryScore = $this->calculateCategoryScore($categoryValue, $dice);
        $this->printCategoryScore($categoryTitle, $categoryScore);
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
     * @param array $diceToReRun
     * @return array
     */
    private function reRunDice($diceToReRun)
    {
        return $this->diceRoller->reRun($diceToReRun);
    }

    /**
     * @param string $categoryTitle
     */
    private function printCategory($categoryTitle)
    {
        $this->userInterface->printCategory($categoryTitle);
    }

    /**
     * @param array $dice
     */
    private function printDiceLine($dice)
    {
        $this->userInterface->printDiceLine($dice);
    }

    /**
     * @param string $categoryTitle
     * @param int $categoryScore
     */
    private function printCategoryScore($categoryTitle, $categoryScore)
    {
        $this->userInterface->printCategoryScore($categoryTitle, $categoryScore);
    }

    /**
     * @param int $reRunAttempt
     */
    private function printReRunAttempt($reRunAttempt)
    {
        $this->userInterface->printReRunAttempt($reRunAttempt);
    }

    /**
     * @param int $reRunAttempt
     * @return array
     */
    private function requestDiceToReRun($reRunAttempt)
    {
        $this->printReRunAttempt($reRunAttempt);
        $diceToReRun = $this->getDiceToReRun();
        return $diceToReRun;
    }

    /**
     * @param int $categoryValue
     * @param array $dice
     * @return int
     */
    private function calculateCategoryScore($categoryValue, $dice)
    {
        $score = count(array_filter($dice, function ($die) use ($categoryValue) {
            return $die == $categoryValue;
        }));
        return $score;
    }
}
