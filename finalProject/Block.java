package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class Block {
	private String type; //red, green or grey
	private Position position;
	private boolean trespassing;
	private boolean destroyed;
	private int brickArray[][] = new int [MainFP.SIZE][MainFP.SIZE];   		//Used to store existing bricks	
	private String bonusArray[][] = new String [MainFP.SIZE][MainFP.SIZE]; 	//Used to store bonus

	int IDcounter = -1;		//Used to set bonus sprites' IDs. Initially -1 so it becomes 0 after IDcounter++
	
	//No-arg constructor
	public Block () {
	}
	
	//Arg constructor
	public Block (GameBoardGUI board) {
		setBoard(board);
	}
	
	public void setBoard (GameBoardGUI board) {
		//brickArray will be filled with 2 for grey walls and 1 for red bricks
		//Resetting brickArray:
		for (int i=0; i< MainFP.SIZE; i++) {
			for (int ii=0; ii<MainFP.SIZE; ii++) {
				brickArray[i][ii] = 0;
				board.gb_setSquareImage(i, ii, null);
				} 
			}
		
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
		//1. Bombs (4 per level)
		int bombs = 0;
		while (bombs < 4) {
			int i = (int) (Math.random()*MainFP.SIZE);
			int ii = (int) (Math.random()*MainFP.SIZE);
			if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
				bonusArray[i][ii] = "bomb";
				//				board.gb_addSprite(500+i+ii, "Bombupsprite.png", true);	
				//				board.gb_moveSprite(500+i+ii, i, ii);
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
				//				board.gb_addSprite(550, "Fireupsprite.png", true);
				//				board.gb_moveSprite(550, i, ii);
				fire++;
			}
		}

		//3. Special fire (1 every 5 levels)		
		if (MainFP.level == MainFP.fireLevel || MainFP.level - 5 == MainFP.fireLevel || MainFP.level - 10 == MainFP.fireLevel || MainFP.level - 15 == MainFP.fireLevel) { //TODO tiene que haber forma mejor
			int specialFire = 0;
			while (specialFire < 1) {
				int i = (int) (Math.random()*MainFP.SIZE);
				int ii = (int) (Math.random()*MainFP.SIZE);
				if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
					bonusArray[i][ii] = "special fire";
					//					board.gb_addSprite(551, "Fullfiresprite.png", true);
					//					board.gb_moveSprite(551, i, ii);
					specialFire++;

				}
			}		
		}
		//4. Remote control (1 every 10 levels)
		if (MainFP.level == MainFP.remoteControlLevel || MainFP.level - 10 == MainFP.remoteControlLevel) {	
			int remoteControl = 0;
			while (remoteControl < 1) {
				int i = (int) (Math.random()*MainFP.SIZE);
				int ii = (int) (Math.random()*MainFP.SIZE);
				if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
					bonusArray[i][ii] = "remote control";
					//					board.gb_addSprite(552, "Remote_Control_2.png", true);
					//					board.gb_moveSprite(552, i, ii);
					remoteControl++;
				}
			}		
		}
		//5. Roller skate (50% chance in even levels)
		if (MainFP.level % 2 != 0) {					
			int prob = (int) (Math.random()*2);
			if (prob == 1) {
				int skate = 0;
				while (skate < 1) {
					int i = (int) (Math.random()*MainFP.SIZE);
					int ii = (int) (Math.random()*MainFP.SIZE);
					if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
						bonusArray[i][ii] = "skate";
						//						board.gb_addSprite(553, "Skatesprite.png", true);
						//						board.gb_moveSprite(553, i, ii);
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
					//					board.gb_addSprite(554, "Getasprite.png", true);
					//					board.gb_moveSprite(554, i, ii);
					geta++;
				}
			}
		}
			//7. Door (not really a bonus)
			int door = 0;
			while (door < 1) {
				int i = (int) (Math.random()*MainFP.SIZE);
				int ii = (int) (Math.random()*MainFP.SIZE);
				if (brickArray[i][ii] == 1 && bonusArray[i][ii].equals(" ")) {
					bonusArray[i][ii] = "door";
					door++;				
				}
			}
		
		System.out.println("Level " + MainFP.level);
		for (int i=0; i<17; i++) {
			for (int ii=0; ii<17; ii++) {
				System.out.print("[" + getBonusArray()[ii][i] + "] ");
			}System.out.println();
		} System.out.println("Special fire first level: " + MainFP.fireLevel);
		System.out.println("Remote control first level: " + MainFP.remoteControlLevel);
	}


	public int[][] getBrickArray () {
		return this.brickArray;
	}

	public String[][] getBonusArray() {
		return this.bonusArray;
	}
}

