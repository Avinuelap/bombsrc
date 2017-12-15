package week11;
import java.util.Scanner;
/**
 * @author Asntonio Viñuela
 * @author Ignacio Velasco
 */

public class Person {
	Scanner sc = new Scanner (System.in);

	private String name;
	private int age;
	private int dni;
	private char dniLetter;
	private char gender= 'F';
	private double weight;
	private double height; 

	
//// -		SET METHODS		- ////
	public void setName (String n) {
		this.name = n;
	}

	public void setAge (int a) {
		boolean ageOK=false;
		do {
			if (a>=0 && a<=120) {
				this.age = a;	
				ageOK = true;
			}else {
				System.out.println("Enter valid age");
				a = sc.nextInt(); 
			}
		} while (!ageOK);		
	}

	public void setGender (char c) {
		boolean genderOK = false;
		do {
			if (c=='F' || c=='M' || c=='f' || c=='M') {
				this.gender = c;
				genderOK = true;
			}
			else {
				System.out.println("Enter valid gender: F for female, M for male");
				c = sc.next().charAt(0);
			}
		}while (!genderOK);
	}

	public void setDni (int dni) {	
		int length;
		int counter=0;
		do {
			length=0;
			if (counter>0) {	//to change the number if it is not valid after checking it one time
				System.out.println("Enter valid DNI number");
				dni = sc.nextInt();
			}
			int checkDNI = dni;
			while(checkDNI!=0) {
				checkDNI = checkDNI / 10;
				length++;
				counter++;
			}		
		} while (length<1 || length>8);
		this.dni = dni;
		calculateDniLetter();

	}

	public void setHeight(double h) {
		boolean heightOK = false;
		do {
			if (h>0.20 && h<2.50) {
				this.height=h;
				heightOK = true;
			}
			else {
				System.out.println("Enter valid height");
				h = sc.nextDouble();
			}
		}while (!heightOK);
	}

	public void setWeight(double w) {
		boolean weightOK = false;
		do {
			if (w>10 && w<500) {
				this.weight=w;
				weightOK = true;
			}
			else {
				System.out.println("Enter valid weight");
				w = sc.nextDouble();
			}
		}while (!weightOK);
	}

	public void calculateDniLetter() {
		char [] letter = new char [] {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int i = this.dni % 23;
		this.dniLetter = letter [i];
	}

//// -	TOSTRING METHOD	- ////	
	public String toString() {
		if (this.gender == 'M' ||this.gender == 'm') {
			return "Name: " + this.name + "\nGender: Male" + "\nAge: " + this.age + " years old \nDni: " + this.dni+"-"+this.dniLetter + "\nWeight: " + this.weight + " kg \nHeight: " + this.height + " m";
		}else {
			return "Name: " + this.name + "\nGender: Female" + "\nAge: " + this.age + " years old \nDni: " + this.dni+"-"+this.dniLetter + "\nWeight: " + this.weight + " kg \nHeight: " + this.height + " m";	
		}	
	}

	/////////CONSTRUCTORS/////////
	//Full constructor:
	public Person (int a, String n, char c, int dni, double h, double w) {
		setAge(a);
		setName(n);
		setGender(c);
		setHeight(h);
		setWeight(w);
		setDni(dni);
		calculateDniLetter();
		toString();
	}
	
	//No-argument constructor
	public Person() {
		System.out.println("Enter name");
		String n = sc.next();
		setName(n);
		
		System.out.println("Enter age");
		int a = sc.nextInt();
		setAge(a);
		
		System.out.println("Enter gender ('F' for female, 'M' for male)");
		char c = sc.next().charAt(0);
		setGender(c);
		
		System.out.println("Enter height in metres (for example, 1,75)");
		double h = sc.nextDouble();
		setHeight(h);
		
		System.out.println("Enter weight in kg (for example, 60,5)");
		double w = sc.nextDouble();
		setWeight(w);
		
		System.out.println("Enter DNI number. Letter will be calculated automatically");
		int dni = sc.nextInt();
		setDni(dni);
		calculateDniLetter();
		
		toString();
	}
}
