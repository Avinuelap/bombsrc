package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class Block {
	private String type; //red, green or grey
	private Position position;
	private boolean trespassing;
	private boolean destroyed;
	private int brickArray[][] = new int [MainFP.SIZE][MainFP.SIZE];   		//Used to store existing bricks	
	private String bonusArray[][] = new String [MainFP.SIZE][MainFP.SIZE]; 	//Used to store bonus

	final int fireLevel = (int)(Math.random()*5)+1;							//Used for the Special Fire bonus
	final int remoteControlLevel = (int)(Math.random()*10)+1;	
	//No-arg constructor
	public Block () {
	}
	
	//Arg constructor
	public Block (GameBoardGUI board) {
		setBoard(board);
	}
	
	public void setBoard (GameBoardGUI board) {
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
			if (!(i==0 || i==(MainFP.SIZE-1) || ii==0 || ii==(MainFP.SIZE-1) || (ii%2==0 & i%2==0) || (this.brickArray[i][ii]!=0) || (i==1 && ii==1) || (i==2 && ii==1) || (i==1 && ii==2))) {
//"If" checking that there is not a grey wall and there isn't already a red brick. Also, a red brick will never appear on the first cell
				board.gb_setSquareImage(i, ii, "bricks.gif");
				this.brickArray[i][ii]=1;
				brick++;			
			}
		}
		
		///////////////Bonus:
		//Resetting bonusArray
		for (int i=0; i< MainFP.SIZE; i++) {
			for (int ii=0; ii<MainFP.SIZE; ii++) {
				bonusArray[i][ii] = " ";
				}
			}
		//1. Bombs (3 per level)
		int bombs = 0;
		while (bombs < 3) {
			int i = (int) (Math.random()*MainFP.SIZE);
			int ii = (int) (Math.random()*MainFP.SIZE);
			if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
				bonusArray[i][ii] = "bomb";
				bombs++;
			}
		}
		//2. Fire (1 per level)
		int fire = 0;
		while (fire < 1) {
			int i = (int) (Math.random()*MainFP.SIZE);
			int ii = (int) (Math.random()*MainFP.SIZE);
			if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
				bonusArray[i][ii] = "fire";
				fire++;
			}
		}
		
		//3. Special fire (1 every 5 levels)		
		if (MainFP.level % fireLevel == 0) {
			int specialFire = 0;
			while (specialFire < 1) {
				int i = (int) (Math.random()*MainFP.SIZE);
				int ii = (int) (Math.random()*MainFP.SIZE);
				if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
					bonusArray[i][ii] = "special fire";
					specialFire++;
				}
			}		
		}
		//4. Remote control (1 every 10 levels)
		if (MainFP.level % remoteControlLevel == 0) {	//TODO no cumple
			int remoteControl = 0;
			while (remoteControl < 1) {
				int i = (int) (Math.random()*MainFP.SIZE);
				int ii = (int) (Math.random()*MainFP.SIZE);
				if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
					bonusArray[i][ii] = "remote control";
					remoteControl++;
				}
			}		
		}
		//5. Roller skate (50% chance in even levels)
		if (MainFP.level % 2 != 0) {					//TODO no cumple
			int prob = (int) (Math.random()*2);
			if (prob == 1) {
				int skate = 0;
				while (skate < 1) {
					int i = (int) (Math.random()*MainFP.SIZE);
					int ii = (int) (Math.random()*MainFP.SIZE);
					if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
						bonusArray[i][ii] = "skate";
						skate++;
					}
				}
			}
		}

		//6. Geta (20% chance per level)
		int prob = (int) (Math.random()*4);
		if (prob == 1) {
			int geta = 0;
			while (geta < 1) {
				int i = (int) (Math.random()*MainFP.SIZE);
				int ii = (int) (Math.random()*MainFP.SIZE);
				if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
					bonusArray[i][ii] = "geta";
					geta++;
				}
			}
		}
	}


	public int[][] getBrickArray () {
			return this.brickArray;
		}
	
	public String[][] getBonusArray() {
		return this.bonusArray;
	}
}

