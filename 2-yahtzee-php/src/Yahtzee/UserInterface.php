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

    /**
     * @param string $categoryTitle
     */
    function printCategory($categoryTitle);

    /**
     * @param array $dice
     */
    function printDiceLine($dice);

    /**
     * @param string $categoryTitle
     * @param int $categoryScore
     */
    function printCategoryScore($categoryTitle, $categoryScore);

    /**
     * @param int $reRunAttempt
     */
    function printReRunAttempt($reRunAttempt);
}