package week8;

public class Dice {
	public String name;
	public byte [] rolls;
	
	public Dice (String na,  int n) {
		name=na;
		rolls = new byte [n];
		
		//Assigning values between 1 and 6
		for (int i=0; i<rolls.length; i++) {
			rolls [i] = (byte)(Math.random()*6+1);	
		}
		
		
	}

}
