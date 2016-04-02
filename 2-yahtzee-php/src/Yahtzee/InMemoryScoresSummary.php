<?php


namespace Yahtzee;


class InMemoryScoresSummary implements ScoresSummary
{
    /** @var array */
    private $maxScores;

    public function __construct()
    {
        $this->maxScores = [];
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
        $finalScore = 0;
        foreach($this->maxScores as $maxScore) {
            $finalScore = $finalScore + $maxScore;
        }
        return $finalScore;
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