package week6;
import java.util.Scanner;
public class Exercise10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/////////////////////////// M A T R I X  1 ///////////////////////////////////////
		int r1;		//rows of first matrix
		int c1;		//columns of first matrix

		System.out.println("Specify the number of rows of the M1 matrix and press Enter");
		r1= sc.nextInt();
		System.out.println("Specify the number of columns of the M1 matrix and press Enter");
		c1= sc.nextInt();
		int [][] matrix1 = new int [r1][c1];

		for (int i=0;i<matrix1.length;i++){
			for (int ii=0; ii<matrix1[i].length; ii++) {
				System.out.println("Introduce the term in the "+i+", "+ii +" position and press Enter");
				matrix1[i][ii]=sc.nextInt();			
			}
		}
		System.out.println();
		System.out.println("The M1 matrix is: ");
		for (int i=0;i<matrix1.length;i++){
			for (int ii=0; ii<matrix1[i].length; ii++) {
				System.out.print(matrix1[i][ii]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		///////////////////////// M A T R I X  2 /////////////////////////////////////////
		int r2;		//rows of second matrix
		int c2;		//columns of second matrix
		
		System.out.println("Specify the number of rows of the M2 matrix and press Enter");
		r2= sc.nextInt();
		System.out.println("Specify the number of columns of the M2 matrix and press Enter");
		c2= sc.nextInt();
		int [][] matrix2 = new int [r2][c2];

		for (int i=0;i<matrix2.length;i++){
			for (int ii=0; ii<matrix2[i].length; ii++) {
				System.out.println("Introduce the term in the "+i+", "+ii +" position and press Enter");
				matrix2[i][ii]=sc.nextInt();
			}
		}
		System.out.println();
		System.out.println("The M2 matrix is: ");
		for (int i=0; i<matrix2.length; i++){
			for (int ii=0; ii<matrix2[i].length; ii++) {
				System.out.print(matrix2[i][ii]+" ");
			}
			System.out.println();
		}
		sc.close();

		System.out.println();

		////// COMPARE BOTH MATRIXES TO CHECK IF ANY NUMBER IS REPEATED //////
		for (int i=0;i<matrix1.length;i++){
			for (int ii=0; ii<matrix1[i].length; ii++) {
				for (int x=0;x<matrix2.length;x++){
					for (int xx =0; xx<matrix2[i].length; xx++) {
						if (matrix1[i][ii] == matrix2[x][xx]) {
							System.out.print("The term "+matrix1[i][ii]+" is included in both matrixes");
							System.out.println();
						}
					}
				}
			}
			System.out.println();
		}
	}
}
