package Tests;

public class HugoTonto {

	public static void main(String[] args) {
		char[] arrayLetras = {'a','b','c','d','e'};
		int[] array = {1,60,7,4,90};
		int mayor = 0;
		int index = 0;
		
		for (int i=0; i<array.length; i++) {
			if (array[i]>mayor) {
				mayor = array[i];
				index = i;
			}
		}
		
		System.out.println(mayor);
		System.out.println(index);
		System.out.println("La letra es la " + arrayLetras[index]);

	}

}
