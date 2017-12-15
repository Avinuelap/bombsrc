package week9;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner (System.in);
		sc.useDelimiter(System.getProperty("line.separator"));
		
		/////// V A R I A B L E S //////////////
		String albumName;
		double price;
		int albumYear;
		String bandName;
		int bandYear;
		int nM;  // number of members of the band
		Person[] members;
		String personName;
		int personYear;  
		int nS;  //number of songs in the album
		Song[] songs;
		String songName;
		int songDuration;
		////////////////////////////////////////
		
		//Asking for all data needed
		System.out.println("Enter name of the album");
		albumName = sc.next();
		
		System.out.println("Enter price of the album");
		price = sc.nextDouble();
		
		System.out.println("Enter release year of the album");
		albumYear = sc.nextInt();
		
		System.out.println("Enter album's band/author's name");
		bandName = sc.next();
		
		System.out.println("Enter band/author's starting year");
		bandYear = sc.nextInt();
		
		System.out.println("Enter number of members of the band. If solo author, enter 1");
		nM = sc.nextInt();
		
		members = new Person [nM];
		for (int i=0; i<nM; i++) {
			System.out.println("Enter name of band's member number " + (i+1));
			personName = sc.next();		
			System.out.println("Enter " + personName+ "'s year of birth");
			personYear = sc.nextInt();
			
			members[i] = new Person (personName, personYear);			
		}
		
		System.out.println("Enter number of songs in the album");
		nS = sc.nextInt();
		
		songs = new Song [nS];
		for (int i=0; i<nS; i++) {			
			System.out.println("Enter song number " + (i+1) + "'s title");
			songName = sc.next();
			System.out.println("Enter \"" + songName + "\"'s duration (in seconds)");
			songDuration = sc.nextInt();
			
			songs[i] = new Song (songName, songDuration);
		}
		
		Band band = new Band (bandName, bandYear, members);
		Album album = new Album (albumName, albumYear, songs, price, band);
		
		
		
		//PRINTING FINAL OUTPUT:		
		System.out.println();
		System.out.println("Album: " + album.title + " (" + album.year + ") " + album.price + "€");
		System.out.println("By: " + band.name + " (" + band.year + ")");
		
		for (int i=0; i<nM; i++) {
		System.out.println("    " + members[i].name + " (" + members[i].year +")");
		}
		
		System.out.println("Songs:");
		for (int i=0; i<nS; i++) {
			System.out.println((i+1)+ ": "+ songs[i].title + " (" + songs[i].duration + " seconds)");
		}
		
		
					
		sc.close();
	}

}
