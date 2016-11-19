<?php
namespace Yahtzee;

interface InputUserInterface
{
    /**
     * @return string
     */
    function readLine();
}