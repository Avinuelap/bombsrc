package quizzes;

public class Car {
	      public String brand;
	      public String model;
	      public int year;
	

	     public static void main (String [] args){
	         Car myCar = new Car();
	         Car yourCar;
	         myCar.brand= "Seat";
	         myCar.model = "Toledo";
	         myCar.year= 2005;
	         yourCar= myCar;
	         yourCar.year= 2000;
	         System.out.println("I have a "+myCar.year+" "+myCar.brand+" "+myCar.model);
	    }
	
		

	}


