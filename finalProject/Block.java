package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class Block {
	private String type; //red, green or grey
	private Position position;
	private boolean trespassing;
	private boolean destroyed;
	private int brickArray[][] = new int [MainFP.SIZE][MainFP.SIZE];    //Used to store existing bricks	
	
	//No-arg constructor
	public Block () {
	}
	
	//Arg constructor
	public Block (GameBoardGUI board) {
		setWalls(board);
	}
	
	public void setWalls (GameBoardGUI board) {
		//brickArray will be filled with 2 for grey walls and 1 for red bricks
		//Grey walls:
		for (int i=0; i< MainFP.SIZE; i++) {
			for (int ii=0; ii<MainFP.SIZE; ii++) {
				if (i==0 || i==(MainFP.SIZE-1) || ii==0 || ii==(MainFP.SIZE-1) || (ii%2==0 & i%2==0) ) {
					brickArray[i][ii] = 2;
					board.gb_setSquareImage(i, ii, "wall.gif");	
				}
			}
		}
		
		//Red bricks:
		int brick = 0;
		while (brick < 50) {
			int i = (int) (Math.random()*MainFP.SIZE);
			int ii = (int) (Math.random()*MainFP.SIZE);
			if (!(i==0 || i==(MainFP.SIZE-1) || ii==0 || ii==(MainFP.SIZE-1) || (ii%2==0 & i%2==0) || (this.brickArray[i][ii]!=0) || (i==1 && ii==1) || (i==2 && ii==1))) {
//"If" checking that there is not a grey wall and there isn't already a red brick. Also, a red brick will never appear on the first cell
				board.gb_setSquareImage(i, ii, "bricks.gif");
				this.brickArray[i][ii]=1;
				brick++;
				
			}
		}
	}

	public int[][] getBrickArray () {
			return this.brickArray;
		}
}

