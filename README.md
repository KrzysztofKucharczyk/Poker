# Poker

## Synopsis

Poker project is checking which players will win, having preset cards. It's not about the game itself, it's more about 
finding out which hand is better (or is it draw in some cases).

## Rules

There is set hierarchy when it comes to comparing hands. From the highest to lowest:
- Royal Flush
- Straight Flush
- Four of a kind
- Full
- Flush
- Straight
- Three of a kind
- Two pairs
- Pair
- High card

When both players have the same hand, they should compare highest cards. If there is no differences
 - turn ends with draw.

## Progam

Program has been developed in Eclipse IDE as maven project. 
Program is focused on working with a file. Right now used file is hardcoded, but in future version
it will be possible to specify it via command line argument. The program is checking all n-lines
of hands, calculate result of comparing them, and outputing points of the first player (player whose hand is first in sourcefile). To run program, simply run it from Eclipse (shift+alt+j) or via 
terminal.

## Tests

There are 44 unit tests in project, all passes. To launch them, simply run (shift+alt+t) AllTests.java or any one from /src/test/java.
