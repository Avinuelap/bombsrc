package week12;
import java.util.Scanner;

public class Player {
	Scanner sc = new Scanner (System.in);
	
	//Fields
	private String name;
	private int score;
	private String strategy;
	private String choice;
	private String lastOption = "rock"; //Set default to rock
	
	//Set methods:
	public void setName (String n) {
		this.name=n;
	}
	public void setScore (int s) {
		this.score=s;
	}
	public void setStrategy (String i) {
		boolean OK = false;
		do {
			if (i.toLowerCase().equals("random") || i.toLowerCase().equals("cyclic") || i.toLowerCase().equals("copy")) {
				OK = true;
			} else {
				System.out.println("Enter valid strategy: Random, Cyclic or Copy");
				i = sc.next();
			}
		} while (!OK);
		this.strategy = i;
	}
	
	public void setChoice (int c) {
		if (this.strategy.toLowerCase().equals("random")) {
			int choice = (int)(Math.random()*3);
				switch (choice) {
				case 0: this.choice = "rock"; break;
				case 1: this.choice = "paper"; break;
				case 2: this.choice = "scissors"; break;
				}
		}
		else if (this.strategy.toLowerCase().equals("cyclic")) {
			if (c==1 || c==4 || c==7 || c==10 || c==13 || c==16 || c==19 || c==22 || c==25) {
				this.choice = "rock";
			}
			if (c==2 || c==5 || c==8 || c==11 || c==14 || c==17 || c==20 || c==23) {
				this.choice = "paper";
			}
			if (c==3 || c==6 || c==9 || c==12 || c==15 || c==18 || c==21 || c==24) {
				this.choice = "scissors";
			}
		}
		else {
			this.choice = this.lastOption;
		}
	}
	
	//Get methods:
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	public String getStrategy() {
		return this.strategy;
	}
	public String getChoice() {
		return this.choice;
	}
	
	//Other method:
	public void chooseOption (String w) {
		this.lastOption = w;
	}
	
	//Constructor
	public Player () {
		System.out.println("Enter name");
		setName(sc.next());
		
		System.out.println("Enter strategy (Random, Cyclic or Copy)");
		setStrategy(sc.next());
	}
}

