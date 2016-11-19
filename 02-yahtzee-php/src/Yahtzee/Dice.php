<?php


namespace Yahtzee;


class Dice
{
    /** @var string */
    private $label;

    /**
     * @return Dice
     */
    public static function D1() {
        return new self('D1');
    }

    /**
     * @return Dice
     */
    public static function D2() {
        return new self('D2');
    }

    /**
     * @return Dice
     */
    public static function D3() {
        return new self('D3');
    }

    /**
     * @return Dice
     */
    public static function D4() {
        return new self('D4');
    }

    /**
     * @return Dice
     */
    public static function D5() {
        return new self('D5');
    }

    /**
     * @return Dice[]
     */
    public static function all() {
        return [
            self::D1(),
            self::D2(),
            self::D3(),
            self::D4(),
            self::D5()
        ];
    }

    /**
     * @param $value
     * @return Dice
     */
    public static function fromString($value) {
        return new self($value);
    }
    
    /**
     * @param string $label
     */
    private function __construct($label)
    {
        $this->label = $label;
    }

    /**
     * @return string
     */
    function __toString()
    {
        return $this->label;
    }
}
