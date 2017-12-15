package week10;
import java.util.Scanner;
/**
 * Create an student class as in the previous exercise (call it Student2), it will have the same
private fields as before, but instead of having one field for each mark, all of them will be stored
into a single field (an array). This class must provide the same get, set and constructor as the
previous exercise's one: i.e. the constructor must receive a parameter for each of the marks, as
the previous one, even if internally they are stored into an array instead of into single fields.

Reuse the main program of the previous exercise (that creates an object of this type, fills the
fields asking the user by keyboard and prints them). What changes are necessary for the
program to work with Student2 objects? Note: the purpose of this exercise is to show that as
long as the public part of the object remains the same, the internal implementation does not
matter and can be modified without any further change on the programs using the object.

 * @author Antonio Viñuela Pérez
 * @author Ignacio Velasco Delgado
 *
 */
public class Exercise3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		//Asking for fields of the Student class		
		System.out.println("Enter name of student");
		String n = sc.next();
		System.out.println("Enter surname of student");
		String sN = sc.next();
		System.out.println("Enter programming mark");
		float pM = sc.nextFloat();
		System.out.println("Enter calculus mark");
		float cM = sc.nextFloat();
		System.out.println("Enter algebra mark");
		float aM = sc.nextFloat();
		System.out.println("Enter information skills mark");
		float iM = sc.nextFloat();
		System.out.println("Enter writing skills mark");
		float wM = sc.nextFloat();

		//Declaring Student variable
		Student student = new Student (n, sN, pM, cM, aM, iM, wM);

		//Printing final output:
		System.out.println(student.getName() + " " + student.getSurname() + "'s marks:");
		System.out.println("Programming: " + student.getPMark());
		System.out.println("Calculus: " + student.getCMark());
		System.out.println("Algebra: " + student.getAMark());
		System.out.println("Information skills: " + student.getIMark());
		System.out.println("Writing skills:" + student.getWMark());

		//For the program to work with the private fields, set and get methods must be used instead of just directly accessing the field from the main class
		sc.close();
	}



}


