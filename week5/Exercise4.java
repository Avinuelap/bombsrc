package week5;
import java.util.Scanner;
public class Exercise4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int number = (int) (Math.random()*100)+1;
		boolean found = false;
		do {
			System.out.println("Try to guess my number");
			int guess = sc.nextInt();
			if (guess==number) {
				found = true;
			}
			else {
			System.out.println("Wrong number, try again");
				if (guess>number)
				System.out.println("Too big!");
				else 
				System.out.println("Too small!");
			}
		}
		while (!found);
		System.out.println("Good! The number was "+number);
		sc.close();
	}


}


