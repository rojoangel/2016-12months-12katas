<?php
namespace Yahtzee;

interface Console
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