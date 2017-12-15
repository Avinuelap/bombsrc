package practice;

public class P1b {

	public static void main(String[] args) {
		char [][] board = new char [10][10];
		//Generate the board:
		for (int i=0; i<10; i++) {
			for (int ii=0; ii<10; ii++) {
				board[i][ii]= 'W';
				System.out.print(board [i][ii]+ " ");
			}
			System.out.println();
		}
		
		//Generating random place for the boat
		int rowBoat = (int)(Math.random()*10);
		int colBoat = (int)(Math.random()*10);
		
		//Generating random shots
		System.out.println();
		boolean found = false;
		int attempts=0;
		do {
			int randomRow= (int)(Math.random()*10);
			int randomCol= (int)(Math.random()*10);
			if (randomRow==rowBoat && randomCol==colBoat) {
				board [randomRow][randomCol] = 'O';
				found = true;						
			}else {
				board [randomRow][randomCol] = 'X';
			}
			
			//Printing resulting board:
			for (int i=0; i<10; i++) {
				for (int ii=0; ii<10; ii++) {
					System.out.print(board [i][ii]+ " ");
				}
				System.out.println();
			}
			System.out.println();
			attempts++;

		}while (!found);

		System.out.println("Ship found! It was in row "+ rowBoat+" and column "+colBoat);
		System.out.println("Needed "+attempts+ " attempts");
	}
}
