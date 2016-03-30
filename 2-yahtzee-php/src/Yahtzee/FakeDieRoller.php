<?php


namespace Yahtzee;


class FakeDieRoller implements DieRoller
{
    /**
     * @var array
     */
    private $dice;

    /**
     * @var int
     */
    private $index;

    /**
     * @param array $dice
     */
    public function __construct(array $dice)
    {
        $this->dice = $dice;
        $this->index = 0;
    }

    /**
     * @return int
     */
    public function roll()
    {
        return $this->dice[$this->index++];
    }
}