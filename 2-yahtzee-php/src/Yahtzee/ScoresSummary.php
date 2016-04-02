<?php


namespace Yahtzee;


class ScoresSummary
{
    /** @var array */
    private $maxScores;

    /** @var int */
    private $finalScore;

    public function __construct()
    {
        $this->maxScores = [];
        $this->finalScore = 9;
    }

    /**
     * @return array
     */
    public function getMaxScores()
    {
        return $this->maxScores;
    }

    /**
     * @return int
     */
    public function getFinalScore()
    {
        return $this->finalScore;
    }

    /**
     * @param Category $category
     * @param int $categoryScore
     */
    public function registerScore(Category $category, $categoryScore)
    {
        $this->maxScores[(string) $category] = $categoryScore;
    }
}