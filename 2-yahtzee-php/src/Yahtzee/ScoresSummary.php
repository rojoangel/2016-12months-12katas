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
    function calculateFinalScore();

    /**
     * @param Category $category
     * @param int $categoryScore
     */
    function registerScore(Category $category, $categoryScore);
}