<?php


namespace Yahtzee;


class InputOutputUserInterface implements UserInterface
{
    /** @var OutputUserInterface */
    public $output;

    /** @var array */
    public $input;

    /** @var int */
    private $index;

    /**
     * @param array $input
     * @param OutputUserInterface $output
     */
    public function __construct(array $input, OutputUserInterface $output)
    {
        $this->input = $input;
        $this->index = 0;
        $this->output = $output;
    }

    /**
     * @param string $line
     */
    public function printLine($line)
    {
        $this->output->printLine($line);
    }

    function readDiceToRerun()
    {
        return $this->input[$this->index++];
    }


}