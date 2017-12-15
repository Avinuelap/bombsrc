package week5;

import java.util.Scanner;

public class GuidedExercise2 {

	public static void main(String[] args) {
		// day could be a boolean, but we declare it as a String to show how to compare
		// Strings in conditionals
		String day;
		int soldiers, engines;
		boolean poison, rain;

		Scanner sc = new Scanner(System.in);
		System.out.println("Is it day or night?");
		day = sc.next();
		System.out.println("How many soldiers do you have?");
		soldiers = sc.nextInt();
		System.out.println("How many siege engines?");
		engines = sc.nextInt();
		System.out.println("Do you have poison? (true/false)");
		poison = sc.nextBoolean();
		System.out.println("Is it raining? (true/false)");
		rain = sc.nextBoolean();
		/*
		 * We are going to assume that the alternatives are not exclusive, i.e. more
		 * than one can be applicable. Then, we need to track if none is applicable, so
		 * we create an auxiliary variable to account for that
		 */
		boolean noneApplicable = true;
		// Checking the first strategy
		/*
		 * Avoid using == to compare Strings Although most of the times it is working,
		 * this is one of the cases where it is not (we'll see why when we speak about
		 * objects in lesson 4). Strings should be compared using equals, as shown below
		 */
		if (day.equals("night") && soldiers > 500 && engines >= 50 && !rain) {
			System.out.println("The recommended strategy is A: \"Silent attack\"");
			noneApplicable = false;
		}
		/*
		 * We do not use "else if" as we want the three strategies to be applicable, if
		 * we used an "else if" if the first one was applicable the next "if" would
		 * never be checked
		 */
		if (day.equals("day") && soldiers > 10000) {
			System.out.println("The recommended strategy is B: \"Crossfire\"");
			noneApplicable = false;
		}
		if (day.equals("night") && soldiers > 0 && poison) {
			System.out.println("The recommended strategy is C: \"Kill the king\"");
			noneApplicable = false;
		}
		// Now we check if none has been applied
		if (noneApplicable) {
			System.out.println("None  of  the  three  strategies  is satisfied  completely  "
					+ "but  I'll  tell  you  what you satisfy for each one of them right "
					+ "now so you can take a decision");
			// We define some constant Strings as we are going to reuse them
			final String NIGHT = "night", DAY = "day", SOLDIERS1 = "more than 500 soldiers",
					SOLDIERS2 = "more than 10000 soldiers";
			final String SOLDIERS3 = "one soldier", SIEGE = "siege machines", RAIN = "no rain", POISON = "poison";
			/*
			 * We will create two String variables, in one of them we will append what is
			 * satisfied, while in the other one we will append not satisfied items
			 */
			String satisfy = "\t Satisfy: ", noSatisfy = "\t Do not satisfy: ";
			// Strategy A
			System.out.println("Strategy A:");
			if (day.equals("night")) {
				satisfy = satisfy + NIGHT + "\t";
			} else {
				noSatisfy = noSatisfy + NIGHT + "\t";
			}
			if (soldiers > 500) {
				satisfy = satisfy + SOLDIERS1 + "\t";
			} else {
				noSatisfy = noSatisfy + SOLDIERS1 + "\t";
			}
			if (engines >= 50) {
				satisfy = satisfy + SIEGE + "\t";
			} else {
				noSatisfy = noSatisfy + SIEGE + "\t";
			}
			if (rain) {
				satisfy = satisfy + RAIN + "\t";
			} else {
				noSatisfy = noSatisfy + RAIN + "\t";
			}
			System.out.println(satisfy);
			System.out.println(noSatisfy);

			// Strategy B
			satisfy = "\t Satisfy: ";
			noSatisfy = "\t Do not satisfy: ";
			System.out.println("Strategy B:");
			if (day.equals("day")) {
				satisfy = satisfy + DAY + "\t";
			} else {
				noSatisfy = noSatisfy + DAY + "\t";
			}
			if (soldiers > 10000) {
				satisfy = satisfy + SOLDIERS2 + "\t";
			} else {
				noSatisfy = noSatisfy + SOLDIERS2 + "\t";
			}
			System.out.println(satisfy);
			System.out.println(noSatisfy);

			// Strategy C
			satisfy = "\t Satisfy: ";
			noSatisfy = "\t Do not satisfy: ";
			System.out.println("Strategy C:");
			if (day.equals("night")) {
				satisfy = satisfy + NIGHT + "\t";
			} else {
				noSatisfy = noSatisfy + NIGHT + "\t";
			}
			if (soldiers > 0) {
				satisfy = satisfy + SOLDIERS3 + "\t";
			} else {
				noSatisfy = noSatisfy + SOLDIERS3 + "\t";
			}
			if (poison) {
				satisfy = satisfy + POISON + "\t";
			} else {
				noSatisfy = noSatisfy + POISON + "\t";
			}
			System.out.println(satisfy);
			System.out.println(noSatisfy);

			// We close the Scanner. Non-compulsory but good to be done
			sc.close();

			///////////////////////// S E C O N D   P A R T ////////////////////////////
			int totalMoney=100000; //total money available for posterior operations
			System.out.println(
					"I will randomly select a strategy for you and buy everything you need for it, as long as you have resources available");
			int chosenStrategy = (int) (Math.random() * 3);

			if (chosenStrategy == 0) {
				System.out.println("Try strategy A. \t"+"Buying everything needed:");
				if (soldiers<500) {
					System.out.println((500-soldiers)+" were bought. "+((500-soldiers)*10)+" golden coins spent");
					
				}
		}
			else if (chosenStrategy == 1) {
				System.out.println("Try strategy B. \t"+"Buying everything needed:");
		}
			else {
				System.out.println("Try strategy C. \t"+"Buying everything needed:");
			}
			
		}
	}
}
