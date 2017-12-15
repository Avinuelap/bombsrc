package week6;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of the array");
		int n = sc.nextInt();
		boolean positive = false;
		do {
			if (n<=0){
				System.out.println("Not valid. Enter length of the array");
				n = sc.nextInt();			
			}else {
				positive=true;
			}	
		}
		while (!positive);

		sc.close();
		System.out.println();

		double [] array = new double [n];
		System.out.print("Array is: ");
		for (int i=0;i<array.length;i++) {
			array[i]=Math.random()*49+1;
			System.out.print("["+array[i]+"]"+" ");
		}
		System.out.println();
		double total=0;
		for (int i=0; i<array.length; i++) {
			total = total +array[i];
		}
		System.out.println("Sum of all elements is "+ total);
	}
}

