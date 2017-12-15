package week6;

import java.util.Scanner;
public class Exercise8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		////////////// V A R I A B L E S /////////////////
		int tries=0; //number of attempts
		boolean yesOrNo=false; //control variable of the do-while loop
		int n; //number to be asked
		//////////////////////////////////////////////////
		
		System.out.println("Think of a number between 1 and 100. I will try to guess it.");
		System.out.println("If number is correct, please enter \"true\". If not, enter \"false\"");

		int [] array = new int [100];
		
		do {
			n= (int) (Math.random()*100+1);
				if (array[n]==0) {
					array[n]=n;
					System.out.println("Is "+n+" your number?");
					yesOrNo=sc.nextBoolean();
					tries=tries+1;						
				}else {					
				}
				if(tries==100) {
					System.out.println("You are lying. I have already tried all numbers between 1 and 100");
					yesOrNo=true;
				}
		}
		while(!yesOrNo);

		if (tries!=100) {
			System.out.println("Found it! Needed "+tries+" attempts.");
		}
		sc.close();
	}

}
