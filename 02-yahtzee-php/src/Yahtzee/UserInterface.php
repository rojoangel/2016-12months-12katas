<?php
namespace Yahtzee;

interface UserInterface
{
    /**
     * @param Category $category
     */
    function printCategory($category);

    /**
     * @param array $dice
     */
    function printDiceLine($dice);

    /**
     * @param Category $category
     * @param int $categoryScore
     */
    function printCategoryScore($category, $categoryScore);

    /**
     * @param int $reRunAttempt
     * @return Dice[]
     */
    function requestDiceToReRun($reRunAttempt);

    /**
     * @param ScoresSummary $scoresSummary
     */
    function printScoresSummary(ScoresSummary $scoresSummary);
}