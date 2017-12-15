package finalProject;

import edu.uc3m.game.GameBoardGUI;

public class Bomb {
	//private byte amount;
	private byte range = 1;
	private int x2, y2;			//Bomb coordinates on the board
	private byte number = 2;
	
	int bombCounter = 1;	//Used in bomb sprite animation
	int expCounter = 1;		//Used in explosion animation
	
	public Bomb () {
		getBombCounter();
		setBombSprite();
		setPosition(x2, y2);
		getXBomb();
		getYBomb();
	}
	
	
	public byte getBombCounter() {
		return this.number;
	}
	


	//Method for explosions:
	public void setExplosion(GameBoardGUI board, int x2, int y2, long explosionTime, boolean explosion, Block thisBoard) {	
		if ((System.currentTimeMillis() <= explosionTime+1000) && (explosion ==true)) {
/////////////// Starting explosions //////////////////////////////////////////////////
			//Center
			board.gb_setSquareImage(x2, y2, cAnimation());

			//Right
			for (int i = 1; i <= this.range; i++) {
				if (thisBoard.getBrickArray()[x2+i][y2]==2) {
					break;		//Will stop if there is a wall
				}
				else if (i!=this.range) {
					board.gb_setSquareImage(x2+i, y2, xAnimation());
				} else	{
					board.gb_setSquareImage(x2+i, y2, rAnimation());	
				}

			}
			//Left
			for (int i = 1; i <= this.range; i++) {
				if (thisBoard.getBrickArray()[x2-i][y2]==2) {
					break;		//Will stop if there is a wall
				}
				if (i!=this.range) {
					board.gb_setSquareImage(x2-i, y2, xAnimation());
				} else	{
					board.gb_setSquareImage(x2-i, y2, lAnimation());	
				}

			}

			//Up
			for (int i = 1; i <= this.range; i++) {
				if (thisBoard.getBrickArray()[x2][y2-i]==2) {
					break;		//Will stop if there is a wall
				}
				if (i!=this.range) {
					board.gb_setSquareImage(x2, y2-i, yAnimation());
				} else	{
					board.gb_setSquareImage(x2, y2-i, tAnimation());	
				}
			}

			//Down
			for (int i = 1; i <= this.range; i++) {
				if (thisBoard.getBrickArray()[x2][y2+i]==2) {
					break;		//Will stop if there is a wall
				}
				if (i!=this.range) {
					board.gb_setSquareImage(x2, y2+i, yAnimation());
				} else	{
					board.gb_setSquareImage(x2, y2+i, dAnimation());	
				}
			}

		}else {		
////////////// Ending explosions /////////////////////////////////////////////////////
			//Center
			board.gb_setSquareImage(x2, y2, null);

			//Right
			for (int i = 1; i <= this.range; i++) {
				if (thisBoard.getBrickArray()[x2+i][y2]==2) {
					break;
				}

				board.gb_setSquareImage(x2+ i, y2, null);
				if (thisBoard.getBrickArray()[x2+i][y2]==1) {
					thisBoard.getBrickArray()[x2+i][y2]=0;
				}
			}
			//Left
			for (int i = 1; i <= this.range; i++) {
				if (x2-i >0) {
					if (thisBoard.getBrickArray()[x2-i][y2]==2) {
						break;
					}		
					board.gb_setSquareImage(x2- i, y2, null);
					if (thisBoard.getBrickArray()[x2-i][y2]==1) {
						thisBoard.getBrickArray()[x2-i][y2]=0;
					}
				}
			}
			
			//Up
			for (int i = 1; i <= this.range; i++) {
				if (y2-i >0) {
					if (thisBoard.getBrickArray()[x2][y2-i]==2) {
						break;
					}		
					board.gb_setSquareImage(x2, y2-i, null);
					if (thisBoard.getBrickArray()[x2][y2-i]==1) {
						thisBoard.getBrickArray()[x2][y2-i]=0;
					}
				}
			}
			
			//Down
			for (int i = 1; i <= this.range; i++) {
				if (y2+i >0) {
					if (thisBoard.getBrickArray()[x2][y2+i]==2) {
						break;
					}		
					board.gb_setSquareImage(x2, y2+i, null);
					if (thisBoard.getBrickArray()[x2][y2+i]==1) {
						thisBoard.getBrickArray()[x2][y2+i]=0;
					}
				}
			}
			
			explosion=false;
		}
	}
	
	//Method storing bomb position:
	public void setPosition(int x2, int y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	//Receiving position:
	public int getXBomb() {
		return this.x2;
	}
	public int getYBomb(){
		return this.y2;
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
}

