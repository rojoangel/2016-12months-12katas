<?php


namespace Yahtzee;


class Categories
{
    /** @var UserInterface */
    private $userInterface;

    /** @var DiceRoller */
    private $diceRoller;

    /** @var ReRuns */
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

    /**
     * @param int $numReRuns
     */
    public function play($numReRuns)
    {
        foreach (Category::all() as $category) {
            /** @var Category $category */
            $this->userInterface->printCategory($category);
            $this->diceRoller->rollAll();
            $this->userInterface->printDiceLine($this->diceRoller->lastRollResult());
            $this->reRuns->doReRuns($numReRuns);
            $this->userInterface->printCategoryScore($category, $category->calculateScore($this->diceRoller->lastRollResult()));
        }
    }
}
