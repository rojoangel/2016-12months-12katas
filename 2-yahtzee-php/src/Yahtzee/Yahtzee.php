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
     * @var ReRuns
     */
    private $reRuns;

    /**
     * @param UserInterface $userInterface
     * @param DiceRoller $diceRoller
     * @param ReRuns $reRuns
     */
    public function __construct(UserInterface $userInterface, DiceRoller $diceRoller, ReRuns $reRuns)
    {
        $this->userInterface = $userInterface;
        $this->diceRoller = $diceRoller;
        $this->reRuns = $reRuns;
    }
    
    public function play() {

        foreach (Category::all() as $category) {
            /** @var Category $category */
            $this->printCategory($category);
            $this->diceRoller->rollAll();
            $this->printDiceLine($this->diceRoller->lastRollResult());
            $this->reRuns->doReRuns(self::RERUN_ATTEMPTS);
            $this->printCategoryScore($category, $category->calculateScore($this->diceRoller->lastRollResult()));
        }
    }

    /**
     * @param Category $category
     */
    private function printCategory($category)
    {
        $this->userInterface->printCategory($category);
    }

    /**
     * @param array $dice
     */
    private function printDiceLine($dice)
    {
        $this->userInterface->printDiceLine($dice);
    }

    /**
     * @param Category $category
     * @param int $categoryScore
     */
    private function printCategoryScore($category, $categoryScore)
    {
        $this->userInterface->printCategoryScore($category, $categoryScore);
    }
}
