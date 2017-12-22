package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class Enemy {
	private String type;
	private boolean alive;
	private int xEnemy;
	private int yEnemy;
	private int [][] enemyArray = new int [MainFP.SIZE][MainFP.SIZE];		//0 for empty, 1 for balloon
	
//	for (int i=0; i<MainFP.SIZE; i++) {
//		for (int ii=0; ii<MainFP.SIZE; ii++) {
//			
//		}
//	}

		public Enemy () {	
		}

	public void setEnemies(GameBoardGUI board, Block thisBoard ) {
		//Non-moving balloons
		int counter = 0;
		while (counter<=1) {
			int i = (int)(Math.random()*MainFP.SIZE-1)+1;
			int ii = (int)(Math.random()*MainFP.SIZE-1)+1;
			if ((thisBoard.getBrickArray()[i][ii] == 0 && i != 1 && ii != 1) && enemyArray[i][ii] == 0 ) {
				xEnemy = i;
				yEnemy = ii;
				board.gb_addSprite(2000+i+ii, "enemy122.png", false);
				board.gb_moveSprite(2000+i+ii, Math.min(((xEnemy + 4) / 10), MainFP.SIZE), Math.min(((yEnemy + 8) / 10), MainFP.SIZE));
				board.gb_setSpriteVisible(2000+i+ii, true);
				enemyArray[i][ii] = 1;
				counter++;
			}
		}
	}

	public int[][] getEnemyArray() {
		return this.enemyArray;
	}
}	

