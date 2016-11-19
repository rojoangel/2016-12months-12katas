<?php


namespace Yahtzee;


class FakeOutputUserInterface implements OutputUserInterface
{
    /** @var array */
    public $output = [];
    
    /**
     * @param string $line
     */
    public function printLine($line)
    {
        $this->output[] = $line;
    }
}