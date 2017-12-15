package week4;

import java.util.Scanner;

public class GuidedEx {

	public static void main(String[] args) {
		
	//////////////////// V A R I A B L E S //////////////////////////
			boolean time; //true will be day, false will be night
			int soldiers;
			short machines;
			String rain;
			boolean poison; 
			boolean anyOK;
	/////////////////////////////////////////////////////////////////
			
	Scanner sc = new Scanner (System.in);
		System.out.println("Daytime? (true/false)");
		time = sc.nextBoolean();
		
		System.out.println("How many soldiers available?");
		soldiers = sc.nextInt();
		
		System.out.println("How many siege machines available?");
		machines = sc.nextShort();
		
		System.out.println("Is it raining? (yes/no)");
		rain = sc.next();
		
		System.out.println("Poison available? (true/false)");
		poison = sc.nextBoolean();
	
		System.out.println();
	if (soldiers>=500 && machines>=50 && time == false && rain.equals("no"))	{	
		System.out.println("-Go for Silent attack strategy");
		}
	if (soldiers>=10000 && time == true)	{
		System.out.println("-Go for Crossfire strategy");
	}
	if (soldiers>=1 && time==false && poison==true) {
		System.out.println("-Sneak in and kill the King!!!");
	}
	if (soldiers>=10000 && poison==false && time==false && machines>=50 && rain.equals("yes")) {
		
	}

	}
}
