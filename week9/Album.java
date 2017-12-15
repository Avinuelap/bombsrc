package week9;

public class Album {
	public String title;
	public int year;
	public Song [] songs;
	public double price;
	public Band band;
	
	public Album (String t, int y, Song [] s, double p, Band b) {
		title = t;
		year = y;
		songs = s;
		price = p;
		band = b;
	}
}
