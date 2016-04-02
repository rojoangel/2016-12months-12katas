<?php


namespace Yahtzee;


class InputOutputUserInterface implements UserInterface
{
    /** @var InputUserInterface */
    public $input;

    /** @var OutputUserInterface */
    public $output;

    /**
     * @param InputUserInterface $input
     * @param OutputUserInterface $output
     */
    public function __construct(InputUserInterface $input, OutputUserInterface $output)
    {
        $this->input = $input;
        $this->output = $output;
    }

    /**
     * @param Category $category
     */
    public function printCategory($category)
    {
        $this->output->printLine(sprintf("Category: %s", $category));
    }

    /**
     * @param array $dice
     */
    public function printDiceLine($dice)
    {
        $this->output->printLine(sprintf(
            "Dice: D1:%s D2:%s D3:%s D4:%s D5:%s", $dice[0], $dice[1], $dice[2], $dice[3], $dice[4]));
    }

    /**
     * @param Category $category
     * @param int $categoryScore
     */
    public function printCategoryScore($category, $categoryScore)
    {
        $this->output->printLine(sprintf("Category %s score: %s", $category, $categoryScore));
    }

    /**
     * @param int $reRunAttempt
     * @return array
     */
    public function requestDiceToReRun($reRunAttempt)
    {
        $this->printReRunAttempt($reRunAttempt);
        $diceToReRun = $this->readDiceToRerun();
        return $diceToReRun;
    }

    /**
     * @return array
     */
    private function readDiceToRerun()
    {
        return $this->input->readDiceToRerun();
    }

    /**
     * @param int $reRunAttempt
     */
    private function printReRunAttempt($reRunAttempt)
    {
        $this->output->printLine(sprintf("[%s] Dice to re-run:", $reRunAttempt));
    }

    /**
     * @param ScoresSummary $scoresSummary
     */
    public function printScoresSummary(ScoresSummary $scoresSummary)
    {
        $this->printMaxScoresHeader();
        foreach ($scoresSummary->getMaxScores() as $category => $maxScore) {
            $this->printCategoryMaxScore($category, $maxScore);
        }
        $this->printFinalScore($scoresSummary->calculateFinalScore());
    }

    private function printMaxScoresHeader()
    {
        $this->output->printLine("Yahtzee score");
    }

    /**
     * @param string $category
     * @param int $maxScore
     */
    private function printCategoryMaxScore($category, $maxScore)
    {
        $this->output->printLine(sprintf("%s: %s", $category, $maxScore));
    }

    /**
     * @param $finalScore
     */
    private function printFinalScore($finalScore)
    {
        $this->output->printLine(sprintf("Final score: %s", $finalScore));
    }
}
