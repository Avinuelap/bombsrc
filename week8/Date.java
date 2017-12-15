package week8;

public class Date {
	public int day;
	public int month;
	public int year;
	public boolean leapYear = false;

	public Date (int d, int m, int y) {
		year = y;
		//Checking if the year is a leap year:
		if (year%4==0 && (year%100!=0 || year%400!=0)) {
			leapYear = true;
		}

		//Checking if month is OK:
		switch (m) {
		case 1:
		case 2: 
		case 3: 
		case 4: 
		case 5: 
		case 6: 
		case 7: 
		case 8: 
		case 9: 
		case 10:
		case 11: 
		case 12: 

			break;

			//If month is incorrect, random value assigned:
		default: m= (byte)(Math.random()*11+1);
		}
		month = m;


		//Checking day is OK
		byte maxDays;
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDays = 31;
			break;

		case 2:
			if (!leapYear) {
				maxDays = 28;
			}else {
				maxDays = 29;
			}
			break;

		default: maxDays = 30;	
		}
		//If day is in the range of the month, it is OK. Else, random value assigned:
		if (d<= maxDays) {
			day = d;
		} else {
			boolean dayOK=false;
			do {
				d= (byte)(Math.random()*30+1);
				if (d<=maxDays)	{
					dayOK = true;
					day = d;
				}																	
			}while (!dayOK);

		}
		System.out.println(day + "/" + month + "/" + year);
	}
}
