package week3;

public class Exercise21 {

	public static void main(String[] args) {
		int a = 28; long b = 2000L ; float c = 3.6F;
			double d = a + b / c;
				System.out.println(d);//type should be double, to be able to store the real number given by the arithmetic operation
				
		int a2 = 28; long b2 = 2000L ; byte c2 = 100;
			long d2 = a2 + b2 / c2;
				System.out.println(d2);//type should be Long as it is needed to store the result, containing another Long.
	
		int a3 = 28; long b3 = 2000 ; int c3 = 360;
				long d3 = a3 + b3 / c3;
				System.out.println(d3);//type should be Long as it is needed to store the result, containing another Long.
	}

}
