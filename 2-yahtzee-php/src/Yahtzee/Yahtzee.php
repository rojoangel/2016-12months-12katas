<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;

    /** @var Categories */
    private $categories;

    /**
     * @param Categories $categories
     */
    public function __construct(Categories $categories)
    {
        $this->categories = $categories;
    }
    
    public function play() {

        $this->categories->play(self::RERUN_ATTEMPTS);
    }
}
