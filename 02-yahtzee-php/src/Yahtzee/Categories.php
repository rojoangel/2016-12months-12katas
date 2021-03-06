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

    /** @var ScoresSummary */
    private $scoresSummary;

    /**
     * @param UserInterface $userInterface
     * @param DiceRoller $diceRoller
     * @param ReRuns $reRuns
     * @param ScoresSummary $scoresSummary
     */
    public function __construct(
        UserInterface $userInterface,
        DiceRoller $diceRoller,
        ReRuns $reRuns,
        ScoresSummary $scoresSummary
    ) {
        $this->userInterface = $userInterface;
        $this->diceRoller = $diceRoller;
        $this->reRuns = $reRuns;
        $this->scoresSummary = $scoresSummary;
    }

    /**
     * @param int $numReRuns
     */
    public function play($numReRuns)
    {
        foreach (Category::all() as $category) {
            $this->userInterface->printCategory($category);
            $this->diceRoller->rollAll();
            $this->userInterface->printDiceLine($this->diceRoller->lastRollResult());
            $this->reRuns->doReRuns($numReRuns);
            $categoryScore = $category->calculateScore($this->diceRoller->lastRollResult());
            $this->scoresSummary->registerScore($category, $categoryScore);
            $this->userInterface->printCategoryScore($category, $categoryScore);
        }
    }

    public function printScoresSummary()
    {
        $this->userInterface->printScoresSummary($this->scoresSummary);
    }
}
