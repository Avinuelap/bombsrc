package week8;

public class Exercise5 {

	public static void main(String[] args) {
		System.out.println("Days with Programming class:");

		Subject end = new Subject();	
		for (int i=0; i<end.array.length; i++ ) {
			System.out.println(end.array[i].day + "/" + end.array[i].month + "/" + end.array[i].year);
			
		}
		
	}

}
