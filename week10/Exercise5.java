package week10;
import java.util.Scanner;
/**
 * A song has a title and certain duration. An album has also a title, a releasing year, a set of songs,
a sales price and belongs to a band. The author of a song is a person, having a name and a birth
year. A band has a name, a creation year and some members, which are persons.
Create classes to represent the former concepts. All the fields must be private. Include set and
get methods and full constructors as needed, checking the values of the parameters if
necessary.
In a main class ask the user to enter the details of an album, including the number of songs, the
songs, the band members, etc. 
 * @author Antonio Viñuela Pérez
 * @author Ignacio Velasco Delgado
 *
 */
public class Exercise5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		sc.useDelimiter(System.getProperty("line.separator"));
	
	////////////// V A R I A B L E S ////////////////////
		String albumName;
		double price;
		int albumYear;
		String bandName;
		int bandYear;
		int nM;  // number of members of the band
		String personName;
		int personYear;  
		int nS;  //number of songs in the album
		String songName;
		int songDuration;
		
		Band band;
		Album album;
	/////////////////////////////////////////////////////
		
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
		
		band = new Band (bandName, bandYear, nM);
		
		System.out.println("Enter number of songs in the album");
		nS = Integer.parseInt(sc.next());
		
		album = new Album (albumName,albumYear, nS, price, band);
	
		
		//Printing final result:
		System.out.println();
		System.out.println("Album: " + album.getAlbumTitle() + " (" + album.getAlbumYear() + ") " + album.getPrice() + "€");
		System.out.println("By: " + band.getName() + " (" + band.getBandYear() + "):");
		
		for (int i=0; i<nM; i++) {
			System.out.println("    " + band.getMembers()[i].name + " (" + band.getMembers()[i].year +")");
			}
		
		System.out.println("Songs:");
		for (int i=0; i<nS; i++) {
			System.out.println((i+1)+ ": "+ album.getSongs()[i].title + " (" + album.getSongs()[i].duration + " seconds)");
		}

		sc.close();
	}

}
