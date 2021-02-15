## Project: Battleship


## About

Battleship Game, https://hyperskill.org/projects/125?track=1

## Instructions

- The game starts off with any type of 2 players (human/computer) where they input the ships using two coords. ex: (F6 G6), the players are given 5 ships each with varying length.
- After each player correctly has placed their ships, the battle commences, where both players take turns firing at coordinates. If the coordinate is located where the opponent's ship is at, then is marked as HIT, if miss marked as M. 
- The first player to sink all the ships wins. 


## what i learned
- general concepts should belong to what the class can do if it was in real life. (ex: player should be able to shoot, placeships, battlefield stores positions, and ships) all these things are true in real life battleship. This isn't required, but it wouldn't make any sense if the battlefield (the board itself) would be able to shoot. (was done in a previous version) 

- should design my code with interfaces in mind; thus when I add a different player extending the player class, I just have to implement the 2 necessary methods for the code to
work.
- splitting a concept into some sub-concepts proved very useful. (ship -> shipcoord, shiptypes, parts).
- Design patterns:
- keep it simple
- do not repeat code 

### Naming conventions:
- first letter of each word in the class name should start with Uppercase, is made up with descriptive nouns. 
- method names should have verbs (action), first word should be lowercase; words following that are uppercase (first letter)
- constants in all capital letters
