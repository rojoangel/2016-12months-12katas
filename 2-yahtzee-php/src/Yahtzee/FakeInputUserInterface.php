<?php


namespace Yahtzee;


class FakeInputUserInterface implements InputUserInterface
{

    /** @var array */
    private $input;

    /** @var int */
    private $index;

    /**
     * @param array $input
     */
    public function __construct(array $input)
    {
        $this->input = $input;
        $this->index = 0;
    }

    /**
     * @return array
     */
    function readDiceToRerun()
    {
        return $this->input[$this->index++];
    }
}