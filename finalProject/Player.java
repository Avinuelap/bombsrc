package finalProject;

import org.omg.Messaging.SyncScopeHelper;

import edu.uc3m.game.GameBoardGUI;
//AÑADIR IF COMPROBANDO SI CAMBIA DE CASILLA (MULTIPLO DE 10)
public class Player {
	private int score;
	private Bomb[] bombs = new Bomb[100];
	private int health = 100;
	private int speed = 2;
	private int x1 = 10 , y1 = 10; 	
	private int maxBombs = 89;					//Max bombs
	private int currBombs = 0; 					//Number of bombs on board

	int counter = 1;   							//Animation sprite counter
	String lastAction = "down"; 				//will be used in the animation loop for the player's movement. Initially down.
	boolean alive = true;

	public Player (GameBoardGUI board) throws Throwable {
		run (board);
	}

	//RUN method (main)
	public void run (GameBoardGUI board) throws Throwable {

		board.gb_setValueHealthMax(this.health);

		Block thisBoard = new Block(board);

		for (int i=0; i<100; i++) {
			bombs[i] = new Bomb();					//Initializing each element of the bomb array
		}
		
		for (int i=0; i<17; i++) {
			for (int ii=0; ii<17; ii++) {
			System.out.print("[" + thisBoard.getBonusArray()[i][ii] + "] ");
			}System.out.println();;}

		int bombCounter = 1;						//Amount of bombs available
		for (int i=1; i<100; i++) {
			board.gb_addSprite(i, "bomb1.gif", true);	//Add bombs to the board
		}

		///////////////////// MAIN LOOP ///////////////////////
		do {
			String newMovement = board.gb_getLastAction().trim();
			switch (newMovement){
			case "right": 	
				//				board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
				//						board.gb_println("Going to [" + (Math.min((((x1 + 4) / 10)), MainFP.SIZE)+1)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]");
				//						board.gb_println(x1 + ", " + y1);
				if(x1%10==0) {
					x1+=speed;
				}else {
					if(thisBoard.getBrickArray()[(Math.min((((x1 - 4) / 10)), MainFP.SIZE)+1)][Math.min((((y1 + 9) / 10)), MainFP.SIZE)] == 0) {
						x1+=speed;
					}
				}	break;

			case "left": 
				//				board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
				//			board.gb_println("Going to [" + (Math.min((((x1 + 5) / 10)), MainFP.SIZE)-1)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]");
				//			board.gb_println(x1 + ", " + y1);
				if(x1%10==0) {
					x1-=speed;
				}else	{
					if(thisBoard.getBrickArray()[(Math.min(((x1 + 13) / 10), MainFP.SIZE))-1][Math.min((((y1 + 9) / 10)), MainFP.SIZE)] == 0){
						x1-=speed;
					}
				}	break;

			case "down": 
				//				board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
				//			board.gb_println("Going to [" + (Math.min((((x1 + 5) / 10)), MainFP.SIZE))+ "] [" + (Math.min((((y1 + 8) / 10)), MainFP.SIZE)+1) + "]");
				//			board.gb_println(x1 + ", " + y1);
				if (y1%10!=0) {
					y1+=speed;
				} else	{
					if (thisBoard.getBrickArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)][(Math.min((((y1 + 4) / 10)), MainFP.SIZE))+1] == 0) {
						y1+=speed;
					}
				}	break;

			case "up":
				//				board.gb_println("Cell: [" + Math.min((((x1 + 4) / 10)), MainFP.SIZE)+ "] [" + Math.min((((y1 + 8) / 10)), MainFP.SIZE) + "]") ;
				//			board.gb_println("Going to [" + (Math.min((((x1 + 5) / 10)), MainFP.SIZE))+ "] [" + (Math.min((((y1 + 8) / 10)), MainFP.SIZE)-1) + "]");
				//			board.gb_println(x1 + ", " + y1);
				if (y1%10==0) {
					y1-=speed;
				} else	{
					if (thisBoard.getBrickArray()[Math.min(((x1 + 4) / 10), MainFP.SIZE)][(Math.min((((y1+15) / 10)), MainFP.SIZE))-1] == 0) {
						y1-=speed;
					}
				}	break;
			case "space": 
				if (currBombs<=maxBombs) {
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
			for (int i=0 ; i < 10 ; i++) {
				if ((System.currentTimeMillis() >= bombs[i].getDeployTime() + 4000) && (bombs[i].getPlacedBomb() == true)) {
					bombCounter--;
					currBombs--;
					//				for (int i=0; i<10; i++) {
					//					board.gb_println(explosionTime[i] + "  ");
					//				}
					board.gb_setSpriteVisible(i, false);
					bombs[i].setPlacedBomb(false);
					bombs[i].setExpTime(System.currentTimeMillis());
					bombs[i].setCurrExplosion(true);
					bombs[i].setExpPosition(bombs[i].getXBomb(), bombs[i].getYBomb());
					board.gb_println(bombs[i].getDeployTime() + "  ");
				}
			}
			for (int i=1; i<10; i++){	
				bombs[i].setExplosion(board, bombs[i].getXExp(), bombs[i].getYExp(), bombs[i].getExpTime(), bombs[i].getCurrExplosion(), thisBoard);
			}


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




