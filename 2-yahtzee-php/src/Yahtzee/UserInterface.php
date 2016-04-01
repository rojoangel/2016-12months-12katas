<?php
namespace Yahtzee;

interface UserInterface
{
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
     * @return array
     */
    function requestDiceToReRun($reRunAttempt);
}