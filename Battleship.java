/* Kirstie O'Connell	Final Project	2018Dec08 
 * This is a game of Battleship where a fleet of ships are created and randomly
 * placed on a generated game board of varying sizes depending on the level
 * of difficulty chosen. Player against the computer has so many guesses depending on 
 * level to find and sink the fleet to win.
 */

/* This particular file sets the game into play by calling the other files needed
 * to play the game.  
 */

public class Battleship extends ActionGame {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the game of Battleship!");
		System.out.println("There is a war in the ocean and it is your mission to");
		System.out.println("seek and sink all enemy ships!");
		System.out.println("You have 3 choices of war level ---");
		System.out.println();
		System.out.println("Choose a level of difficulty: ");
		System.out.println("Level 1  =  6x6 board with 30 missiles");
		System.out.println("Level 2  =  9x9 board with 50 missiles");
		System.out.println("Level 3  = 12x12 board with 75 missiles");
		System.out.println("Enter level number: ");
		
				
		//This calls the correct board to be generated to start play by the difficulty chosen
		difficultyChoice(chooseLevel());	//this sets up the gameboard according to difficulty level
		gameStats();						//this prints the stats for the game 
		Gameboard.placeShips();				//This call places ships on board
		Gameboard.showBoard();				//This call shows the board after the placement of the ships 
		Gameboard.showGame();				//this one shows the game board ready for regular play
		
		//this starts the loop for the game
		for(int i = 1; i < gameloop ; i++) {		//this loop used for the game 
			//the following gets coordinates for shot
			int y = getYCoord();		
			int x = getXCoord();
			hitOrMiss(Gameboard.getCellStatus(x, y));
			gameStats();
			//System.out.println(Gameboard.getCellStatus(x, y));	//This line is used for testing 
			if (shipsLeft()==0) {
				System.out.println("YOU SUNK ALL THE SHIPS! CONGRATULATIONS YOU WON!");
					break;
			}
		
			Gameboard.showBoard();			//shows all
			Gameboard.showGame();			//shows game play
		}
		
	}
	
	
}//this is the end bracket--pay attention!!

	