package week3;

public class Exercise19 {

	public static void main(String[] args) {
		float a; float b; float c;
		a = 5;
		b = 0;
		c = a / b;
		System.out.println(c);//result is infinity. Instead of taking b= straight 0, as integer types, it takes approximate 0, so division results infinity.

	}

}
