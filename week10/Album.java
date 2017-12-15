package week10;
import java.util.Scanner;
import week9.Song;

public class Album {
	
	private String title;
	private int year;
	private Song [] songs;
	private double price;
	private Band band;
	
	//Set methods:
	public void setYear(int y){
		if (y<=2017 && y<= 1700){
			this.year = y;
		}
		else {
			this.year = 2010;
		}
	}
	
	public void setPrice(double p){
		if (p>0){
			this.price = p;
		}else{
			this.price = 1;
		}
	}
	
	public void setTitle(String t){
		this.title=t;
	}
	
	public void setSongs (int nS){
		Scanner sc = new Scanner (System.in);
		
		this.songs = new Song [nS];
		
		for (int i=0; i<nS; i++) {
			System.out.println("Enter song number " + (i+1) + "'s title");
			String songName = sc.next();
			System.out.println("Enter \"" + songName + "\"'s duration (in seconds)");
			int songDuration = sc.nextInt();
			
			songs[i] = new Song (songName, songDuration);
		}
		sc.close();	
	}
	
	public void setBand (Band b){
		this.band = b;
	}
	
	//Get methods:
	public String getAlbumTitle() {
		return this.title;
	}
	public double getPrice() {
		return this.price;
	}
	public int getAlbumYear() {
		return this.year;
	}
	public Song[] getSongs() {
		return this.songs;
	}
	
	
	//Constructor
	public Album (String t, int y, int nS, double p, Band b) {
		setYear(y);
		setPrice(p);
		setBand(b);
		setSongs(nS);
		setTitle(t);
				
		
	}
	
}

