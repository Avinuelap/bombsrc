package week4;

import java.util.Scanner;

public class Exercise6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double initialSeconds = sc.nextDouble();
		int hours = (int) initialSeconds / 3600;
		double hRemainder = initialSeconds % 3600;
		if (hRemainder == 0) {
			byte minute = 0;
			byte finalSeconds = 0;
			System.out.println(hours + ":" + minute + ":" + finalSeconds);
		} else {
			int minute = (int) hRemainder / 60;
			double mRemainder = hRemainder % 60;
			int finalSeconds = (int) mRemainder;
			System.out.println(hours + ":" + minute + ":" + finalSeconds);
		}

	}
}
