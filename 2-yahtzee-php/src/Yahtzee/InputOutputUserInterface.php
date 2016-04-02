<?php


namespace Yahtzee;


class InputOutputUserInterface implements UserInterface
{
    /** @var InputUserInterface */
    private $input;

    /** @var OutputUserInterface */
    private $output;

    /** @var UserInputParser */
    private $userInputParser;

    /**
     * @param InputUserInterface $input
     * @param OutputUserInterface $output
     * @param UserInputParser $userInputParser
     */
    public function __construct(
        InputUserInterface $input,
        OutputUserInterface $output,
        UserInputParser $userInputParser)
    {
        $this->input = $input;
        $this->output = $output;
        $this->userInputParser = $userInputParser;
    }

    /**
     * @param Category $category
     */
    public function printCategory($category)
    {
        $this->output->printLine(sprintf("Category: %s", $category));
    }

    /**
     * @param Dice[] $dice
     */
    public function printDiceLine($dice)
    {
        $formattedDice = "Dice:";
        foreach ($dice as $die => $value) {
            $formattedDice  = $formattedDice . sprintf(" %s:%s", $die, $value);
        }
        $this->output->printLine($formattedDice);
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
     * @return Dice[]
     */
    public function requestDiceToReRun($reRunAttempt)
    {
        $this->printReRunAttempt($reRunAttempt);
        $diceToReRun = $this->readDiceToRerun();
        return $diceToReRun;
    }

    /**
     * @return Dice[]
     */
    private function readDiceToRerun()
    {
        return $this->userInputParser->parse($this->input->readDiceToRerun());
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
