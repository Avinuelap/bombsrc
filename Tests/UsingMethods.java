package Tests;

import java.util.Scanner;

/**
 * This program shows how to use an object which has been designed taking into
 * account information hiding. In this case fields cannot be directly accessed,
 * we need methods to do it.
 * 
 * @author Angel Garcia Olaya. PLG-UC3M
 * @since November 2017
 * @version 1.0
 *
 */
public class UsingMethods {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("This is a dummy program that allows you to store a Date" + " into memory and to change it");
		System.out.println("Please enter the day, the name of the month and the year");
		System.out.println(
				"If the name of the month or the day are incorrect," + " I will store by-default values for them");
		// We create the object using any of its constructors. As the
		// constructor will check if the provided values are correct, we don´t
		// need to do it here
		Date myDate = new Date(sc.nextInt(), sc.next(), sc.nextInt());
		System.out.println("The date you entered, after correction is");
		// We need to use the get methods to read the values stored into memory
		System.out.println(myDate.getDay() + "/" + myDate.getMonth() + "/" + myDate.getYear());
		if (myDate.isLeapYear()) {
			System.out.println("This is a leap year");
		} else {
			System.out.println("This is not a leap year");
		}
		// Now asking the user to change the date
		System.out.println("Please enter 1 to change the day, 2 to change the month or 3 to change the year"
				+ ". Any other number to finish");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Please enter the new day");
			// To change the value of any of the fields we need to use the set
			// method
			myDate.setDay(sc.nextInt());
			break;
		case 2:
			System.out.println("Please enter the new month");
			// To change the value of any of the fields we need to use the set
			// method
			myDate.setMonth(sc.next());
			break;
		case 3:
			System.out.println("Please enter the new year");
			// To change the value of any of the fields we need to use the set
			// method
			myDate.setYear(sc.nextInt());
			break;
		}
		System.out.println("The new date is");
		System.out.println(myDate.getDay() + "/" + myDate.getMonth() + "/" + myDate.getYear());
		if (myDate.isLeapYear()) {
			System.out.println("This is a leap year");
		} else {
			System.out.println("This is not a leap year");
		}
	}

}
