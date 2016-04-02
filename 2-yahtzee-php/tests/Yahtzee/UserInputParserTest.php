<?php


namespace Yahtzee;


class UserInputParserTest extends \PHPUnit_Framework_TestCase
{
    public function testParse()
    {
        $parser = new UserInputParser();
        $this->assertEquals(['1', '2', '3', '4' ,'5'], $parser->parse("D1 D2 D3 D4 D5"));
    }
}
