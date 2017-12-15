package week11;
import java.util.Scanner;

/**
 * @author Antonio Viñuela
 * @author Ignacio Velasco
 */

public class Exercise1 {
	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	//Array of 3 Person:
	Person persons [] = new Person [3];
	
	//First person:
	String n = "Bartolo";
	int a = 19;
	char c = 'M';
	double h = 1.90;
	double w = 70;
	int dni = 54109353;
	
	persons[0] = new Person (a, n, c, dni, h ,w);
	System.out.println("First person: \n" + persons[0].toString());
	
	//Second person:
	System.out.println();
	System.out.println("Second person:");
	persons[1] = new Person();
	System.out.println("Second person: \n" + persons[1].toString());
	
	//Third person:
	System.out.println();
	System.out.println("Third person:");
	System.out.println("Enter name");
	n = sc.next();
	System.out.println("Enter age");
	a = sc.nextInt();
	System.out.println("Enter DNI number. Letter will be calculated automatically");
	dni = sc.nextInt();
	w = 90;
	h = 1.85;
	c = 'F';
	persons[2] = new Person (a, n, c, dni, h, w);
	System.out.println("Second person: \n" + persons[2].toString());
	
		sc.close();
	}
}
