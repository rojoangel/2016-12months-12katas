<?php


namespace Yahtzee;


class Yahtzee
{
    const RERUN_ATTEMPTS = 2;

    /** @var UserInterface */
    private $userInterface;
    
    /** @var DiceRoller */
    private $diceRoller;
    /**
     * @var ReRuns
     */
    private $reRuns;

    /**
     * @param UserInterface $userInterface
     * @param DiceRoller $diceRoller
     * @param ReRuns $reRuns
     */
    public function __construct(UserInterface $userInterface, DiceRoller $diceRoller, ReRuns $reRuns)
    {
        $this->userInterface = $userInterface;
        $this->diceRoller = $diceRoller;
        $this->reRuns = $reRuns;
    }
    
    public function play() {

        $this->playCategories(self::RERUN_ATTEMPTS);
    }

    /**
     * @param int $numReRuns
     */
    private function playCategories($numReRuns)
    {
        $categories = new Categories($this->userInterface, $this->diceRoller, $this->reRuns);
        $categories->play($numReRuns);
    }
}
