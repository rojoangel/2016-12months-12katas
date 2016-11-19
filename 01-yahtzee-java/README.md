Yahtzee Kata Round I
============

## General requirements

Build a playable console [Yahtzee](https://en.wikipedia.org/wiki/Yahtzee) application. It's worth reading about Yahtzee before you start if you are not very familiar with the game.

The game should support 3 categories (Ones, Twos, and Threes). Player needs to roll the biggest number of 1s, 2s, and 3s
 for each category respectively.

The player will play categories in turn. The following is what you should see if you run the application:

<pre>
  > Category: Ones
  > Dice: D1:2 D2:4 D3:1 D4:6 D5:1
  > [1] Dice to re-run:
    $ D1 D2 D4
  > Dice: D1:1 D2:5 D3:1 D4:2 D5:1
  > [2] Dice to re-run:
    $ D2 D4
  > Dice: D1:1 D2:1 D3:1 D4:5 D5:1
  > Category Ones score: 4

  > Category: Twos
  > Dice: D1:2 D2:4 D3:1 D4:6 D5:1
  > ....

  > Category: Threes
  > Dice: D1:2 D2:4 D3:1 D4:6 D5:1
  > ....

  > Yahtzee score
  > Ones: 4
  > Twos: [Total for Twos]
  > Threes: [Total for Threes]
  > Final score: [sum of the points in each category]
</pre>