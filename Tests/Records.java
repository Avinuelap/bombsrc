package Tests;

public class Records {

	public static void main(String[] args) {
		//Records store data of different type into a single variable
		//Objects -> super-records, evolution of records
		//To create an object, a new class is required (no main method!) -> skeleton
		
		Date var1;
		Date var2, var3;
		
		var1 = new Date();
		
		var1.day = 28;
		var1.month = "August";
		var1.year = 1999;
		var1.leapYear = false;
		
		var2 = new Date();
		var2.day = 28;
		var2.month = "August";
		var2.year = 1999;
		var2.leapYear = false;
		
		var3 = new Date(); //default values will be given
		
		
		//-------------------------------------------------------------------------------------------------------
		//				NOMENCLATURES																		    |
		//	program containing a record/object skeleton -> class												|
		//	inner variables inside a record/object -> fields													|
		//	variable of the new type -> object (for example: var1, var2, var3 are objects)					    |
		//-------------------------------------------------------------------------------------------------------
		
		//-------------------------------------------------------------------------------------------------------
		//			INITIAL VALUES OF OBJECTS' FIELDS 															|
		//	default will be 0 for numeric types, false for boolean and null for Strings. 						|
		//	default value can be changed by assigning a value to the variable in the .class						|
		//-------------------------------------------------------------------------------------------------------
		
		// Printing:
		System.out.print("var1 (given values):	");
		System.out.print(var1.day+"th "+var1.month+", "+var1.year);
		
		System.out.println();
		
		System.out.print("var3 (default values):	");
		System.out.print(var3.day+"th "+var3.month+", "+var3.year);
		
		System.out.println();
		System.out.println();
		
		
		// Comparing:				Never directly compare var1==var2. You will compare adresses, not data
		boolean compare = var1.day == var2.day;		//if true, "compare" boolean will be true
		System.out.println(compare);
		
		System.out.println();
		
		//_________________________________________________________________________________//
		//				ARRAY FIELDS
		//	declared new field on skeleton: events. It is an array.
		// 	Values of the array can be changed from here:
		Date arrayEx;
		arrayEx = new Date();
			arrayEx.events[0]="die";
			System.out.println(arrayEx.events[0]);
			
			System.out.println();
			
			for (int i=0; i<arrayEx.events.length; i++) {
				arrayEx.events[i]="nothing";
				System.out.print(arrayEx.events[i]+ " ");
			}
			
			
		System.out.println();
		
		
		// 				COMPOSITION
		//Created new .class: Student
		
		
		
	}

}
