<?php


namespace Yahtzee;


class InputOutputUserInterface implements UserInterface
{
    /** @var InputUserInterface */
    public $input;

    /** @var OutputUserInterface */
    public $output;

    /**
     * @param InputUserInterface $input
     * @param OutputUserInterface $output
     */
    public function __construct(InputUserInterface $input, OutputUserInterface $output)
    {
        $this->input = $input;
        $this->output = $output;
    }

    /**
     * @param string $line
     */
    public function printLine($line)
    {
        $this->output->printLine($line);
    }

    /**
     * @return array
     */
    function readDiceToRerun()
    {
        return $this->input->readDiceToRerun();
    }
}
