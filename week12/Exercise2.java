package week12;
import java.util.Scanner;

public class Exercise2 {
	//FIRST METHOD
		private static double sumRow (double [] doubleArray) {
			double sum = 0.0;
			for (int ii = 0; ii < doubleArray.length; ii++) {
				sum= sum + doubleArray[ii];
			}
			return sum;
		}
	
	//SECOND METHOD
		private static int findBigRow (double [][] doubleMatrix) {
			double maxSum = 0;
			int maxRowIndex = 0;
			double[] sumRowArray = new double [doubleMatrix.length]; //Used to store the sums of the rows
			
			//For loop calculating all the row sums
			for(int i = 0; i < doubleMatrix.length; i++) {	
				sumRowArray[i]=sumRow(doubleMatrix[i]);		//Method 1 will be invoked using row with index i	
			}	
			
			//For loop comparing all the row sums. Biggest one will be stored in the maxSum variable. If biggest sum, index will be stored
			for (int x=0; x<sumRowArray.length; x++) {
				if (sumRowArray[x]>=maxSum) {
					maxSum = sumRowArray[x];
					maxRowIndex = x+1; //So it is not 0
				}
			}
			return maxRowIndex;
		}
	
	//THIRD METHOD
		private static void printMatrix (double [][] doubleMatrix) {

			for (int i = 0; i < doubleMatrix.length; i++) {
				for (int j = 0; j < doubleMatrix[0].length; j++) {
					System.out.print(doubleMatrix[i][j] + " ");
				}
				System.out.println();
			}

		}
		
	//MAIN
		public static void main (String [] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please introduce the size of the matrix");
			System.out.println("Rows:");
			int rows = sc.nextInt();
			System.out.println("Columns:");
			int columns = sc.nextInt();
			sc.close();
			double [][] matrix = new double [rows] [columns];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					matrix[i][j] = (int) ((Math.random()*20)-10);
				}
			}
			printMatrix(matrix);

			System.out.println("The largest row is row number "+ findBigRow(matrix)); 
		}

	

	


}
