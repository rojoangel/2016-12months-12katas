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

        $dice = [2, 4, 1, 6, 1];
        $this->printDiceLine($dice);

        $this->console->printLine("[1] Dice to re-run:");

        $this->getDiceToReRun();

        $dice = [1, 5, 1, 2, 1];
        $this->printDiceLine($dice);
    }

    /**
     * @param array $dice
     */
    private function printDiceLine($dice)
    {
        $this->console->printLine(sprintf(
            "Dice: D1:%s D2:%s D3:%s D4:%s D5:%s", $dice[0], $dice[1], $dice[2], $dice[3], $dice[4]));
    }

    /**
     * @return array
     */
    private function getDiceToReRun()
    {
        return [1, 2, 4];
    }
}
