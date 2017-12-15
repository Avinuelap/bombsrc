package week5;

public class Exercise2 {

	public static void main(String[] args) {
		float n=1;
		boolean hundred=false;
		do {
			System.out.print(n);
			if (n!=100) {
				n=(float)(n+1.5);
				System.out.print(", ");  //the comma is here so when 100 is printed, there is no comma behind it

			}else {
				hundred=true;


			}
		}
		while (!hundred);


	}

}
