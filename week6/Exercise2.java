package week6;

public class Exercise2 {

	public static void main(String[] args) {
		int [] array1 = new int [5] ;
		for (int i=0; i<array1.length; i++) {
			array1[i] = (int) (Math.random()*101); //this will assign values between 0 and 100 (both included)
		}

		int [] array2 = array1;
		array1 [2]= 28;

		System.out.print("Array1 is: ");
		for (int i=0; i<array1.length; i++) {			
			System.out.print(array1[i]+" ");
		}
		System.out.println();
		System.out.print("Array2 is: ");
		for (int i=0; i<array2.length; i++) {
			System.out.print(array2[i]+" ");
		}
		//Value for array[2] is the same for both arrays, as array1 will always be equal to array2

		//////////////////////////////////////////////////////////////////////////////////////////
		System.out.println();
		System.out.println("_________________________");
		System.out.println();
		/////////////////////////////////////////////////////////////////////////////////////////

		int [] array3 = new int [5] ;
		for (int i=0; i<array3.length; i++) {
			array3[i] = (int) (Math.random()*101); //this will assign values between 0 and 100 (both included)
		}

		int [] array4 = new int [5];
		System.arraycopy (array3, 0, array4, 0, array3.length) ;
		array3 [2]= 28;

		System.out.print("Array3 is: ");
		for (int i=0; i<array3.length; i++) {			
			System.out.print(array3[i]+" ");
		}
		System.out.println();
		System.out.print("Array4 is: ");
		for (int i=0; i<array4.length; i++) {
			System.out.print(array4[i]+" ");
		}
		//Equality is not maintained: array4[2] does not change when array3[2] does
	}

}
