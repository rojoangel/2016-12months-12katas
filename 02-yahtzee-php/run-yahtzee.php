<?php

require __DIR__.'/src/Yahtzee/UserInterface.php';
require __DIR__.'/src/Yahtzee/InputUserInterface.php';
require __DIR__.'/src/Yahtzee/OutputUserInterface.php';
require __DIR__.'/src/Yahtzee/DieRoller.php';
require __DIR__.'/src/Yahtzee/ScoresSummary.php';
require __DIR__.'/src/Yahtzee/UserInputParser.php';
require __DIR__.'/src/Yahtzee/ConsoleInput.php';
require __DIR__.'/src/Yahtzee/ConsoleOutput.php';
require __DIR__.'/src/Yahtzee/InputOutputUserInterface.php';
require __DIR__.'/src/Yahtzee/RandomDieRoller.php';
require __DIR__.'/src/Yahtzee/DiceRoller.php';
require __DIR__.'/src/Yahtzee/ReRuns.php';
require __DIR__.'/src/Yahtzee/InMemoryScoresSummary.php';
require __DIR__.'/src/Yahtzee/Categories.php';
require __DIR__.'/src/Yahtzee/Yahtzee.php';
require __DIR__.'/src/Yahtzee/Category.php';
require __DIR__.'/src/Yahtzee/Dice.php';

use Yahtzee\Categories;
use Yahtzee\ConsoleInput;
use Yahtzee\ConsoleOutput;
use Yahtzee\DiceRoller;
use Yahtzee\InMemoryScoresSummary;
use Yahtzee\InputOutputUserInterface;
use Yahtzee\RandomDieRoller;
use Yahtzee\ReRuns;
use Yahtzee\UserInputParser;
use Yahtzee\Yahtzee;

$inputUserInterface = new ConsoleInput();
$outputUserInterface = new ConsoleOutput();
$userInputParser = new UserInputParser();
$userInterface = new InputOutputUserInterface($inputUserInterface, $outputUserInterface, $userInputParser);
$dieRoller = new RandomDieRoller();
$diceRoller = new DiceRoller($dieRoller);
$reRuns = new ReRuns($userInterface, $diceRoller);
$scoresSummary = new InMemoryScoresSummary();
$categories = new Categories($userInterface, $diceRoller, $reRuns, $scoresSummary);
$yathzee = new Yahtzee($categories);

$yathzee->play();