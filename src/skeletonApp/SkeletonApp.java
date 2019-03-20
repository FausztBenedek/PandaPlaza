package skeletonApp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SkeletonApp {
	
	/**
	 * Egy lista, amelyben az összes forgatókönyv megtalálható, 
	 * amelyet a felhasználó lefuttathat.
	 */
	private static Forgatokonyv[] forgatokonyvek = {	
		new FotelLeultetEgyUlosPandat(),
		new OrangutanNekimegyPandanak()
	};
	
	/**
	 * A skeleton app belépési pontja.
	 * @param args - Nincs most ilyen
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Ameddig valid inputot kapunk, addig fut a program
		while (true) {
			
			// Kiírjuk a lehetőségeket
			System.out.println("A lehetséges forgatókönyvek:");
			for (int i = 0; i < forgatokonyvek.length; i++) {
				
				// Sorszámok kiírása (indextől eggyel nagyobb)
				System.out.print('\t');
				System.out.print(i + 1);
				System.out.print('.');
			
				// A forgatókönyv leírásának kiírása
				String leiras = forgatokonyvek[i].getLeiras();
				System.out.println(leiras);
			}
			
			// Elkérjük az inputot a felhasználótól, és megállítjuk a programot, ha rosszat ad.
			System.out.println("Melyik forgatókönyvet választod? Add meg a számát! Kilépéshez bármi mást!");
			int userInput;
			try {
				userInput = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Kilépés");
				break;
			}
			
			// A szükséges logika végrehajtása, ha tartozik hozzá sorszám.
			try {
				forgatokonyvek[userInput - 1].action();
				
				// Elválasztáshoz egy üres sort beszúrunk
				System.out.println("");
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Ezt a számot nem választhatod, kilépés...");
				break;
			}
		}
	}
}
