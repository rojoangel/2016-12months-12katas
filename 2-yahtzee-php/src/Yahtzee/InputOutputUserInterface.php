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
     * @param string $categoryTitle
     */
    public function printCategory($categoryTitle)
    {
        $this->output->printLine(sprintf("Category: %s", $categoryTitle));
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
     * @param string $categoryTitle
     * @param int $categoryScore
     */
    public function printCategoryScore($categoryTitle, $categoryScore)
    {
        $this->output->printLine(sprintf("Category %s score: %s", $categoryTitle, $categoryScore));
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

}
