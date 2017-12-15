package week4;

import java.util.Scanner;

public class Exercise10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a character");
		String n = sc.next();
		sc.close();

		switch (n) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			System.out.println("A number");
			break;

		default:
			System.out.println("Not a number");
		}

	}

}
