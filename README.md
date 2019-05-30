# Nim
Nim is a simple strategy game that you can play (using the console) against another player or against AI

### What is Nim?
Nim is a strategy game where two players take turns removing objects from 3 piles. On each turn, a player can remove objects (one to many) from a single pile. The goal of the game is to avoid picking up the last object, as whoever does it the loser! 

### But why Nim?
In Fall 2017, I began studying at Sheridan College, but half way through the semester the Ontario College strike began. I was worried that during the strike I would get out of practice and wanted to complete a project that would help reinforce the concepts I learned in Object-Oriented Programming I (aka, Intro Java). Nim helped me practice loops, getting input from the user, manipultate multiple if-statements to develop AI, method overloading, and also how to take an concept and actually create something from scratch!

### Tell me more about player vs AI!
If you Google "Nim Strategy", there is a strategy to win everytime. However, as I wanted this to be an exercise for me thinking out all the possible situations/solutions, I did not follow any strategy. Instead, when you play against the AI, you're really playing against me--or at least, what I would do in the situation. I realized that I didn't have to make an if-statement for every single possibility, but instead noticed that it only mattered if there were any empty piles, if the remaining piles were even or odd, and if the remaining piles had three or more objects in them. By that criteria alone, I was able to create something that would be responsive to any situation.

### Notes/Precautions/To-Dos
At the time of development, I had been coding for about 1.5 months, so the code isn't quite as elegant as it could be. There is also a bug I was not able to recreate where when playing against the computer, it took from a pile that was already empty (considered an illegal move in Nim). 
