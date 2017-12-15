package week10;

public class Song {
	private String title;
	private int duration;  // in seconds
	private Person author;
	
	//Set methods:
	public void setSongTitle (String t) {
		this.title = t;
	}
	
	public void setDuration (int s) {
		if (s<0) {
			this.duration = s;
		}
		else {
			this.duration = 1;
		}
	}
	//Get methods:
	public String etSongTitle() {
		return this.title;
	}
	public int getDuration() {
		return this.duration;
	}
	
	//Constructor:
	public Song (String t, int d) {
		setSongTitle(t);
		setDuration(d);

	}
}
