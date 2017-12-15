package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class MainFP {	
	public static final int SIZE = 17;
	public static int level = 1;
	public static void main(String[] args) throws Throwable {

		GameBoardGUI board = new GameBoardGUI (SIZE, SIZE);
		board.setVisible(true);
		
		//int[][] boardArray = new int [SIZE][SIZE];
		board.gb_addSprite(0, "bomberman111.png", true);
		board.gb_setSpriteVisible(0, true);

		do {
		Player player = new Player (board);
		level++;

		} while (level<20);
		System.out.println("You won!");
		
	}

}
