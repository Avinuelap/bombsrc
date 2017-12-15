package week5;

import java.util.Scanner;

public class Exercise8{

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);



        ////////////////////// V A R I A B L E S ///////////////////////////////////////////////////////////
        int N;                            //Order of the matrix (maximum number), entered by user
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Enter max number (order of the matrix)");
        N=sc.nextInt();
        sc.close();

        // for(int erow = 0; erow < N; erow++) {
        //   for(int ecol = 0; ecol<N; ecol++) {
        //        System.out.print("[" + ecol + "," + erow + "]");	//this code was only for me to organize the rows and columns
        //  }
        //    System.out.println();
        // }
        
        System.out.println();
        for(int row = 0; row < N; row++) {
        	for(int col = 0; col<N; col++) {
        		int dif = (row - col);
        		if (row>col) {
        			System.out.print(N - dif +1 +" ") ;	
        		} else {
        			System.out.print(0 - dif +1 +" ") ; //this will only happen if row<col
        		}
        	}
        	System.out.println(); 		//Use this so next line is under previous one
        }
    }
}
