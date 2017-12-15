package week5;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float sum= 0;
		float n=0;
		System.out.println("Enter numbers you want to sum and find mean. When done, enter a 0.");
		boolean cero=false;
		do {		
			float input= sc.nextFloat(); //this will be the numbers summed
			if (input==0) 
				cero=true;


			else 						//this will be executed until input 0 is entered
				sum=sum+input;
			n=n+1;
		}
		while (!cero); //when boolean cero is true, this will be executed and loop will finish
		System.out.println("Sum is "+sum+". Mean is " +sum/n);
		sc.close();
	}

}
