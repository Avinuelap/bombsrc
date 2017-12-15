package week9;
import java.util.Scanner;
public class Exercise1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
	/////////// V A R I A B L E S ///////////		
		byte iH; 
		byte iM; 
		byte fH;
		byte fM;
		int n;
		//TimeInterval t;
		TimeInterval [] array;
	/////////////////////////////////////////
		System.out.println("Enter amount of intervals you want to input");
		n= sc.nextInt();
		array = new TimeInterval [n];
		for (int i=0; i<n; i++) {
			System.out.println("Enter initial hour (not minutes) for interval " + (i+1));
			iH = sc.nextByte();
			System.out.println("Enter initial minutes for interval " + (i+1));
			iM = sc.nextByte();
					
			System.out.println("Enter final hour (not minutes) for interval " + (i+1));
			fH = sc.nextByte();
			System.out.println("Enter final minutes for interval " + (i+1));
			fM = sc.nextByte();
			
			array[i] = new TimeInterval(iH, iM, fH, fM);
			System.out.println(array[i].initialHour + ":" + array[i].initialMin + " - " + array[i].finalHour + ":" + array[i].finalMin );
			System.out.println("Runs through: " + array[i].tInterval);
			System.out.println();
		}
		
		sc.close();
		// TimeInterval t1 = new TimeInterval( iH,  iM,  fH,  fM);

	}

}
