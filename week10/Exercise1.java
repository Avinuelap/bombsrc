package week10;
import java.util.Scanner;

/**
 * Create a new type to represent a Football player, with the following private fields: name,
surname, age, position and team.
- Create set and get methods for each of the fields:
- The age should be between 16 and 50 (if not 25 will be set).
- The position can only be goalkeeper, defense, midfielder or forward. If incorrect,
randomly select one of them.
- Create a full-constructor (consider reusing the former set methods).
In a different class, create an object of this new type and ask the user to fill its fields. Print all
the data stored by the object
 * @author Antonio Viñuela Pérez
 * @author Ignacio Velasco Delgado
 *
 */

public class Exercise1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);		
		sc.useDelimiter(System.getProperty("line.separator"));
		
		//Asking for values
		System.out.println("Introduce player's name");
		String name = sc.next();	
		System.out.println("Introduce player's surname");
		String surname = sc.next();
		System.out.println("Introduce player's age");
		int age = sc.nextInt();
		System.out.println("Introduce player's position");
		String position = sc.next();
		System.out.println("Introduce player's team");
		String team = sc.next();
		
		Player player = new Player (name, surname, age, position, team);
		//Invoking set methods:
		player.setName(name);
		player.setSurname(surname);
		player.setAge(age);
		player.setPos(position);
		player.setTeam(team);
		
		//Invoking get methods to receive private values and printing final output:
		System.out.println(player.getName() + " " + player.getSurname() + " is " + player.getAge() + " year old " + " years old. He is " + player.getPos() + " of " + player.getTeam());
				
		sc.close();
	}

}
