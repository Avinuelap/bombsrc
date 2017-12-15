package Tests;

public class Arrays {

	public static void main(String[] args) {
		//separado
		int[]testArray1;
		testArray1=new int[6];

		//En una linea
		double[]testArray2=new double[6];

		int[]testArray3= {1, 5, 3, 80, 79, 6};

		//Printing all array elements:
		System.out.println("Print of all Array elements");
		System.out.print("Array 3 (values set): ");
		for (int i=0; i < testArray3.length; i++) {
			System.out.print(testArray3[i] +" ");
		}
		System.out.println();
		System.out.print("Array2 (no values set): ");

		for (int i=0; i < testArray2.length; i++) {
			System.out.print(testArray2[i]+" ");
		}
		System.out.println();

		//Summing all array elements
		System.out.println("Sum of all Array3 elements:" );
		int sum=0;
		for (int i=0; i<testArray3.length; i++) {
			sum = sum+testArray3[i];
		}
		System.out.println("Sum is "+sum);
		System.out.println();

		//Print of maximum element
		int max=testArray3[0];
		for (int i=0; i<testArray3.length; i++) {
			if (testArray3[i] > max) max= testArray3[i];
		}
		System.out.println("Max is "+max);
		
	}

}
