<?php


namespace Yahtzee;


class ConsoleOutput implements OutputUserInterface
{

    /**
     * @param string $line
     */
    public function printLine($line)
    {
        echo($line . PHP_EOL);
    }
}