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
     * @return Category
     */
    public static function Ones()
    {
        return new self('Ones', 1);
    }

    /**
     * @return Category
     */
    public static function Twos()
    {
        return new self('Twos', 2);
    }

    /**
     * @return Category
     */
    public static function Threes()
    {
        return new self('Threes', 3);
    }

    /**
     * @return Category[]
     */
    public static function all()
    {
        return [
            self::Ones(),
            self::Twos(),
            self::Threes()
        ];
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
}