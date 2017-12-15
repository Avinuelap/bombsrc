package Tests;
public class UsingComposition {

	public static void main (String[] args) {
		Student st = new Student();
		st.name = "Mister";
		st.surname = "X";
		
		st.birthday = new Date();
		st.birthday.day = 28;			
			
	}
}
