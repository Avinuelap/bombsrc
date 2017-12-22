package finalProject;

import edu.uc3m.game.GameBoardGUI;
//AÑADIR IF COMPROBANDO SI CAMBIA DE CASILLA (MULTIPLO DE 10)
public class Player {
	private int score;
	private Bomb[] bombs = new Bomb[100];
	private int health = 100;
	private int maxHealth = 100;
	private int speed = 1;
	private int x1 = 10 , y1 = 10; 	
	private int maxBombs = 100;						//Max bombs
	private int currBombs = 0; 						//Number of bombs on board
	private boolean remoteControl = true; 			//Will be true if a remote control has been taken
	private Enemy[] enemies;
	//TODO añadir enemies
	
	int counter = 1;   								//Animation sprite counter
	String lastAction = "down"; 					//Will be used in the animation loop for the player's movement. Initially down.
	boolean alive = true;
	boolean doorOpen = false;
	int bombRange = 1;								//Used to change bomb's range when bonus is taken
	public Player (GameBoardGUI board) throws Throwable {
		run (board);
	}

	//RUN method (main)
	public void run (GameBoardGUI board) throws Throwable {

		board.gb_setValueHealthMax(this.health);
		board.gb_setValueLevel(MainFP.level);
		board.gb_setTextAbility1("Speed");
		board.gb_setTextAbility2("Range:");
		board.gb_setTextPointsUp("Score:");
		board.gb_setTextPointsDown("Bombs:");
				
		Block thisBoard = new Block(board);
		
		//Set number of enemies		
		int maxEnemyNumber = (int)(Math.random()*10)+1;			//Between 0 and 11
		int enemyNumber = 0;									//Current number
			for (int i=0; i<maxEnemyNumber; i++) {
				enemies[i] = new Enemy();	
				enemies[i].setEnemies(board, thisBoard);
		}

		for (int i=0; i<100; i++) {
			bombs[i] = new Bomb();						//Initializing each element of the bomb array
		}

		int bombCounter = 1;							//Amount of bombs available
		for (int i=1; i<100; i++) {
			board.gb_addSprite(i, "bomb1.gif", false);	//Add bombs to the board
		}
		
		
		///////////////////// MAIN LOOP ///////////////////////
		do {
			board.gb_setValueAbility1(this.speed);
			board.gb_setValueAbility2(bombRange);
			board.gb_setValueHealthCurrent(this.health);
			board.gb_setValuePointsUp(this.score);
			board.gb_setValuePointsDown(this.maxBombs - this.currBombs);
			
			String newMovement = board.gb_getLastAction().trim();
			switch (newMovement){
			case "right": 	
				if(x1%10==0) {
					x1+=speed;
				}else {
					if(thisBoard.getBrickArray()[(Math.min((((x1 - 4) / 10)), MainFP.SIZE)+1)][Math.min((((y1 + 9) / 10)), MainFP.SIZE)] == 0) {
						x1+=speed;
					}
				}	break;

			case "left": 
				if(x1%10==0) {
					x1-=speed;
				}else	{
					if(thisBoard.getBrickArray()[(Math.min(((x1 + 13) / 10), MainFP.SIZE))-1][Math.min((((y1 + 9) / 10)), MainFP.SIZE)] == 0){
						x1-=speed;
					}
				}	break;

			case "down": 
				if (y1%10!=0) {
					y1+=speed;
				} else	{
					if (thisBoard.getBrickArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)][(Math.min((((y1 + 6) / 10)), MainFP.SIZE))+1] == 0) {
						y1+=speed;
					}
				}	break;

			case "up":
				if (y1%10==0) {
					y1-=speed;
				} else	{
					if (thisBoard.getBrickArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)][(Math.min((((y1+15) / 10)), MainFP.SIZE))-1] == 0) {
						y1-=speed;
					}
				}	break;
				
			case "space": 
				if (currBombs<maxBombs) {
					bombs[bombCounter].setPosition(Math.min(((x1 + 4) / 10), MainFP.SIZE), Math.min((((y1 + 8) / 10)), MainFP.SIZE));
					board.gb_moveSprite(bombCounter, bombs[bombCounter].getXBomb(), bombs[bombCounter].getYBomb());
					board.gb_setSpriteVisible(bombCounter, true);
					bombs[bombCounter].setDeployTime(System.currentTimeMillis()); 
					bombs[bombCounter].setPlacedBomb(true);
					board.gb_println("Bomb placed in [" + bombs[bombCounter].getXBomb() + " , " + bombs[bombCounter].getYBomb() + "]");
					bombCounter++;
					currBombs++;
				}	break;

			default: break;
			}

			//Player animation
			board.gb_setSpriteImage(0, setMoveSprite(board, newMovement));	
			board.gb_moveSpriteCoord(0, x1, y1);

			//Bomb animation
			for (int i=1; i<50; i++) {
				board.gb_setSpriteImage(i, bombs[i].setBombSprite());		
			}		

			//Bomb explosion
			for (int i=0 ; i < 100 ; i++) {
				if ((System.currentTimeMillis() >= bombs[i].getDeployTime() + 4000) && (bombs[i].getPlacedBomb() == true)) {			
					board.gb_setSpriteVisible(i, false);
					bombs[i].setPlacedBomb(false);
					bombs[i].setExpTime(System.currentTimeMillis());
					bombs[i].setCurrExplosion(true);
					bombs[i].setExpPosition(bombs[i].getXBomb(), bombs[i].getYBomb());
					bombCounter--;
					currBombs--;
				}
			}
			for (int i=0; i<100; i++){	
				bombs[i].setExplosion(board, bombs[i].getXExp(), bombs[i].getYExp(), bombs[i].getExpTime(), bombs[i].getCurrExplosion(), thisBoard);
			}
			
			//Bonus effects:
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("bomb")) {
				this.maxBombs++;
				thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)] = " ";
				board.gb_setSpriteVisible(500+(Math.min(((x1 + 4) / 10), MainFP.SIZE)+Math.min((((y1 + 8) / 10)), MainFP.SIZE)), false);
				board.gb_println("Max bombs increased in 1");
				
			}
			
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("fire")) {
				bombRange++;
				for (int i=0; i<100; i++) {				
					bombs[i].setRange(bombRange);
				}
				thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)] = " ";
				board.gb_setSpriteVisible(550, false);
				board.gb_println("Bomb range increased in 1");
			}
			
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("special fire")) {
				bombRange=5;
				for (int i=0; i<100; i++) {
					bombs[i].setRange(bombRange);
				}
				thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)] = " ";
				board.gb_setSpriteVisible(551, false);
				board.gb_println("Bomb range set to maximum");
			}
			
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("remote control")) {
				this.remoteControl = true;
				thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)] = " ";
				board.gb_setSpriteVisible(552, false);
				board.gb_println("Remote control obtained. Press TAB to make all bombs explode simustaneously");
			}
			
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("skate")) {
				this.speed=speed+1;
				thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)] = " ";
				board.gb_setSpriteVisible(553, false);
				board.gb_println("Speed increased in 1");
			}
			
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("geta")) {
				this.speed=1;
				thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)] = " ";
				board.gb_setSpriteVisible(554, false);
				board.gb_println("Speed decreased to minimum");
			}
			
			if (thisBoard.getBonusArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)] [Math.min((((y1 + 8) / 10)), MainFP.SIZE)].equals("door")) {
				checkDoor(thisBoard);
				if (doorOpen==false) {
					board.gb_println("Door closed: enemies alive!");
				}
			}
			
			Thread.sleep(50);
		} while (doorOpen == false);
		///////////////// END OF MAIN LOOP ////////////////////////////////////
	}


	//Method setting the walking animations
	private String setMoveSprite(GameBoardGUI board, String newMovement) { 
		if (counter <5) {
			counter++;
		} else {
			counter = 1;
		}
		switch (newMovement) {
		case "right": lastAction = "right"; return "bomberman13"+counter+".png"; 
		case "left": lastAction = "left"; return "bomberman12"+counter+".png";
		case "up": lastAction = "up"; return "bomberman10"+counter+".png";
		case "down": lastAction = "down"; return "bomberman11"+counter+".png";
		default: switch (lastAction) {
		case "right": return "bomberman131.png";
		case "left": return "bomberman121.png";
		case "up": return "bomberman101.png";
		default: return "bomberman111.png";		//default is "down"
		}
		}
	}
	
	private void checkDoor(Block thisBoard) {
		doorOpen = true; 
		for (int i=0; i<MainFP.SIZE; i++) {
			for (int ii=0; ii<MainFP.SIZE; ii++) {
				if ((thisBoard.getBrickArray()[i][ii] == 0 || thisBoard.getBrickArray()[i][ii] == 2) && doorOpen == true) {
					doorOpen = true;
				}
				else {
					doorOpen = false;
				}
			}
		}
	}
}




