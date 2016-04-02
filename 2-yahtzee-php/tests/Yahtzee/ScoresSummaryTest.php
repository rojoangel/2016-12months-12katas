<?php


namespace Yahtzee;


class ScoresSummaryTest extends \PHPUnit_Framework_TestCase
{

    public function testRegisterScore()
    {
        $scoresSummary = new ScoresSummary();
        $scoresSummary->registerScore(Category::Ones(), 1);
        $scoresSummary->registerScore(Category::Twos(), 3);
        $scoresSummary->registerScore(Category::Threes(), 4);

        $expectedMaxScores = [
            'Ones' => 1,
            'Twos' => 3,
            'Threes' => 4
        ];
        $this->assertEquals($expectedMaxScores, $scoresSummary->getMaxScores());
    }
}
