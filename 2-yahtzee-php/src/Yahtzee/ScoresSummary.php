<?php


namespace Yahtzee;


class ScoresSummary
{
    private $maxScores = [
        ['category' => 'Ones', 'maxScore' => 4],
        ['category' => 'Twos', 'maxScore' => 3],
        ['category' => 'Threes', 'maxScore' => 2]
    ];

    private $finalScore = 9;

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
}