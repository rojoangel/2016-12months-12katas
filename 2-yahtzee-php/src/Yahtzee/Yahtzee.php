<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;

    /** @var Categories */
    private $categories;


    /** @var UserInterface */
    private $userInterface;

    /** @var ScoresSummary */
    private $scoresSummary;

    /**
     * @param Categories $categories
     * @param UserInterface $userInterface
     * @param ScoresSummary $scoresSummary
     */
    public function __construct(Categories $categories, UserInterface $userInterface, ScoresSummary $scoresSummary)
    {
        $this->categories = $categories;
        $this->userInterface = $userInterface;
        $this->scoresSummary = $scoresSummary;
    }
    
    public function play() {

        $this->categories->play(self::RERUN_ATTEMPTS);
        $this->categories->printScoresSummary();
    }
}
