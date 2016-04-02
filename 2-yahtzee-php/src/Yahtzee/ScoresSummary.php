<?php
namespace Yahtzee;

interface ScoresSummary
{
    /**
     * @return array
     */
    function getMaxScores();

    /**
     * @return int
     */
    function getFinalScore();

    /**
     * @param Category $category
     * @param int $categoryScore
     */
    function registerScore(Category $category, $categoryScore);
}