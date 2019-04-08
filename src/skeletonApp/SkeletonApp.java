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
