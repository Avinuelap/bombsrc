package objects; 
public class Building {
	public String name;
	public String description;
	public int users;
	public int vacancies;
	public Kingdom kingdom;
	public String type;

	public Building (String n, String d, int u, int v, Kingdom k, String t){
		name = n;
		description = d;
		users = u;
		vacancies = v;
		kingdom = k;
		type = t;
	}
}
