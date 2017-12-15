package week4;
import java.util.Scanner;
public class Exercise9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
	System.out.println("Please enter buyer's age to calculate price");
	byte normalPrice=9;
	byte age=sc.nextByte();
		if (age<5) {
			double price=normalPrice-normalPrice*0.6;	
			System.out.println(price+"€");
		}
		else if (age<26) {
			double price=normalPrice-normalPrice*0.2;
			System.out.println(price+"€");
		}
		if (age>60) {
			double price=normalPrice-normalPrice*0.55;
			System.out.println(price+"€");
		}
		else if (age>26){
			byte price=normalPrice;
			System.out.println(price+"€");
		}
		
	}

}
