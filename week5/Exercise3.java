package week5;
import java.util.Scanner;
public class Exercise3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=1;  //this will be the times multiplication will be done
		boolean end=false;
		System.out.println("Enter integer number");
		int number=sc.nextInt();
		System.out.println("Enter number of multiples");
		int multiples=sc.nextInt();
		do {	
			System.out.print(number*n);
			if (multiples!=n) {
				System.out.print(", ");
				n=n+1;
			}else {
				end=true;
			}
		}
		while (!end);
		sc.close();
	}

}
