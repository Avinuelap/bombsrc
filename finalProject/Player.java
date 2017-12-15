package finalProject;

import edu.uc3m.game.GameBoardGUI;
//AÑADIR IF COMPROBANDO SI CAMBIA DE CASILLA (MULTIPLO DE 10)
public class Player {
	private int score;
	private Bomb[] bombs = new Bomb[10];
	private Bomb bomb = new Bomb();
	private int health = 100;
	private int speed = 2;
	private int x1 = 10 , y1 = 10; 	
	
	
	int counter = 1;   							//Animation sprite counter
	String lastAction = "down"; 				//will be used in the animation loop for the player's movement. Initially down.
	int []xExp = new int [10];					//Used for explosions
	int []yExp = new int [10];					//Used for explosions
	boolean alive = true;

	public Player (GameBoardGUI board) throws Throwable {
	 	run (board);
	}
	
	//RUN method (main)
	public void run (GameBoardGUI board) throws Throwable {
		
		board.gb_setValueHealthMax(this.health);

		Block thisBoard = new Block(board);
		
		for (int i=1; i<10; i++) {
			bombs[i] = new Bomb();					//Initializing each element of the bomb array
		}
		long [] deployTime = new long [10];			//Used for bomb detonation timings
		long [] explosionTime = new long [10];		//Used for bomb detonation animations		
		boolean [] placedBomb = new boolean [10];	//Will be true if there are bombs on board
		boolean [] explosion = new boolean [10];	//Will be true if an explosion is happening
		int bombCounter = bomb.getBombCounter();	//Amount of bombs available
		for (int i=1; i<10; i++) {
		board.gb_addSprite(i, "bomb1.gif", true);	//Add bombs to the board
		}

		///////////////////// MAIN LOOP ///////////////////////
		do {
			String newMovement = board.gb_getLastAction().trim();
			switch (newMovement){
			case "right": 	board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
						board.gb_println("Going to [" + (Math.min((((x1 + 4) / 10)), MainFP.SIZE)+1)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]");
						board.gb_println(x1 + ", " + y1);
				if(x1%10==0) {
					x1+=speed;
				}else {
					if(thisBoard.getBrickArray()[(Math.min((((x1 - 4) / 10)), MainFP.SIZE)+1)][Math.min((((y1 + 9) / 10)), MainFP.SIZE)] == 0) {
						x1+=speed;
					}
				}	break;

			case "left": board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
			board.gb_println("Going to [" + (Math.min((((x1 + 5) / 10)), MainFP.SIZE)-1)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]");
			board.gb_println(x1 + ", " + y1);
				if(x1%10==0) {
					x1-=speed;
				}else	{
					if(thisBoard.getBrickArray()[(Math.min(((x1 + 13) / 10), MainFP.SIZE))-1][Math.min((((y1 + 9) / 10)), MainFP.SIZE)] == 0){
						x1-=speed;
					}
				}	break;
				
			case "down": board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
			board.gb_println("Going to [" + (Math.min((((x1 + 5) / 10)), MainFP.SIZE))+ "] [" + (Math.min((((y1 + 8) / 10)), MainFP.SIZE)+1) + "]");
			board.gb_println(x1 + ", " + y1);
				if (y1%10!=0) {
					y1+=speed;
				} else	{
					if (thisBoard.getBrickArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)][(Math.min((((y1 + 4) / 10)), MainFP.SIZE))+1] == 0) {
						y1+=speed;
					}
				}	break;

			case "up": board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
			board.gb_println("Going to [" + (Math.min((((x1 + 5) / 10)), MainFP.SIZE))+ "] [" + (Math.min((((y1 + 8) / 10)), MainFP.SIZE)-1) + "]");
			board.gb_println(x1 + ", " + y1);
				if (y1%10==0) {
					y1-=speed;
				} else	{
					if (thisBoard.getBrickArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)][(Math.min((((y1+15) / 10)), MainFP.SIZE))-1] == 0) {
						y1-=speed;
					}
				}	break;
			case "space": 
				if (bombCounter>=1) {
					bombs[bombCounter].setPosition(Math.min(((x1 + 4) / 10), MainFP.SIZE), Math.min((((y1 + 8) / 10)), MainFP.SIZE));
					board.gb_moveSprite(bombCounter, bombs[bombCounter].getXBomb(), bombs[bombCounter].getYBomb());
					board.gb_setSpriteVisible(bombCounter, true);
					deployTime [bombCounter] = System.currentTimeMillis();
					placedBomb [bombCounter] = true;
				
					board.gb_println("Bomb placed in [" + bombs[bombCounter].getXBomb() + " , " + bombs[bombCounter].getYBomb() + "]");
					bombCounter = bombCounter-1;
				}	break;

			default: break;
			}
		
			//Player animation
			board.gb_setSpriteImage(0, setMoveSprite(board, newMovement));	
			board.gb_moveSpriteCoord(0, x1, y1);
			
			//Bomb animation
			board.gb_setSpriteImage(bombCounter+1, bombs[bombCounter+1].setBombSprite());				
			
			//Bomb explosion
			if ((System.currentTimeMillis() >= deployTime[bombCounter+1]+4000) && (placedBomb[bombCounter+1] == true)) {
				bombCounter++;
				board.gb_setSpriteVisible(bombCounter, false);
				placedBomb[bombCounter] = false;
				explosionTime [bombCounter] = System.currentTimeMillis();
				explosion[bombCounter] = true;
				xExp[bombCounter] = bombs[bombCounter].getXBomb();
				yExp[bombCounter] = bombs[bombCounter].getYBomb();
				
			}
						
			bombs[bombCounter+1].setExplosion(board, xExp[bombCounter+1], yExp[bombCounter+1], explosionTime[bombCounter+1], explosion[bombCounter+1], thisBoard);	
			
			Thread.sleep(50);
		} while (alive==true);
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
}




