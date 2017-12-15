package week8;
import java.util.Scanner;
/**
 * Create a new type named RightTriangle to represent a right triangle, with two float
fields base and height. Create a constructor that receives both fields as parameters and
checks if they are bigger than 0 (if not they will be set to 1.0F). Write a new program that uses
the keyboard to read the base and the height and store them in a RightTriangle object.
Next it should ask the user whether the area or the perimeter of the triangle has to be
calculated and print the resulting value

 * @author Antonio Viñuela
 * @author Ignacio Velasco
 */

public class Exercise4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter height of the right triangle. If lower than 0, it will be automatically given a value of 1");
		float h = sc.nextFloat();
		
		System.out.println("Enter base of the right triangle. If lower than 0, it will be automatically given a value of 1");
		float b = sc.nextFloat();
		
		RightTriangle triangle;
		triangle = new RightTriangle (h, b);
		
		// System.out.println(triangle.base + ", " + triangle.height);
		
		//////////////////////////////////////////
		
		boolean area;
		boolean perim;
		float c;
		
		System.out.println("Calculate area? (true/false)");
		area = sc.nextBoolean();
		System.out.println("Calculate perimeter? (true/false)");
		perim = sc.nextBoolean();
		
		if (area==true) {
			System.out.println("Area is " + b*h/2);
		}
		
		if (perim==true) {
			c = (float) (Math.sqrt((Math.pow(b, 2)+(Math.pow(h, 2))))) ;
			System.out.println("Perimeter is " + (b+c+h));
			
		}
		sc.close();
		

	}

}
