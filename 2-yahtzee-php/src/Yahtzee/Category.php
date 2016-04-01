<?php


namespace Yahtzee;


class Category
{
    /** @var string */
    private $label;

    /** @var int */
    private $value;

    /**
     * @param string $label
     * @param int $value
     */
    private function __construct($label, $value)
    {
        $this->label = $label;
        $this->value = $value;
    }

    /**
     * @return string
     */
    function __toString()
    {
        return $this->label;
    }

    /**
     * @param array $dice
     * @return int
     */
    public function calculateScore($dice)
    {
        return count(array_filter($dice, function ($die) {
            return $die == $this->value;
        }));
    }

    /**
     * @return Category
     */
    public static function all()
    {
        return [
            new self('Ones', 1),
            new self('Twos', 2)
        ];
    }
}