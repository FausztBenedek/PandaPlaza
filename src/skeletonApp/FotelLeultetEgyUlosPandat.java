package skeletonApp;

import objektumok.*;

public class FotelLeultetEgyUlosPandat implements Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Fotel leültet egy Ulos pandát";
	}

	/**
	 * Inicializálja azt a jelenetet, hogy egy 
	 * fotel leültet egy pandát.
	 */
	@Override
	public void action() {
		// A két csempe példányosítása:
		Csempe fotelPos = new Csempe();
		Csempe pandaPos = new Csempe();
		// A két csempe összekötése:
		fotelPos.setNeighbour(0, pandaPos);
		pandaPos.setNeighbour(0, fotelPos);
		
		// Fotel, amelyik 5 ticken át tartja ott a pandát.
		// És a 0 irányú szomszédra teszi ki.
		Fotel f = new Fotel(fotelPos);
		
		Ulos u = new Ulos(pandaPos);
		
		// És végül a trigger
		f.tick();
	}

}
