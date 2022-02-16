# Flashcards
JetBrain's academy project - Flashcards. It's a console implementation of a simple game - Flashcards. In classical implementation of this game they show you a hint (a task or a picture) on one side and the right answer on the other.

## About
JetBrains Academy  
Track: Java Developer  
Project: Flashcards
https://hyperskill.org/projects/44?track=15

## Implemented Patterns
1. Strategy Pattern

## Description

Optional arguments:
- -import filename - load set of cards with stats before start
- -export filename - save set of cards with stats when closing

Example file with cards:
>great britain;london;1\
>poland;warsaw;3\
>russia;moscow;4\
>germany;berlin;5\
>austria;vienna;8

Programme action:
```
Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> import
File name:
> capitals.txt
5 cards have been loaded.

Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> add
The card:
> france
The definition of the card:
> paris
The pair ("france":"paris") has been added.

Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> add
The card:
> france
The card "france" already exists.

Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> add
The card:
> usa
The definition of the card:
> paris
The definition "paris" already exists.

Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> quizFormat
How many times to quizFormat?
> 3

Print the definition of "great britain":
> london
Correct!

Print the definition of "poland":
> cracow
Wrong. The right answer is "warsaw".

Print the definition of "russia":
> berlin
Wrong. The right answer is "moscow", but your definition is correct for "germany".

Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> hardest card
The hardest card is "austria". You have 8 errors answering it.

Input the action (add, remove, import, export, quizFormat, exit, log, hardest card, reset stats):
> log
File name:
> log.txt
The log has been saved.
```
