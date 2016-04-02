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
     */
    public function __construct(Categories $categories, UserInterface $userInterface)
    {
        $this->categories = $categories;
        $this->userInterface = $userInterface;
        $this->scoresSummary = new ScoresSummary();

    }
    
    public function play() {

        $this->categories->play(self::RERUN_ATTEMPTS);
        $this->printMaxScores($this->scoresSummary->getMaxScores(), $this->scoresSummary->getfinalScore());
    }

    /**
     * @param array $maxScores
     * @param int $finalScore
     */
    private function printMaxScores($maxScores, $finalScore)
    {
        $this->userInterface->printMaxScores($maxScores, $finalScore);
    }
}
