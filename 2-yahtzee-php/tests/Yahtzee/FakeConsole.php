<?php


namespace Yahtzee;


class FakeConsole implements Console
{
    /** @var array */
    public $output;

    /**
     * @param string $line
     */
    public function printLine($line)
    {
        $this->output[] = $line;
    }
}