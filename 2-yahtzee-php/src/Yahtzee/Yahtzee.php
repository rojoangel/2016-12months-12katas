<?php


namespace Yahtzee;


class Yahtzee
{
    /**
     * @var Console
     */
    private $console;

    /**
     * @param Console $console
     */
    public function __construct(Console $console)
    {
        $this->console = $console;
    }
    
    public function play() {
        $this->console->printLine("Category: Ones");
    }
}