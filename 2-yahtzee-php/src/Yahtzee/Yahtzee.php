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
        $this->console->printLine("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        $this->console->printLine("[1] Dice to re-run:");
    }
}