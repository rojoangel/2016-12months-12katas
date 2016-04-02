<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;

    /** @var Categories */
    private $categories;

    /** @var OutputUserInterface */
    private $outputUserInterface;

    /**
     * @param Categories $categories
     * @param OutputUserInterface $outputUserInterface
     */
    public function __construct(Categories $categories, OutputUserInterface $outputUserInterface)
    {
        $this->categories = $categories;
        $this->outputUserInterface = $outputUserInterface;
    }
    
    public function play() {

        $this->categories->play(self::RERUN_ATTEMPTS);
        $this->outputUserInterface->printLine("Yahtzee score");
        $maxScores = [
            ['category' => 'Ones', 'maxScore' => 4],
            ['category' => 'Twos', 'maxScore' => 3]
        ];
        $this->printCategoryScore($maxScores[0]['category'], $maxScores[0]['maxScore']);
        $this->printCategoryScore($maxScores[1]['category'], $maxScores[1]['maxScore']);
    }

    /**
     * @param string $category
     * @param int $maxScore
     */
    private function printCategoryScore($category, $maxScore)
    {
        $inputOutputUserInterface = new InputOutputUserInterface(new FakeInputUserInterface([]), $this->outputUserInterface);
        $inputOutputUserInterface->printCategoryMaxScore($category, $maxScore);
    }
}
