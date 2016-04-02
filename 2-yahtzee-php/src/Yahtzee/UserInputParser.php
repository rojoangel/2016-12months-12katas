<?php


namespace Yahtzee;


class UserInputParser
{
    /**
     * @param string $input
     */
    public function parse($input)
    {
        return array_map(
            function ($token) {
                return Dice::fromString($token);
            },
            explode(' ', $input)
        );
    }
}