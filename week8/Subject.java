package week8;

public class Subject {
	public String name;
	public byte semester;
	public Date[] array = new Date[8];
	
	public Subject () {
		array [0] = new Date (7, 11, 2017);
		array [1] = new Date (8, 11, 2017);
		array [2] = new Date (14, 11, 2017);
		array [3] = new Date (15, 11, 2017);
		array [4] = new Date (21, 11, 2017);
		array [5] = new Date (22, 11, 2017);
		array [6] = new Date (28, 11, 2017);
		array [7] = new Date (29, 11, 2017);
	}
}
