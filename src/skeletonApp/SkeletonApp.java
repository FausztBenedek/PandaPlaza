package skeletonApp;
import java.util.Scanner;
import objektumok.*;
import skeletonApp.*;


public class SkeletonApp {
	
	/**
	 * Egy lista, amelyben az összes forgatókönyv megtalálható, 
	 * amelyet a felhasználó lefuttathat.
	 */
	public static Scanner sc = new Scanner(System.in);

	/**
	 * A skeleton app belépési pontja.
	 * @param args - Nincs most ilyen
	 */
	public static void main(String[] args) {	
	/*	Orangutan o = new Orangutan();
		Skeleton.addObject(o, "orangutan1");		
		Csempe cs = new Csempe();
		Skeleton.addObject(cs, "csempe1");		
		cs.accept(o);		
		Csempe cs2 = new Csempe();
		Skeleton.addObject(cs2, "csempe2");
		cs.setNeighbour(0,cs2);
		cs2.setNeighbour(3,cs);
		Game g = new Game();
		Skeleton.addObject(g, "game1");
		o.setGame(g);		
		Skeleton.proto_print();
		*/
		/*Skeleton.load("palya1.txt");
		Skeleton.proto_print();		*/
		System.out.println("Parancs?");
		String userInput = "";
		do {
			if(sc.hasNextLine()) {		
				userInput = sc.nextLine();
			}	
			if(!userInput.equals("")) {
				Skeleton.command(userInput);
			}
		} while(!userInput.equals(""));
		System.out.println("Kilépés...");
		sc.close();
	}
}
