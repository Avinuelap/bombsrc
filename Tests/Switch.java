package Tests;

import java.util.Scanner;
public class Switch {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	int a=sc.nextInt();

	switch (a) {
	case 0: System.out.println("0");
	break;
	case 7: System.out.println("7"); 
	break;
	default: System.out.println("other");

	}
	
	sc.close();

	}

}
