package week10;
import java.util.Scanner;
/**
 * Create the Student class, which represents a first year student. It will have the following
private fields: name, surname, programming mark, algebra mark, calculus mark,
physics mark, information mark and writing mark (choose the most suitable type for
each of the former fields).
- Create set and get methods for each of the fields: the values for the marks must be on the
right range (if not a zero will be assigned to the mark)
- Create a constructor that receives values for all the fields.
Write a program that creates an object of this type, fills the fields asking the user by keyboard
and prints them
 * @author Antonio Viñuela Pérez
 * @author Ignacio Velasco Delgado
 *
 */
public class Exercise2 {

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
		
		
		sc.close();
	}

}
