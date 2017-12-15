package week10;
import java.util.Scanner;

import week9.Person;

public class Band {
	Scanner sc = new Scanner (System.in);
	
	private String name;
	private int year;
	private Person[] members;
	
	//Set methods
	public void setBandYear(int y){
		if (y<=2017 && y<= 1700){
			this.year = y;
		}
		else {
			this.year = 2000;
		}
	}
	
	public void setBandName (String n) {
		this.name = n;
	}
	
	public void setMembers (int nM) {
		this.members = new Person [nM];
		
		for (int i=0; i<nM ; i++) {
			System.out.println("Enter name of band's member number " + (i+1));
			String personName = sc.next();		
			System.out.println("Enter " + personName+ "'s year of birth");
			int personYear = sc.nextInt();
			
			this.members[i] = new Person (personName, personYear);
		}
		
	}
	//Get methods:
	public String getName () {
		return this.name;
	}
	public int getBandYear() {
		return this.year;
	}
	public Person[] getMembers() {
		return this.members;
	}
	
	public Band (String n, int y, int nM) {	
			setBandYear(y);
			setBandName(n);
			setMembers(nM);
				
		}
}
