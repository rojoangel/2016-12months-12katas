<?php


namespace Yahtzee;


class ConsoleInput implements InputUserInterface
{

    /**
     * @return string
     */
    function readLine()
    {
        return trim(fgets(STDIN));
    }
}