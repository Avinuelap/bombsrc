package week10;

public class Player {
	private String name;
	private String surname;
	private int age;
	private String position;
	private String team;

	//Set method for every field:
	public void setName (String n) {
		this.name = n;		
	}
	
	public void setSurname (String sN) {
		this.surname = sN;
	}
	
	public void setAge (int a) {
		if (a>=16 && a<=50) {
			this.age = a;
		}
		else {
			this.age = 25;
		}
	}
	
	public void setPos (String p) {
		switch (p.toLowerCase()) {
		case "goalkeeper":
		case "defense":
		case "midfielder":
		case "forward":
			this.position = p; break;
		
		default:
			int rP = (int)(Math.random()*4);
			switch (rP) {
			case 0: this.position = "goalkeeper"; break;
			case 1: this.position = "defense"; break;
			case 2: this.position = "midfielder"; break;
			case 3: this.position = "forward"; break;
			}
		}
	}
	
	public void setTeam (String t) {
		this.team = t;
	}
	/////////////////////////////////////////////////
	
	//Full constructor:
	public Player (String n, String sN, int a, String p, String t) {
		setName(n);
		
		setSurname(sN);
		
		setAge(a);
		
		setPos(p);
		
		setTeam(t);
	}
	
	//Get method for every field:
	public String getName() {
		return this.name;		
	}
	
	public String getSurname() {
		return this.surname;
	}
	public int getAge() {
		return this.age;
	}
	public String getPos() {
		return this.position;
	}
	public String getTeam() {
		return this.team;
	}
}