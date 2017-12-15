package week8;
/**
 * Create a Phone class with the following fields: brand, model and year. Add a full
constructor to fill the fields. Add also an empty non-argument constructor. In a different
program create 3 objects of the Phone class as follows:
a. Using the constructor.
b. Using the no-argument constructor and filling the fields in the program by copying the
values of the first created object.
c. For the third one, instead of creating it we just assign it to the first one and after that
we change its model and year.
Print the fields of the three objects to check the final value of each of them

 * @author Antonio Viñuela
 * @author Ignacio Velasco
 */

public class Exercise2 {

	public static void main(String[] args) {
		Phone phone1, phone2, phone3;
		
///// A) /////////////////////////////////////////
		phone1 = new Phone(2016, "Samsung", "S7");
		
///// B) /////////////////////////////////////////
		phone2 = new Phone();
		phone2.year = phone1.year;
		phone2.brand = phone1.brand;
		phone2.model = phone1.model;
		
///// C) /////////////////////////////////////////
		phone3=phone1;
		phone3.year = 2029;
		phone3.brand = "Huawei";
		
		System.out.println(phone1.year + ", "+phone1.brand+ ", "+ phone1.model);
		System.out.println(phone2.year + ", "+phone2.brand+ ", "+ phone2.model);
		System.out.println(phone3.year + ", "+phone3.brand+ ", "+ phone3.model);
		
		
		
	}

}
