<?php


namespace Yahtzee;


class ReRuns
{
    /** @var UserInterface */
    private $userInterface;

    /** @var DiceRoller */
    private $diceRoller;

    /**
     * @param UserInterface $userInterface
     * @param DiceRoller $diceRoller
     */
    public function __construct(UserInterface $userInterface, DiceRoller $diceRoller)
    {
        $this->userInterface = $userInterface;
        $this->diceRoller = $diceRoller;
    }

    public function doReRuns($numReRuns)
    {
        for ($reRunAttempt = 1; $reRunAttempt <= $numReRuns; $reRunAttempt++) {
            $diceToReRun = $this->userInterface->requestDiceToReRun($reRunAttempt);
            $this->diceRoller->reRun($diceToReRun);
            $this->userInterface->printDiceLine($this->diceRoller->lastRollResult());
        }
    }
}
