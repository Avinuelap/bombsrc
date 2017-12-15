package week12;
import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Player 1:");
		Player player1 = new Player();
		
		System.out.println();
		
		System.out.println("Player 2:");
		Player player2 = new Player();
		
		//Generate the 25 rounds
		int p1count = 0;
		int p2count = 0;
		String lastOpt = null; //the last winning option, to be stored in the lastOption field. Initial value is null
		for (int i=1; i<=25; i++) {
			player1.setChoice(i);
			player2.setChoice(i);
			
			//Wins
			if (player1.getChoice().toLowerCase().equals("rock") && player2.getChoice().toLowerCase().equals("scissors")) {
				p1count++;
				lastOpt="rock";
			}
			if (player2.getChoice().toLowerCase().equals("rock") && player1.getChoice().toLowerCase().equals("scissors")) {
				p2count++;
				lastOpt="rock";
			}
			if (player1.getChoice().toLowerCase().equals("paper") && player2.getChoice().toLowerCase().equals("rock")) {
				p1count++;
				lastOpt="paper";
			}
			if (player2.getChoice().toLowerCase().equals("paper") && player1.getChoice().toLowerCase().equals("rock")) {
				p2count++;
				lastOpt="paper";
			}
			if (player1.getChoice().toLowerCase().equals("scissors") && player2.getChoice().toLowerCase().equals("paper")) {
				p1count++;
				lastOpt="scissors";
			}
			if (player2.getChoice().toLowerCase().equals("scissors") && player1.getChoice().toLowerCase().equals("paper")) {
				p2count++;
				lastOpt="scissors";
			}
			
			//Draws:
			if (player1.getChoice().toLowerCase().equals("rock") && player2.getChoice().toLowerCase().equals("rock")) {
				lastOpt="rock";
			}
			if (player1.getChoice().toLowerCase().equals("scissors") && player2.getChoice().toLowerCase().equals("scissors")) {
				lastOpt="scissors";
			}
			if (player1.getChoice().toLowerCase().equals("paper") && player2.getChoice().toLowerCase().equals("paper")) {
				lastOpt="paper";
			}
			
			player1.chooseOption(lastOpt);
			player2.chooseOption(lastOpt);	
			System.out.println("ROUND " + i +": \n" + player1.getName() + ": " + player1.getChoice() +"\n" + player2.getName() + ": " + player2.getChoice());
		}
		
		if (p1count > p2count) {
			System.out.println(player1.getName() + " wins! (" + p1count +" points)");
		}
		else if (p1count < p2count) {
			System.out.println(player2.getName() + " wins! (" + p2count +" points)");
		}
		else {
			System.out.println("It is a draw! (" + p1count + " - " + p2count + ")");
		}
	}

}
