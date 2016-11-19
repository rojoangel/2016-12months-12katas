<?php


namespace Yahtzee;


class RandomDieRoller implements DieRoller
{

    /**
     * @return int
     */
    public function roll()
    {
        return rand(1, 6);
    }
}