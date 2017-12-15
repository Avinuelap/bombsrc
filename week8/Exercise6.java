package week8;
import java.util.Scanner;

/**
 * Create a Dice class with fields name and rolls, to simulate a dices game. The rolls field
must be an array of byte. Create a constructor that receives the name of the player and an
integer n, which represents the number of rolls. It must assign the name to the corresponding
field and create an array of n elements randomly filled with numbers from 1 to 6. In another
program create a two-players game asking each player his/her. It must print the results for each
one and calculate the winner, which will be the one with the highest number of equal dices. In
case of tie, the one with highest total score will win.

 * @author Antonio Viñuela
 * @author Ignasio Velasco
 *
 */

public class Exercise6 {

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		///////// V A R I A B L E S /////////////
		String name1;
		String name2;
		int nRolls;
		byte equals1=0;
		byte equals2=0;
		byte sum1=0;
		byte sum2=0;
		/////////////////////////////////////////

		System.out.println("Enter name of player number 1");
		name1 = sc.nextLine();

		System.out.println("Enter name of player number 2");
		name2 = sc.nextLine();

		System.out.println("Enter number of rolls");
		nRolls = sc.nextInt();
		
		System.out.println();

		Dice player1, player2;
		player1 = new Dice(name1, nRolls);
		player2 = new Dice(name2, nRolls);

		//Printing both rolls:
		System.out.print(name1 + ": ");
		for (int i=0; i<player1.rolls.length; i++) {
			System.out.print(player1.rolls[i] + " ");
		}

		System.out.println();
		System.out.print(name2+": ");

		for (int i=0; i<player2.rolls.length; i++) {
			System.out.print(player2.rolls[i] + " ");
		}
		
		
		//Checking for equal values inside the arrays, and making the sum just in case they tie
		//Player 1:
		for (int i=0; i<player1.rolls.length; i++) {
			sum1=(byte)(sum1+player1.rolls[i]);
			for (int ii=0; ii<player1.rolls.length; ii++){
				if (ii>i) {
					if (player1.rolls[i]==player1.rolls[ii]) {
						equals1++;
					}
				}				
			}
		}
		
		//Player 2:
		for (int i=0; i<player2.rolls.length; i++) {
			sum2=(byte)(sum2+player2.rolls[i]);
			for (int ii=0; ii<player2.rolls.length; ii++){
				if (ii>i) {
					if (player2.rolls[i]==player2.rolls[ii]) {
						equals2++;
					}
				}				
			}
		}
		
		System.out.println();
		
		if (equals1>equals2) {
			System.out.println(player1.name + " wins!");
		}
		else if (equals2>equals1) {
			System.out.println(player2.name + " wins!");
		}
		else if(equals2==equals1) {
			if (sum1==sum2) {
				System.out.println("It's a tie!");
			}
			if (sum1>sum2) {
				System.out.println(player1.name + " wins!");
			}
			if (sum2>sum1) {
				System.out.println(player2.name + " wins!");
			}
		}
	}



}

		
	


