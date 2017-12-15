///////////// October 25th, 2016 //////////////////

package practice;
import java.util.Scanner;
public class P1 {

public static void main(String[] args) {
    //////// V A R I A B L E S /////////
	int n;        //number of students
	String [] students;
	float [] marks;
	////////////////////////////////////
	
	Scanner sc = new Scanner (System.in);
	System.out.println("Enter number of students");
	n = sc.nextInt();
	students= new String [n];
	marks = new float [n];
	
	for (int i=0; i<n; i++) {
		System.out.println("Enter name of the student");
		students [i]=sc.next();
		System.out.println("Enter mark of the student");
		marks[i] = sc.nextFloat();
	}
	sc.close();
	System.out.println();
	System.out.println("Students failing are:");
	
	for (int i=0; i<n; i++) {
		if (marks[i]<5) {
			System.out.println(students[i]+": "+marks[i]);
		}
	}

    }
}
