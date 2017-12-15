package week6;

import java.util.Scanner;
public class Exercise9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//VARIABLES
		String [] [] calendar;
		String month;
		int day;
		boolean stop=false; //control variable of the do-while loop

		//MATRIX
		calendar = new String [12] [];//Irregular matrix
		calendar [0] = new String [31];//January
		calendar [1] = new String [28];//February
		calendar [2] = new String [31];//March
		calendar [3] = new String [30];//April
		calendar [4] = new String [31];//May
		calendar [5] = new String [30];//June
		calendar [6] = new String [31];//July
		calendar [7] = new String [31];//August
		calendar [8] = new String [30];//September
		calendar [9] = new String [31];//October
		calendar [10] = new String [30];//November
		calendar [11] = new String [31];//December

		//Assign "nothing" to all elements on the calendar matrix, so it will show "nothing" on the days with no reminders
		for (int i=0;i<calendar.length;i++){
			for (int ii=0; ii<calendar[i].length; ii++) {
				calendar[i][ii]="Nothing";
			}
		}

		System.out.println("Introduce as many remainders as you wish , when you finish just write stop");
		do {
			System.out.println("Please introduce a month");
			month = sc.next();
			if (month.equals("Stop")||month.equals("stop")) {	//if user enters "stop", it will not ask for more data
				stop=true;
			}
			else {												//if user does not enter "stop", the loop will be executed			
				System.out.println("Please introduce a day");
				day = sc.nextInt();
				System.out.println("What do you want to remember?");
				String boringthings = sc.next();

				if ((month.equals("January") && day <= 31) || (month.equals("january")  && day <= 31)) {
					calendar [0] [day-1] = boringthings;
				}

				if ((month.equals("February") && day <= 28)|| (month.equals("february") && day <= 28)) {
					calendar [1] [day-1] = boringthings;
				}

				if ((month.equals("March") && day <= 31)|| (month.equals("march") && day <= 31)) {
					calendar [2] [day-1] = boringthings;
				}

				if ((month.equals("April") && day <= 30)|| (month.equals("april") && day <= 30)) {
					calendar [3] [day-1] = boringthings;
				}

				if ((month.equals("May") && day <= 31)|| (month.equals("may") && day <= 31)) {
					calendar [4] [day-1] = boringthings;
				}

				if ((month.equals("June") && day <= 30)|| (month.equals("june") && day <= 30)) {
					calendar [5] [day-1] = boringthings;
				}

				if ((month.equals("July") && day <= 31)|| (month.equals("july") && day <= 31)) {
					calendar [6] [day-1] = boringthings;
				}

				if ((month.equals("August") && day <= 31)|| (month == "august" && day <= 31)) {
					calendar [7] [day-1] = boringthings;
				}

				if ((month.equals("September") && day <= 30)|| (month.equals("september") && day <= 30)) {
					calendar [8] [day-1] = boringthings;
				}

				if ((month.equals("October") && day <= 31)|| (month.equals("october") && day <= 31)) {
					calendar [9] [day-1] = boringthings;
				}

				if ((month.equals("November") && day <= 30)|| (month.equals("november") && day <= 30)) {
					calendar [10] [day-1] = boringthings;
				}

				if ((month.equals("December") && day <= 31)|| (month.equals("december") && day <= 31)) {
					calendar [11] [day-1] = boringthings;
				
				}
				else {
					System.out.println("Not a valid date");
				}
			}
		}
		while (!stop);

		sc.close();

		//Printing the table:
		for (int i = 0; i < calendar.length; i++) {
			System.out.println("Month "+(i+1)+": ");
			for (int j = 0; j < calendar[i].length; j++) {
				System.out.print((j+1)+":"+calendar[i][j] +"\t");
			}
			System.out.println();
		}
	}
}


