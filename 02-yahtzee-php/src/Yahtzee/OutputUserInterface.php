<?php
namespace Yahtzee;

interface OutputUserInterface
{
    /**
     * @param string $line
     */
    public function printLine($line);
}