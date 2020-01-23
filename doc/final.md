# Final Report - SEM Group 11

## must-haves explained
All our original must-have requirements are implemented in our final application. Some of them are slightly changed however. Choices we made are explained in this section.

### The game must include a login screen for the player to log in
We first built a separate class for this: `LoginScreen`. Later on we decided that this was cumbersome, since the registration class had the exact same fields available. Therefor we combined those classes in the `MenuScreen` class.

### The game must include a registration screen for a new player to sign up
As stated above, we also included this inside the `MenuScreen` class.

### The game must include authentication to check if the player has an account  
If the user presses the 'Login' button, the client will send a request to the server to see whether the combination of the username and password is known. On the serverside we ask the database to search for such a combination. Depending on the result, the user is logged in or will see an error message.

### The player must be able to sign up for the game with an account
Whenever a user clicks the 'Create' button, a request for registration is sent to the server. If the username isn't known yet and the password satisfies our criteria, an account is created and the user can log in thereafter.

### The player must be able to log into the game
Once the user passed the authentication test, the user is stored on the client side in the `User` singleton. This way the application will know who its current user is.

### The player must be put into a start menu once they have successfully logged in 
After the user is authenticated and logged in, he/she is redirected to the `StartScreen`. This is where he/she can choose to play the game, show the leaderboard or exit the application.

### The player must be able to start a new game of snake from the start menu 
As stated above, in the `StartScreen` there's a button to start a new snake game.

### The player must be able to end the game once they have started 
At any point in the application, the user can close the window. We also added some buttons to exit the game: in the pause menu and in the start menu.

### The board must consist of a grid with a width of n by n cells 
We choose to make the board consist of 20 by 20 cells. This is specified in the `Board` class.

### The game’s board will have predefined boundaries
The snake cannot go out of the grid of 20 by 20. If it does, the game is over.

### The player’s snake shall spawn in a predefined location on the board 
Every time a new game is started, the snake will spawn in the same location: x=0 and y=0.

### The player’s snake will start with a predefined size of 2 cells of length and one cell of width 
The snake does indeed always start with a predefined size. However we choose to make it 5 instead of the preplanned 2. We decided this to make clear that it's a snake. Also, it increases the starting level by just a bit.

### The player’s snake will continuously move forward unless a player changes its direction, which will cause the snake to move forward in that specified direction
Every clock tick the snake is moved forward. Unless the user hit a button in the mean time, the snake keeps moving in the same direction.

### The player’s snake shall be able to change direction using the arrows keys to change the snake’s direction
If the user presses a button, either one of the arrows or WASD, the snake's direction will change to that direction. We chose to also include WASD, so that the player can choose the buttons that he/she is most comfortable with. There is no functional differecen between the arrows or WASD.

### The game must start with a snack already spawned in a predefined location 
Before the game is actually started, the snake is already visible in its starting position.

### The game shall allow the player to move over the snack and consume it, removing it from the board and incrementing the players score by 1
We use apples as our snacks, because we wanted to keep the link with original snake games. Once the snake collides with the apple, the apple is removed from the board. The user's score is increased, but to keep it attractive, the score is not increased by 1, but by 10 points.

### The player’s snake shall grow in size by 1 cell in length once it goes over an apple within the game 
This is done in the `Apple` class, so that other consumables, like powerups, can have different implementations. Once an apple is eaten, the snake will not grow 1, but 3 in length. If we didn't do this, the game would take forever to get more difficult.

### The game shall spawn a new snack instantaneously after the player consumes it in a random position on the board 
We took this requirement with a grain of salt. Currently, the games spawns a new apple at a random place, when there are no apples left on the board.
This is, because we have a powerup that spawns multiple apples.

### The game shall not spawn a snack if that cell is occupied by the player’s model or a boundary 
The `Apple` class has a static method `spawnApplePersistent`. This function randomly spawns an apple, but using another static method `isProperSpawnLocation` it prevents the apple from spawning in a cell that's currently occupied by the snake or by another apple.

### The game will end in a loss if the player runs into a predefined boundary on the map 
The `move` method inside the `Snake` class checks if the snake will stay within the boundaries. If it doesn't the game is over.

### The game will end in a loss if the player’s snake runs into itself 
The `move` and `collide` methods in the `Snake` class check whether the snake collides with itself. If it does, the game is over.

### The game will show the player’s score once the game has ended 
After the game is over, the score will stay visible as long as the user doesn't start a new game.

### The game will keep a leaderboard of the top 5 scores that have ever been recorded and show it to the player at the end of the game
We decided to not show this at the end of every game, since it will be enoying if a user wants to keep playing again and again. Therefor we prefered a separate screen for the leaderboard. It can be found in the `LeaderboardScreen` screen. Every time that the screen is opened the data from the server is refreshed, so that you can instantly see whether you're on top after your last game.

### The game will show the player their score at the end of the game
After the game is over, the score will stay visible as long as the user doesn't start a new game.

---

## Missing could-haves explained
Some of our could-have requirements are not implemented. This is why:

### The game should display the current duration of the game in the pause menu
This is not really relevant to the end-user; he/she is only interested in the score. Because of that, we didn't implement this.

### The game shall show the player’s game statistics after ending a game
Other than his/her highscore and current score there are no statistics implemented. Again, the end-user wants to be at the top of the leaderboard: the only thing that counts to him/her is the score - not other stats.

### The player should be able to view their past highscore
We decided that there's no point in knowing past highscores. The only thing that counts is the current highscore.

### The player should be able to view their current position on the highscore ladder
This is currently only partially possible. If the user is in the top 5, then he/she will be able to see his/her current position.