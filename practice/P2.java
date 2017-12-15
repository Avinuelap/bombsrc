package practice;

import java.util.Scanner;
public class P2 {

	public static void main(String[] args) {
		///// V A R I A B L E S /////////////		
		int n;
		int randomOne;			//first random value (over diagonal)	
		int randomTwo;			//second random value (below diagonal)
		/////////////////////////////////////		
		Scanner sc = new Scanner (System.in);
		
		//Creating the square matrix
		System.out.println("Enter dimension of the square matrix");
		n=sc.nextInt();
		
		int[][] matrix= new int [n][n];
		
		sc.close();
		
		//Assigning value "1" to the diagonal
		for (int i=0; i<n; i++) {
			matrix[i][i]=1;
		}
		
		//Over diagonal:	
		for (int i=0; i<n; i++) {
			for (int ii=0; ii<n; ii++) {
				
				if (ii>i) {
					boolean even=false;   	//control variable of the do-while loop
					do {
						even=false;
						randomOne=(int)(Math.random()*50+1);
						if ((randomOne%2) == 0) {
							even=true;
						}
					}
					while (!even);
					
				matrix [i][ii]=randomOne;
				}
				
		//Below diagonal:
				if (ii<i) {
					boolean range=false;
					do {
						range=false;
						randomTwo=(int)(Math.random()*11);
						if (randomTwo>=6) {
							range=true;}								
					}while (!range);					
					matrix [i][ii]=randomTwo;
				}		
		}
		}
		
		
		//Printing final matrix
		for (int i=0; i<n; i++) {
			for (int ii=0; ii<n; ii++) {
				System.out.print(matrix[i][ii]+"\t");
			}
			System.out.println();
		}
		
	}

}
