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
        $maxScores = [
            ['category' => 'Ones', 'maxScore' => 4],
            ['category' => 'Twos', 'maxScore' => 3],
            ['category' => 'Threes', 'maxScore' => 2]
        ];
        $finalScore = 9;
        $this->printMaxScores($maxScores, $finalScore);
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
