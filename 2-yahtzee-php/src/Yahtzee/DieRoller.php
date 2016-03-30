<?php
namespace Yahtzee;

interface DieRoller
{
    /**
     * @return int
     */
    public function roll();
}