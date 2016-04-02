<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;

    /** @var Categories */
    private $categories;


    /** @var UserInterface */
    private $userInterface;

    /**
     * @param Categories $categories
     * @param UserInterface $userInterface
     */
    public function __construct(Categories $categories, UserInterface $userInterface)
    {
        $this->categories = $categories;
        $this->userInterface = $userInterface;
    }
    
    public function play() {

        $this->categories->play(self::RERUN_ATTEMPTS);
        $scoresSummary = new ScoresSummary();
        
        $this->printMaxScores($scoresSummary->getMaxScores(), $scoresSummary->getfinalScore());
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
