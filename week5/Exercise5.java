package week5;
import java.util.Scanner;
public class Exercise5 {
	public static void main(String[] args) {

		//Introduce the variables
		int Limit;
		int Divider;
		int a = 0;
		int b;

		Scanner sc = new Scanner (System.in);
		//We start by defining the limit , the value where it will stop
		System.out.println("Introduce the limit please");
		Limit = sc.nextInt();

		//Loop
		for (b = 1; b < Limit;b++) {// b is 1 and has always to be below the limit , it will increase b
			//by 1 each time
			for (Divider = 1; Divider <= b/2;Divider++) {//all dividers must be half of the value of the value
				//of b , as they are no more dividers
				if(b % Divider == 0) {//if the remainder is 0 , it means its a factor of that number and we need to
					a = a + Divider;      //store it
				}
			}
			if (a != b) {// if a is different than b , this means that its not a perfect number , so we need to
				// start over with a = 0
				a = 0;
			}
			else {
				System.out.println("The number "+a+" is perfect");
				a=0;//finally , if a = b , this means its a perfect number and therefore , we print it and
				//start again
			}
		}	
		sc.close();
	}
}	