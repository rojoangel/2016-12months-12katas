<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;

    /** @var Categories */
    private $categories;

    /** @var OutputUserInterface */
    private $outputUserInterface;

    /** @var UserInterface */
    private $userInterface;

    /**
     * @param Categories $categories
     * @param OutputUserInterface $outputUserInterface
     * @param UserInterface $userInterface
     */
    public function __construct(Categories $categories, OutputUserInterface $outputUserInterface, UserInterface $userInterface)
    {
        $this->categories = $categories;
        $this->outputUserInterface = $outputUserInterface;
        $this->userInterface = $userInterface;
    }
    
    public function play() {

        $this->categories->play(self::RERUN_ATTEMPTS);
        $maxScores = [
            ['category' => 'Ones', 'maxScore' => 4],
            ['category' => 'Twos', 'maxScore' => 3]
        ];
        $this->printMaxScores($maxScores);
    }

    /**
     * @param array $maxScores
     */
    private function printMaxScores($maxScores)
    {
        $this->userInterface->printMaxScores($maxScores);
    }
}
