package objects;

public class Main {

	public static void main(String[] args) {
		
	//////// K I N G D O M S /////////
		Kingdom lann, barath, stark;
		
		lann= new Kingdom("Lannister", "Hear me roar!", 30, 100, 70, 20);  //declaring in a single line
		
		//lann= new Kingdom();
		//barath= new Kingdom();		//declaring in other way
		//stark= new Kingdom();
		
		//lann.name = "Lannister";
		//lann.motto = "Hear me roar!";
		//lann.maxPopulation = 100;
		//lann.currPopulation = 70;
		//lann.maxBuildings = 30;
		//lann.currBuildings = 20;
		
	/////// B U I L D I N G S ///////////		
		Building houseA, houseB, houseC;
		Building palaceA, palaceB, palaceC;
		
		houseA= new Building("House A", "Eat and sleep", 0, 1, lann, "Family"); //declaring in one line
		
		//houseA= new Building();
		
		//houseA.name = "House A";
		//houseA.description = "Eat and sleep";
		//houseA.kingdom = lann;
		//houseA.type = "Family";
		//houseA.users = 0;
		//houseA.vacancies = 1;
		
	///////// P E R S O N //////////////
		Person cersei, stannis, eddard, arya;
		
		cersei= new Person();
		
		cersei.name= "Cersei";
		cersei.age= 30;
		cersei.kingdom= lann;
		cersei.work= true;
		cersei.house= "HouseA";
		cersei.worplace= "PalaceA";
		cersei.Skill= "Defense";
		
	
		
		
		
		
	}

}
