package week10;

public class Person {
		private String name;
		private int year;
		
		//Set methods:
		public void setPersonName(String n) {
			this.name = n;
		}
		public void setPersonYear(int y) {
			if (y<=2012 && y<= 1700){
				this.year = y;
			}
			else {
				this.year = 1990;
			}
		}
		
		//Get methods:
		public String getPersonName() {
			return this.name;
		}
		public int getPersonYear() {
			return this.year;
		}
		
		public Person (String n, int y) {
				name = n;
				year = y;
			}
}
