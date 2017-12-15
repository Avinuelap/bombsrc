package objects;
/**
 * This represents a kingdom in Game of Thrones
 * @author l070j218
 *
 */
public class Kingdom {

		public String name;
		public String motto;
		public int maxBuildings;
		public int maxPopulation;
		public int currPopulation;
		public int currBuildings;

	public Kingdom (String n, String m, int mB, int mP, int cP, int cB){
		name = n;
		motto = m;
		maxBuildings= mB;
		maxPopulation= mP;
		currPopulation= cP;
		currBuildings= cB;
	}
	}


