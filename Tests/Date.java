package Tests;

/**
 * An example of a Date class using methods to show decomposition, code reusing
 * and information hiding. Information hiding is done by not allowing external
 * programs to directly change the values of fields. Every change in the value
 * of a field must be done by means of a method. Also, to read the value of a
 * field we need to provide a method.
 * 
 * 
 * @author Angel Garcia Olaya. PLG-UC3M
 * @since November 2017
 * @version 1.0
 *
 */
public class Date {
	/*
	 * Now all the fields will be private, no direct access to them outside this
	 * program. But we don´t need to change this program at all because of it.
	 * 
	 */
	/** The day. Valid values are 1 to 31 (depending on the month) */
	private int day = 1;
	/** The month. We use a String */
	private String month = "january";
	/** The year. Any integer value is a valid value */
	private int year;
	/**
	 * Whether the year is a leap year or not. Year 0 was not a leap year (no
	 * leap years that time) but following the rules (divisible by 400) we mark
	 * it as leap year
	 */
	private boolean leapYear = true;

	/**
	 * No-argument constructor. It sets the initial values to 1/January/0
	 * (d/m/y). As we don´t need to perform any calculation we leave it empty
	 * and assign the by-default values when we declare the fields.
	 */
	public Date() {
	}

	/**
	 * Constructor: it checks the day and month are correct. If any of them is
	 * not correct it is set to 1. No value is received for the leapYear field
	 * as it will be automatically calculated. It uses methods to perform its
	 * work.
	 * 
	 * @param d
	 *            the day
	 * @param m
	 *            the month
	 * @param y
	 *            the year
	 */
	public Date(int day, String month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	/**
	 * Constructor receiving just the year; month and day are set to November
	 * 7th
	 * 
	 * @param year
	 *            the year
	 */
	public Date(int year) {
		// Example of code re-using, we invoke the methods also here.
		setYear(year);
		setMonth("november");
		setDay(7);
	}

	/**
	 * Constructor receiving the day and the month. Year is set to this one.
	 * 
	 * @param day
	 *            the day
	 * @param month
	 *            the month
	 */
	public Date(int day, String month) {
		// Instead of repeating the code of the other constructor or invoking
		// methods we use the "this" reserved word to invoke another
		// constructor. Both solutions are equivalent in this case.
		this(day, month, 2017);
	}

	/**
	 * Constructor receiving the month as integer. It shows some short of
	 * information hiding as the way we receive the parameter (int) is not the
	 * way we store it (String)
	 * 
	 * @param day
	 *            the day
	 * @param month
	 *            the number of the month
	 * @param year
	 *            the year
	 */
	public Date(int day, int month, int year) {
		// For the year we re-use the method
		setYear(year);
		// For the month, extra calculations must be done
		// We could use a switch or an array to store the months in order
		if (month >= 1 && month <= 12) {
			String[] monthNames = new String[] { "january", "february", "march", "april", "may", "june", "july",
					"august", "september", "october", "november", "december" };
			setMonth(monthNames[month - 1]);
		}
		// This is not really needed as the by-default value of month is january
		else {
			setMonth("january");
		}
		setDay(day);
	}

	/**
	 * Method to set the value of the year field. It will not generate any data
	 * (it will just modify the value of a field), so it is void. This method
	 * allows for decomposition, code reuse and also information hiding. Now it
	 * will not be invoked just here, but also by external programs.
	 * 
	 * @param ye
	 *            For this method to work we need to receive the year, which
	 *            will be an integer, so we create an integer parameter. If we
	 *            want to invoke this method, the value of "ye" must be
	 *            provided.
	 */
	public void setYear(int ye) {
		// Here, we have exactly the same code that we had previously in our
		// constructor
		/*
		 * We assign directly the year without any checking, any integer value
		 * is valid for a year. Notice that as the name of the field and the
		 * name of the parameter are different, we could omit the "this." but it
		 * is good to keep it
		 * 
		 */
		this.year = ye;
		// Now we calculate if this is a leap year
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			this.leapYear = true;
		} else {
			this.leapYear = false;
		}
	}

	/**
	 * Method to set the value of the month field. It will not generate any data
	 * (it will just modify the value of a field), so it is void. This method
	 * allows for decomposition, code reuse and also information hiding. Now it
	 * will not be invoked just here, but also by external programs.
	 * 
	 * @param month
	 *            For this method to work we need to receive the month, which
	 *            will be a String, so we create a String parameter. If we want
	 *            to invoke this method, the value of "month" must be provided.
	 *            In this case the name of the parameter is the name of a field
	 *            too, but using "this." we control it.
	 */
	public void setMonth(String month) {
		// Here, we have exactly the same code that we had previously in our
		// constructor
		switch (month.toLowerCase()) {
		case "january":
		case "february":
		case "march":
		case "april":
		case "may":
		case "june":
		case "july":
		case "august":
		case "september":
		case "october":
		case "november":
		case "december":
			this.month = month.toLowerCase();
		}
	}

	/**
	 * Method to set the value of the day field. It will not generate any data
	 * (it will just modify the value of a field), so it is void. This method
	 * allows for decomposition, code reuse and also information hiding. Now it
	 * will not be invoked just here, but also by external programs.
	 * 
	 * @param day
	 *            For this method to work we need to receive the day, which will
	 *            be an integer, so we create a int parameter. If we want to
	 *            invoke this method, the value of "day" must be provided. In
	 *            this case the name of the parameter is the name of a field
	 *            too, but using "this." we control it. Notice that we don´t
	 *            need to receive the value of the month, as when this is
	 *            invoked the value of the month field should be set, so we can
	 *            use it.
	 */
	public void setDay(int day) {
		// Here, we have exactly the same code that we had previously in our
		// constructor
		// We can declare local variables in methods: maxDays can only be used
		// in this method, it doesn't exist outside it
		// We check the maximum number of days of each month
		int maxDays;
		switch (this.month) {
		case "april":
		case "june":
		case "september":
		case "november":
			maxDays = 30;
			break;
		case "february":
			if (this.leapYear) {
				maxDays = 29;
			} else {
				maxDays = 28;
			}
			break;
		default:
			maxDays = 31;
		}

		if (day > 0 && day <= maxDays) {
			this.day = day;
		}
	}
	/*
	 * As the fields are private, we need to add get methods for all the fields
	 * we want an external program to be able to read. In our case we consider
	 * that the values of all the fields should be read externally, so we create
	 * get methods for all the fields.
	 */

	/**
	 * Method returning the value of the year field so it can be read by
	 * external programs.
	 * 
	 * @return the value of the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Method returning the value of the month field so it can be read by
	 * external programs.
	 * 
	 * @return the value of the month
	 */
	public String getMonth() {
		return this.month;
	}

	/**
	 * Method returning the value of the day field so it can be read by external
	 * programs.
	 * 
	 * @return the value of the day
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * Method returning the value of the leapYear field so it can be read by
	 * external programs. By convention, the get methods for boolean fields are
	 * named "is" instead of "get"
	 * 
	 * @return the value of the leapYear
	 */
	public boolean isLeapYear() {
		return this.leapYear;
	}
}