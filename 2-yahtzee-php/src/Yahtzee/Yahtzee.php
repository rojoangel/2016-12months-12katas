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
    }
}
