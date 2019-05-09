/*Kirstie O'Connell	Final Project	2018Dec08
 * This is where decisions of the play will be made in the game 
 */


import java.util.Scanner;

public class ActionGame {
	
	private static float hits;				//number of hits to a ship
	private static int shots;				//number of shots made
	private static int missles;				//missile number
	//private static int[][] shot = {{0,0}}; 	//takes input for shot
	private static char letter = ' ';		//stores char input for letter coordinate
	private static int xCoord = 0;			//stores number value of the letter entered for coordinates
	private static int yCoord = 0;			//stores the value of the number coordinates entered
	private static int level = 0;			//difficulty choice
	protected static int gameloop = 0;		//loop number for the game play
	private static int nbrShips = 5;		//number of ships left to sink
	private static float accuracy;			//hits/shots taken
	private static float misslesUsed;			//records missles used
	
	//player chooses level of difficulty
	public static int chooseLevel() {
		
		Scanner input = new Scanner(System.in);	//for input 
		level = input.nextInt();
		
		//this if statement checks to make sure level picked is 1, 2 or 3 only using a do...while loop
				if (level > 3 || level < 1) {
					do {
					System.out.println("Enter 1, 2 or 3!");
					level = input.nextInt();
					}while(level > 3 || level < 1);
				}
		return level;
	}

	//method to create the difficulty level of game play
	public static void difficultyChoice(int level) {
		
		//This call makes the correct game board size depending on difficulty chosen
		if (level == 1) {
			Gameboard board1 = new Gameboard(6,6);
			Gameboard.initBoard();	//initializes the gameboard to 6x6
			Gameboard.showBoard();	//call to the game level 1 board
			missles = 30;			//number of missles for level
			gameloop = 30;			//sets loop for the game play
			}
		if (level == 2) {
			Gameboard board2 = new Gameboard(9,9);
			Gameboard.initBoard();	//initializes the gameboard to 9x9
			Gameboard.showBoard();	//call to the game level 2 board
			missles = 50;			//number of missles for level
			gameloop = 50;			//sets loop for the game play
			}
		if (level == 3) {
			Gameboard board3 = new Gameboard(12,12);
			Gameboard.initBoard();	//initializes the gameboard to 12x12
			Gameboard.showBoard();	//call to the game level 3 board
			missles = 75;			//number of missles for level
			gameloop = 75; 			//sets loop for the game play
			}
	}
	
	//prints the stats to player during game
	public static void gameStats() {
		
		System.out.println("Number of Missles............. " + missles);  //selects the correct number of missles to start
		System.out.println("Number of Ships left to sink.. " + shipsLeft());	//tells user how many ships are still left to sink
		if(shots != 0) {
			accuracy = (hits/(misslesUsed));
	     System.out.printf("Accuracy...................... %.2f", accuracy);
		}
		System.out.println();
		System.out.println();
	}
	
	//record for ships left to sink
	public static int shipsLeft() {
		
		return nbrShips;
	}
	
	//gets y coordinate from player or column on board 
	public static int getYCoord() {
		
		Scanner numIn = new Scanner(System.in);
		System.out.println("Fire a missle by using grid coordinates.");
		System.out.println("Enter Number Coordinate: ");
		yCoord = numIn.nextInt();
		
		return yCoord;
	}
	
	//gets x coordinate from player or row on board
	public static int getXCoord() {
		
		Scanner letterCoord = new Scanner(System.in);
		System.out.println("Enter Letter Coordinate: ");
		letter =  letterCoord.next().charAt(0);
		xCoord = letterCoord(letter);
		return xCoord;
	}
		
	//checks if coordinates given are a hit or miss and records game status 
	public static void hitOrMiss(int status) {
		
		//the following if statements tell if hit and what ship was hit	
		if(status == 9) { 
			System.out.println("You hit the Aircraft Carrier! Congrats!");
			System.out.println();
			hits++;
			shots++;
		}else if(status == 8) {
			System.out.println("You hit the Battleship! Right on!");
			System.out.println();
			hits++;
			shots++;
		}else if(status == 7) {
			System.out.println("You hit the Destroyer! Way to go!");
			System.out.println();
			hits++;
			shots++;
		}else if(status == 6) {
			System.out.println("You hit the Submarine! Cool!");
			System.out.println();
			hits++;
			shots++;
		}else if(status == 5) { 
			System.out.println("You hit the Patrol! Nice!");
			System.out.println();
			hits++;
			shots++;
		}
		else {				//The else is what happens if missed 
			System.out.println("You missed! What a waste of a missle!");
			System.out.println();
			shots--;
		}
		missles--;
		misslesUsed++;
	}

	//Changes the letter input from player to number 
	public static int letterCoord(char letter) {
		
		if(letter == 'a' || letter == 'A')
			yCoord = 0;
		if(letter == 'b' || letter == 'B')
			yCoord = 1;
		if(letter == 'c' || letter == 'C')
			yCoord = 2;
		if(letter == 'd' || letter == 'D')
			yCoord = 3;
		if(letter == 'e' || letter == 'E')
			yCoord = 4;
		if(letter == 'f' || letter == 'F')
			yCoord = 5;
		if(letter == 'g' || letter == 'G')
			yCoord = 6;
		if(letter == 'h' || letter == 'H')
			yCoord = 7;
		if(letter == 'i' || letter == 'I')
			yCoord = 8;
		if(letter == 'j' || letter == 'J')
			yCoord = 9;
		if(letter == 'k' || letter == 'K')
			yCoord = 10;
		if(letter == 'l' || letter == 'L')
			yCoord = 11;
		
		return yCoord;
	}

}//this is the end bracket--pay attention!!
	
