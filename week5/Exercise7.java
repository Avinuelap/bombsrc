package week5;

import java.util.Scanner;
public class Exercise7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter you birthday year");
		int year=sc.nextInt();
		System.out.println("Enter your birthday month(number)");
		boolean monthOK=false;
		byte month=sc.nextByte();
		do {
			if (month<=12 && month>0) {
				monthOK=true;

			}else {
				System.out.println("Enter your birthday month(number)");
				month=sc.nextByte();
			}
		}
		while (!monthOK);

		System.out.println("Enter your birthday day");
		byte day=sc.nextByte();
		boolean dayOK=false;
		do {
			//////////////////// MONTHS WITH 31 DAYS ////////////////////////
			if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
				if (day<=31 && day>0) {    
					dayOK=true;
				}else {
					System.out.println("Enter your birthday day");
					day=sc.nextByte();		}				
			}
			//////////////////// MONTHS WITH 28 DAYS (only October) /////////
			else if (month==2) {
				if (day<=28 && day>0) {
					dayOK=true;
				}else {
					System.out.println("Enter your birthday day");
					day=sc.nextByte();		}
			}
			//////////////////// MONTHS WITH 30 DAYS //////////////////////////
			else {
				if (day<=30 && day>0) {
					dayOK=true;
				}else {
					System.out.println("Enter your birthday day");
					day=sc.nextByte();		}
			}
		}
		while (!dayOK);
		sc.close();

		int thousands = year+month+day;
		int firstDigit = thousands/1000;
		int hundreds = thousands%1000;
		int secondDigit = hundreds/100;
		int tens = hundreds%100;
		int thirdDigit = tens/10;
		int fourthDigit = tens%10;		
		int firstSum = firstDigit+secondDigit+thirdDigit+fourthDigit;
		boolean oneDigit=false;
		/////////// FIRST LOOP: FIRST SUM HAS MORE THAN ONE DIGIT ///////////
		do {				
			if (firstSum<10) {
				System.out.println("Your lucky number is "+firstSum);
				oneDigit=true;
			}
			else {
				int secondSum = (firstSum/10)+(firstSum%10);
				//SECOND LOOP: SECOND SUM HAS MORE THAN ONE DIGIT. If year is entered correctly, it's impossible for the third sum to have more than one digit.
				do {
					if (secondSum<10) {
						System.out.println("Your lucky number is "+secondSum);
						oneDigit=true;
					}
					else {
						int thirdSum= (secondSum/10)+(secondSum%10);
						System.out.println("Your lucky number is "+thirdSum);
						oneDigit=true;
					}
				}	
				while (!oneDigit);
			}
		}
		while (!oneDigit);
	}
}






