/* Kirstie O'Connell	Final Project	2018Dec08
 * This file is the class that will have the board related operations 
 * to handle the changes in the board during play
 */


import java.util.Random;

public class Gameboard {
	
	private static int rows;			//number of rows for board
	private static int columns;			//number of columns board
	private static int[][] playBoard;	//2d array for gameboard
	//private static int[][] ships;		//an array to place the ships into the board
	private static int columnPosition;	//x coordinate for ship on board
	private static int rowPosition;		//y coordinate for ship	on board
	private static int counter;			//what is says it is 
	private static int checkCell = 0;	//what is in cell 
	
/*	final static int C = 9;	//Aircraft Carrier - 5 cells
	final static int B = 8;	//Battleship - 4 cells
	final static int D = 7;	//Destroyer - 3 cells
	final static int S = 6;	//Submarine - 3 cells
	final static int P = 5;	//Patrol - 2 cells
	
	final static int[] shipInfo = {C, B, D, S, P};
*/	

	//constructor for the gameboard
	public Gameboard(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.playBoard = new int[rows][columns];
		
	}
	
	//Initialize board for play
	public static void initBoard() {
		
	//Initialization of the board to all water cells to start		
			for(int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) 
					playBoard[r][c]=-1;			
				}		
	}//end of initBoard
	
	//This method uses the size from the level chosen by player and creates the starting game board. 
	public static void showBoard() {
					
		//The following prints the game board to the user depending on size
		//The following 3 if statements print the column headers depending on board size
		if (columns == 6)  
			System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 ");
		if (columns == 9)
			System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 ");
		if (columns == 12)
		System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 \t11 \t12 ");
		System.out.println();
		
		//This for loop prints the letters for each row and depends on board size
		for(int r = 0; r < rows; r++) {			
			if((r+1)==1)
				System.out.print("A ");
			if((r+1)==2)
				System.out.print("B ");
			if((r+1)==3)
				System.out.print("C ");
			if((r+1)==4)
				System.out.print("D ");
			if((r+1)==5)
				System.out.print("E ");
			if((r+1)==6)
				System.out.print("F ");
			if((r+1)==7)
				System.out.print("G ");
			if((r+1)==8)
				System.out.print("H ");
			if((r+1)==9)
				System.out.print("I ");
			if((r+1)==10)
				System.out.print("J ");
			if((r+1)==11)
				System.out.print("K ");
			if((r+1)==12)
				System.out.print("L ");
			
			//This part uses the 2d array to fill in the board with the symbols to show status of the cells
			for (int c = 0; c < columns; c++) {					
				if(playBoard[r][c]== -1) {
					System.out.print("\t"+"~");	//shows open water
				//} else if(playBoard[r][c]==0) {	
					//System.out.print("\t"+"*");	//shows a miss			//hit and miss are not in the 
				//} else if(playBoard[r][c]== 1) {							//board until game started anyway
					//System.out.print("\t"+"X");	//shows a hit 
				} else if(playBoard[r][c]== 9) {
					System.out.print("\t"+"C"); //shows Aircraft Carrier 
				} else if(playBoard[r][c]== 8) {
					System.out.print("\t"+"B"); //shows Battleship 
				} else if(playBoard[r][c]== 7) {
					System.out.print("\t"+"D"); //shows Destroyer 
				} else if(playBoard[r][c]== 6) {
					System.out.print("\t"+"S"); //shows Submarine 
				} else if(playBoard[r][c]== 5) {
					System.out.print("\t"+"P"); //shows Patrol 
				}
			}
			System.out.println();
		}
		System.out.println();
	}//end of showBoard
	
	//This method shows the game board during play as it changes
	public static void showGame() {
						
		//The following prints the game board to the user depending on size
		//The following 3 if statements print the column headers depending on board size
		if (columns == 6)  
			System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 ");
		if (columns == 9)
			System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 ");
		if (columns == 12)
		System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 \t11 \t12 ");
		System.out.println();
			
		//This for loop prints the letters for each row and depends on board size
		for(int r = 0; r < rows; r++) {			
			if((r+1)==1)
				System.out.print("A ");
			if((r+1)==2)
				System.out.print("B ");
			if((r+1)==3)
				System.out.print("C ");
			if((r+1)==4)
				System.out.print("D ");
			if((r+1)==5)
				System.out.print("E ");
			if((r+1)==6)
				System.out.print("F ");
			if((r+1)==7)
				System.out.print("G ");
			if((r+1)==8)
				System.out.print("H ");
			if((r+1)==9)
				System.out.print("I ");
			if((r+1)==10)
				System.out.print("J ");
			if((r+1)==11)
				System.out.print("K ");
			if((r+1)==12)
				System.out.print("L ");
				
			//This part uses the 2d array to fill in the board with the symbols to show status of the cells
			for (int c = 0; c < columns; c++) {					
				if(playBoard[r][c]== -1) {
					System.out.print("\t"+"~");	//shows open water
				} else if(playBoard[r][c]==0) {	
					System.out.print("\t"+"*");	//shows a miss
				} else if(playBoard[r][c]== 1) {
					System.out.print("\t"+"X");	//shows a hit 
				} else if(playBoard[r][c]== 9) {
													//show the sunken ships somehow
					System.out.print("\t"+"C");	//shows Aircraft Carrier	
					                           
				} else if(playBoard[r][c]== 8) {
					System.out.print("\t"+"B"); //shows Battleship 
				} else if(playBoard[r][c]== 7) {
					System.out.print("\t"+"D"); //shows Destroyer 
				} else if(playBoard[r][c]== 6) {
					System.out.print("\t"+"S"); //shows Submarine 
				} else if(playBoard[r][c]== 5) {
					System.out.print("\t"+"P"); //shows Patrol 
				}
			}
			System.out.println();
		}
		System.out.println();
	}//end of showGame
	
	//method to place ships on the board from longest to shortest
	public static void placeShips() {
		
		placeCarrier();
		placeBattleship();
		placeDestroyer();
		placeSubmarine();
		placePatrol();
		
	} //end of placeShips

	//places Aircraft Carrier on board randomly	
	public static void placeCarrier() {
		
		Random random = new Random();
		//Carrier placement
		rowPosition = random.nextInt(rows);
		columnPosition = random.nextInt(columns);
		int x = upOrDown();	//board orientation call 
				
		//horizontal orientation chosen randomly
		if(x==0) {	
			if((columnPosition + 4) >= columns) {
				do {									//checks for out of bounds
					columnPosition = random.nextInt(columns);
				}while((columnPosition + 4) >= columns);
			}
			for(counter = 0; counter < 5; counter++) {	
				playBoard[rowPosition][columnPosition] = 9;	//assigns cell status
				columnPosition++;
				}
			}
	      
		//vertical orientation chosen randomly
		if(x==1) {
			if((rowPosition + 4) >= rows) {
				do {									//checks for out of bounds
					rowPosition = random.nextInt(rows);
				}while((rowPosition + 4) >= rows);
			}
			for(counter = 0; counter < 5; counter++) {
				playBoard[rowPosition][columnPosition] = 9; //assigns cell status
				rowPosition++;
				}
		}
	}

	//places Battleship on board randomly
	public static void placeBattleship() {
		
		Random random = new Random();
		//Battleship placement
		rowPosition = random.nextInt(rows);
		columnPosition = random.nextInt(columns);
		int x = upOrDown();	//board orientation call 
				
		//horizontal orientation chosen randomly
		if(x==0) {
			if((columnPosition + 3) >= columns) {
				do {									//checks for out of bounds
					columnPosition = random.nextInt(columns);
				}while((columnPosition + 3) >= columns);
			}
			
			for(counter = 0; counter < 4; counter++) {
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placeBattleship();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 8;	//assigns cell status
				columnPosition++;
			}			
		}
				
		//vertical orientation chosen randomly
		if(x==1) {
			
			if((rowPosition + 3) >= rows) {
				do {								//checks for out of bounds
					rowPosition = random.nextInt(rows);
				}while((rowPosition + 3) >= rows);
			}		
			
			for(counter = 0; counter < 4; counter++) { 	
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placeBattleship();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 8;	//assigns cell status
				rowPosition++;
			}		
		}
	}

	//places destroyer on board randomly
	public static void placeDestroyer() {
		
		Random random = new Random();
		//Destroyer placement
		rowPosition = random.nextInt(rows);
		columnPosition = random.nextInt(columns);
		int x = upOrDown();	//board orientation call 
				
		//horizontal orientation chosen randomly
		if(x==0) {	
			if((columnPosition + 2) >= columns) {
				do {									//checks for out of bounds
					columnPosition = random.nextInt(columns);
				}while((columnPosition + 2) >= columns);
			}
			for(counter = 0; counter < 3; counter++) {
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placeDestroyer();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 7;	//assigns cell status
				columnPosition++;
				}
		}
			
		//vertical orientation chosen randomly
		if(x==1) {
			if((rowPosition + 2) >= rows) {
				do {									//checks for out of bounds									
					rowPosition = random.nextInt(rows);
				}while((rowPosition + 2) >= rows);
			}					
			for(counter = 0; counter < 3; counter++) {
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placeDestroyer();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 7;	//assigns cell status
				rowPosition++;
			}
		}
	}

	//places Submarine on board randomly
	public static void placeSubmarine() {
		
		Random random = new Random();
		//Submarine placement
		rowPosition = random.nextInt(rows);
		columnPosition = random.nextInt(columns);
		int x = upOrDown();	//board orientation call 
				
		//horizontal orientation chosen randomly
		if(x==0) {	
			if((columnPosition + 2) >= columns) {
				do {									//checks for out of bounds
					columnPosition = random.nextInt(columns);
				}while((columnPosition + 2) >= columns);
			}
			for(counter = 0; counter < 3; counter++) {
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placeSubmarine();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 6;	//assigns cell status
				columnPosition++;
				}
		}
				
		//vertical orientation chosen randomly
		if(x==1) {
			if((rowPosition + 2) >= rows) {
				do {									//checks for out of bounds
					rowPosition = random.nextInt(rows);
				}while((rowPosition + 2) >= rows);
			}					
			for(counter = 0; counter < 3; counter++) {
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placeSubmarine();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 6;	//assigns cell status
				rowPosition++;
			}
		}
	}
	
	//places Patrol ship on board randomly
	public static void placePatrol() {
		
		Random random = new Random();
		//Patrol placement
		rowPosition = random.nextInt(rows);
		columnPosition = random.nextInt(columns);
		int x = upOrDown();	//board orientation call 
			
		//horizontal orientation chosen randomly
		if(x==0) {	
			if((columnPosition + 1) >= columns) {
				do {									//checks for out of bounds
					columnPosition = random.nextInt(columns);
				}while((columnPosition + 1) >= columns);
			}
			for(counter = 0; counter < 2; counter++) {	
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placePatrol();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 5;	//assigns cell status
				columnPosition++;
				}
		}
		
		//vertical orientation chosen randomly
		if(x==1) {
			if((rowPosition + 1) >= rows) {
				do {									//checks for out of bounds
					rowPosition = random.nextInt(rows);
				}while((rowPosition + 1) >= rows);
			}					
			for(counter = 0; counter < 2; counter++) {
				checkCell = getCellStatus(rowPosition, columnPosition+1);//checking for occupied cell
				if(checkCell != -1) {
					placePatrol();		//starts over if cell occupied
					break;
				}
				playBoard[rowPosition][columnPosition] = 5;	//assigns cell status
				rowPosition++;
			}
		}
	}

	//randomly chooses horizontal or vertical for ship placement
	public static int upOrDown() {
		
		Random updown = new Random();
		int result = updown.nextInt(2);
		return result;
	}///////end of upOrDown
	
	//gets the status of cell called by player for shot
	public static int getCellStatus(int x, int y) {
		
		int status = 0;
		status = playBoard[x][y-1];
		return status;
	}
	
 
	
}//this is the very end bracket---pay attention!!!
	








	
	
	

