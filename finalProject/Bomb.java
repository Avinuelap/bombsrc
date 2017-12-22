package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class Bomb {
	int range = 1;
	private int xBomb, yBomb;			//Bomb coordinates on the board
	private int xExp, yExp;				//Coordinates for the explosion
	private long deployTime;
	private long explosionTime;
	private boolean placedBomb;
	private boolean explosion;
	////////////////////////////////////////////////////////////
	
	int bombCounter = 1;	//Used in bomb sprite animation
	int expCounter = 1;		//Used in explosion animation
	
	public Bomb () {
//		//Setters:
//		setBombSprite();
//		setPosition(xBomb, yBomb);
//		setExpPosition(xExp, yExp);
//		//setCurrExplosion();
//		
//		//Getters
//		getXBomb();
//		getYBomb();
	}
	
	//Method for explosions:
	public void setExplosion(GameBoardGUI board, int xBomb, int yBomb, long explosionTime, boolean explosion, Block thisBoard) {	
		if ((System.currentTimeMillis() <= explosionTime+1000) && (explosion ==true)) {
			/////////////// Starting explosions //////////////////////////////////////////////////
			//Center
			
			
			
			for (int i = 1; i <= this.range; i++) {
				board.gb_setSquareImage(xBomb, yBomb, cAnimation());
				//Right
				if ((thisBoard.getBrickArray()[xBomb+1][yBomb]!=2)) { 	//Will stop if there is a wall	
					if (xBomb+i<MainFP.SIZE-1) {
						if (i!=this.range) {
							board.gb_setSquareImage(xBomb+i, yBomb, xAnimation());
						} else	{
							board.gb_setSquareImage(xBomb+i, yBomb, rAnimation());	
						}
					}
				}

				//Left
				if ((thisBoard.getBrickArray()[xBomb-1][yBomb]!=2)) { 	//Will stop if there is a wall
					if (xBomb-i>0) {
						if (i!=this.range) {
							board.gb_setSquareImage(xBomb-i, yBomb, xAnimation());
						} else	{
							board.gb_setSquareImage(xBomb-i, yBomb, lAnimation());	
						}
					}
				}
				//Up

				if ((thisBoard.getBrickArray()[xBomb][yBomb-1]!=2)) {	//Will stop if there is a wall	
					if (yBomb-i>0) {
						if (i!=this.range) {
							board.gb_setSquareImage(xBomb, yBomb-i, yAnimation());
						} else	{
							board.gb_setSquareImage(xBomb, yBomb-i, tAnimation());	
						}
					}
				}
				//Down

				if ((thisBoard.getBrickArray()[xBomb][yBomb+1]!=2)) {
					if (yBomb+i<MainFP.SIZE-1) {
						if (i!=this.range) {
							board.gb_setSquareImage(xBomb, yBomb+i, yAnimation());
						} else	{
							board.gb_setSquareImage(xBomb, yBomb+i, dAnimation());	
						}
					}
				}		
			}

		}else {		
////////////// Ending explosions /////////////////////////////////////////////////////
			//Center
			
			
			for (int i = 1; i <= this.range; i++) {
				board.gb_setSquareImage(xBomb, yBomb, null);
				//Right
				if (xBomb+i<MainFP.SIZE-1) {
					if (thisBoard.getBrickArray()[xBomb+1][yBomb]!=2) {
						board.gb_setSquareImage(xBomb+ i, yBomb, null);
						///////////// BONUS //////////////////////////////////////////////////////
						if (thisBoard.getBonusArray()[xBomb+i][yBomb]!=" ") {
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "bomb") {					
								board.gb_addSprite(500+(xBomb+i)+yBomb, "Bombupsprite.png", true);
								board.gb_moveSprite(500+(xBomb+i)+yBomb, xBomb+i, yBomb);
								board.gb_setSpriteVisible(500+(xBomb+i)+yBomb, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "fire") {								
								board.gb_addSprite(550, "Fireupsprite.png", true);
								board.gb_moveSprite(550, xBomb+i, yBomb);
								board.gb_setSpriteVisible(550, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "special fire") {								
								board.gb_addSprite(551, "Fullfiresprite.png", true);
								board.gb_moveSprite(551, xBomb+i, yBomb);
								board.gb_setSpriteVisible(551, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "remote control") {								
								board.gb_addSprite(552, "Remote_Control_2.png", true);
								board.gb_moveSprite(552, xBomb+i, yBomb);
								board.gb_setSpriteVisible(552, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "skate") {								
								board.gb_addSprite(553, "Skatesprite.png", true);
								board.gb_moveSprite(553, xBomb+i, yBomb);
								board.gb_setSpriteVisible(553, true);
							}
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "geta") {						
								board.gb_addSprite(554, "Getasprite.png", true);
								board.gb_moveSprite(554, xBomb+i, yBomb);
								board.gb_setSpriteVisible(554, true);
							}		
							
							if (thisBoard.getBonusArray()[xBomb+i][yBomb] == "door") {						
								board.gb_addSprite(555, "DoorClosed.png", false);
								board.gb_moveSprite(555, xBomb+i, yBomb);
								board.gb_setSpriteVisible(555, true);
							}	
						}
						///////////////////////////////////////////////////////////////////////////
						if (thisBoard.getBrickArray()[xBomb+i][yBomb]==1) {
							thisBoard.getBrickArray()[xBomb+i][yBomb]=0;
						}
					}
				}

				//Left
				if (xBomb-i>0) {
					if (thisBoard.getBrickArray()[xBomb-1][yBomb]!=2) {
						board.gb_setSquareImage(xBomb- i, yBomb, null);
						
						///////////// BONUS //////////////////////////////////////////////////////
						if (thisBoard.getBonusArray()[xBomb-i][yBomb]!=" ") {
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "bomb") {				
								board.gb_addSprite(500+(xBomb-i)+yBomb, "Bombupsprite.png", true);
								board.gb_moveSprite(500+(xBomb-i)+yBomb, xBomb-i, yBomb);
								board.gb_setSpriteVisible(500+(xBomb-i)+yBomb, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "fire") {							
								board.gb_addSprite(550, "Fireupsprite.png", true);
								board.gb_moveSprite(550, xBomb-i, yBomb);
								board.gb_setSpriteVisible(550, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "special fire") {						
								board.gb_addSprite(551, "Fullfiresprite.png", true);
								board.gb_moveSprite(551, xBomb-i, yBomb);
								board.gb_setSpriteVisible(551, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "remote control") {								
								board.gb_addSprite(552, "Remote_Control_2.png", true);
								board.gb_moveSprite(552, xBomb-i, yBomb);
								board.gb_setSpriteVisible(552, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "skate") {			
								board.gb_addSprite(553, "Skatesprite.png", true);
								board.gb_moveSprite(553, xBomb-i, yBomb);
								board.gb_setSpriteVisible(553, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "geta") {					
								board.gb_addSprite(554, "Getasprite.png", true);
								board.gb_moveSprite(554, xBomb-i, yBomb);
								board.gb_setSpriteVisible(554, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb-i][yBomb] == "door") {						
								board.gb_addSprite(555, "DoorClosed.png", false);
								board.gb_moveSprite(555, xBomb-i, yBomb);
								board.gb_setSpriteVisible(555, true);
							}	
						}
						//////////////////////////////////////////////////////////////////////////
						if (thisBoard.getBrickArray()[xBomb-i][yBomb]==1) {
							thisBoard.getBrickArray()[xBomb-i][yBomb]=0;

						}
					}
				}

				//Up
				if (yBomb-i>0) {
					if (thisBoard.getBrickArray()[xBomb][yBomb-1]!=2) {					
						board.gb_setSquareImage(xBomb, yBomb-i, null);
						
						///////////// BONUS //////////////////////////////////////////////////////
						if (thisBoard.getBonusArray()[xBomb][yBomb-i]!=" ") {
							if (thisBoard.getBonusArray()[xBomb][yBomb-i] == "bomb") {				
								board.gb_addSprite(500+xBomb+(yBomb-i), "Bombupsprite.png", true);
								board.gb_moveSprite(500+xBomb+(yBomb-i), xBomb, yBomb-i);
								board.gb_setSpriteVisible(500+(xBomb)+yBomb-i, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb-i] == "fire") {							
								board.gb_addSprite(550, "Fireupsprite.png", true);
								board.gb_moveSprite(550, xBomb, yBomb-i);
								board.gb_setSpriteVisible(550, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb-i] == "special fire") {						
								board.gb_addSprite(551, "Fullfiresprite.png", true);
								board.gb_moveSprite(551, xBomb, yBomb-i);
								board.gb_setSpriteVisible(551, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb-i] == "remote control") {								
								board.gb_addSprite(552, "Remote_Control_2.png", true);
								board.gb_moveSprite(552, xBomb, yBomb-i);
								board.gb_setSpriteVisible(552, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb-i] == "skate") {			
								board.gb_addSprite(553, "Skatesprite.png", true);
								board.gb_moveSprite(553, xBomb, yBomb-i);
								board.gb_setSpriteVisible(553, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb-i] == "geta") {					
								board.gb_addSprite(554, "Getasprite.png", true);
								board.gb_moveSprite(554, xBomb, yBomb-i);
								board.gb_setSpriteVisible(554, true);
							}
							
							if (thisBoard.getBonusArray()[xBomb][yBomb-1] == "door") {						
								board.gb_addSprite(555, "DoorClosed.png", false);
								board.gb_moveSprite(555, xBomb, yBomb-1);
								board.gb_setSpriteVisible(555, true);
							}	
						}
						/////////////////////////////////////////////////////////////////////
						
						if (thisBoard.getBrickArray()[xBomb][yBomb-i]==1) {
							thisBoard.getBrickArray()[xBomb][yBomb-i]=0;
						}
					}
				}	
				
				//Down
				if (yBomb+i<MainFP.SIZE-1) {
					if (thisBoard.getBrickArray()[xBomb][yBomb+1]!=2) {	
						board.gb_setSquareImage(xBomb, yBomb+i, null);
						///////// BONUS ///////////////////////////////////////////////////////////
						if (thisBoard.getBonusArray()[xBomb][yBomb+i]!=" ") {
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "bomb") {				
								board.gb_addSprite(500+xBomb+(yBomb+i), "Bombupsprite.png", true);
								board.gb_moveSprite(500+xBomb+(yBomb+i), xBomb, yBomb+i);
								board.gb_setSpriteVisible(500+(xBomb)+yBomb+i, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "fire") {							
								board.gb_addSprite(550, "Fireupsprite.png", true);
								board.gb_moveSprite(550, xBomb, yBomb+i);
								board.gb_setSpriteVisible(550, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "special fire") {						
								board.gb_addSprite(551, "Fullfiresprite.png", true);
								board.gb_moveSprite(551, xBomb, yBomb+i);
								board.gb_setSpriteVisible(551, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "remote control") {								
								board.gb_addSprite(552, "Remote_Control_2.png", true);
								board.gb_moveSprite(552, xBomb, yBomb+i);
								board.gb_setSpriteVisible(552, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "skate") {			
								board.gb_addSprite(553, "Skatesprite.png", true);
								board.gb_moveSprite(553, xBomb, yBomb+i);
								board.gb_setSpriteVisible(553, true);
							}
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "geta") {					
								board.gb_addSprite(554, "Getasprite.png", true);
								board.gb_moveSprite(554, xBomb, yBomb+i);
								board.gb_setSpriteVisible(554, true);
							}		
							
							if (thisBoard.getBonusArray()[xBomb][yBomb+i] == "door") {						
								board.gb_addSprite(555, "DoorClosed.png", false);
								board.gb_moveSprite(555, xBomb, yBomb+i);
								board.gb_setSpriteVisible(555, true);
							}	
						}
						////////////////////////////////////////////////////////////
						if (thisBoard.getBrickArray()[xBomb][yBomb+i]==1) {
							thisBoard.getBrickArray()[xBomb][yBomb+i]=0;
						}
					}
				}
			}
		}	
		explosion=false;
	}

	
	//Methods for fields:
	//1. Bomb position:
	public void setPosition(int xBomb, int yBomb) {
		this.xBomb = xBomb;
		this.yBomb = yBomb;
	}

	public int getXBomb() {
		return this.xBomb;
	}
	public int getYBomb(){
		return this.yBomb;
	}
	
	//2. Explosion position
	public void setExpPosition(int xExp, int yExp) {
		this.xExp = xExp;
		this.yExp = yExp;
	}
	
	public int getXExp() {
		return this.xExp;
	}
	public int getYExp(){
		return this.yExp;
	}
	
	//3. Timers
	public void setDeployTime(long dTime) {
		this.deployTime = dTime;
	}
	public void setExpTime(long expTime) {
		this.explosionTime = expTime;
	}
	
	public long getDeployTime() {
		return this.deployTime;
	}
	public long getExpTime(){
		return this.explosionTime;
	}
	
	//4. Booleans: deployed bomb and explosion happening:
	public void setPlacedBomb(boolean pBomb) {
		this.placedBomb = pBomb;
	}
	public void setCurrExplosion(boolean exp) {
		this.explosion = exp;
	}
	
	public boolean getPlacedBomb() {
		return this.placedBomb;
	}
	public boolean getCurrExplosion(){
		return this.explosion;
	}
	
	//5. Range
	public void setRange(int x) {
		this.range = x;
	}
	public int getRange() {
		return this.range;
	}
	
	/////////////////Methods for animations:
	//1. Bomb animation:
	public String setBombSprite() {
		if (bombCounter <2) {
			bombCounter++;
		} else {
			bombCounter = 1;
		}
		return "bomb"+bombCounter+".gif";
	}
	//2. Center explosion animation:
	public String cAnimation() {	
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_C"+expCounter+".gif";
	}
	
	//3. X axis animation:
	public String xAnimation() {
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_H"+expCounter+".gif";
	}
	
	//4. Right end explosion:
	public String rAnimation() {
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_E"+expCounter+".gif";
	}
	
	//5. Left end explosion:
	public String lAnimation() {
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_W"+expCounter+".gif";
	}
	
	//6. Y axis animation:
	public String yAnimation() {
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_V"+expCounter+".gif";
	}
	
	//7. Top end animation:
	public String tAnimation() {
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_N"+expCounter+".gif";
	}
	
	//Down end animation:
	public String dAnimation() {
		if (expCounter<4) {
			expCounter++;
		} else {
			expCounter = 2;
		}
		return "explosion_S"+expCounter+".gif";
	}
	
	
//	//Checking bonus:
//	private void checkBonus(int x, int y, Block thisBoard, GameBoardGUI board) {
//		int ID;
//		if (thisBoard.getBonusArray()[x][y] == "bomb") {
//			ID= 500+x+y;
//			board.gb_addSprite(ID, "Bombupsprite.png", true);
//			board.gb_moveSprite(ID, x, y);
//			board.gb_setSpriteVisible(ID, true);
//		}
//		if (thisBoard.getBonusArray()[x][y] == "fire") {
//			ID=  550;
//			board.gb_addSprite(ID, "Fireupsprite.png", true);
//			board.gb_moveSprite(ID, x, y);
//			board.gb_setSpriteVisible(ID, true);
//		}
//		if (thisBoard.getBonusArray()[x][y] == "special fire") {
//			ID= 551;
//			board.gb_addSprite(ID, "Fullfiresprite.png", true);
//			board.gb_moveSprite(ID, x, y);
//			board.gb_setSpriteVisible(ID, true);
//		}
//		if (thisBoard.getBonusArray()[x][y] == "remote control") {
//			ID= 552;
//			board.gb_addSprite(ID, "Remote_Control_2.png", true);
//			board.gb_moveSprite(ID, x, y);
//			board.gb_setSpriteVisible(ID, true);
//		}
//		if (thisBoard.getBonusArray()[x][y] == "skate") {
//			ID= 553;
//			board.gb_addSprite(ID, "Skatesprite.png", true);
//			board.gb_moveSprite(ID, x, y);
//			board.gb_setSpriteVisible(ID, true);
//		}
//		if (thisBoard.getBonusArray()[x][y] == "skate") {
//			ID= 554;
//			board.gb_addSprite(ID, "Getasprite.png", true);
//			board.gb_moveSprite(ID, x, y);
//			board.gb_setSpriteVisible(ID, true);
//		}
//		else {
//			System.out.println("PERO KE COÑO PASAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//		}
//	}
}

