<?php


namespace Yahtzee;


class UserInputParserTest extends \PHPUnit_Framework_TestCase
{
    public function testParse()
    {
        $parser = new UserInputParser();

        $expectedResult = [
            Dice::D1(),
            Dice::D2(),
            Dice::D3(),
            Dice::D4(),
            Dice::D5()
        ];
        $this->assertEquals($expectedResult, $parser->parse("D1 D2 D3 D4 D5"));
    }
}
