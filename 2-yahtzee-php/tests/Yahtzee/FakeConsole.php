<?php


namespace Yahtzee;


class FakeConsole implements Console
{
    /** @var array */
    public $output;

    /** @var array */
    public $input;

    /** @var int */
    private $index;

    /**
     * FakeConsole constructor.
     * @param array $input
     */
    public function __construct(array $input)
    {
        $this->input = $input;
        $this->index = 0;
    }

    /**
     * @param string $line
     */
    public function printLine($line)
    {
        $this->output[] = $line;
    }

    function readDiceToRerun()
    {
        return $this->input[$this->index++];
    }


}