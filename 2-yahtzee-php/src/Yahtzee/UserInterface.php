<?php
namespace Yahtzee;

interface UserInterface
{
    /**
     * @param $line
     */
    function printLine($line);

    /**
     * @return array
     */
    function readDiceToRerun();
}