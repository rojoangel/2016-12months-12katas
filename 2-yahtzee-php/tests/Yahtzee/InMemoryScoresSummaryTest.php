<?php


namespace Yahtzee;


class InMemoryScoresSummaryTest extends \PHPUnit_Framework_TestCase
{

    public function testRegisterScore()
    {
        $scoresSummary = new InMemoryScoresSummary();
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

    public function testFinalScore()
    {
        $scoresSummary = new InMemoryScoresSummary();
        $scoresSummary->registerScore(Category::Ones(), 1);
        $scoresSummary->registerScore(Category::Twos(), 3);
        $scoresSummary->registerScore(Category::Threes(), 4);

        $this->assertEquals(8, $scoresSummary->getFinalScore());
    }


}
