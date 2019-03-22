package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.*;

public class FotelLeultetEgyUlosPandat extends Forgatokonyv {

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
		Skeleton.addObjectName(fotelPos, "fotelCsempe");
		
		Csempe pandaPos = new Csempe();
		Skeleton.addObjectName(pandaPos, "pandaCsempe");
		// A két csempe összekötése:
		fotelPos.setNeighbour(0, pandaPos);
		pandaPos.setNeighbour(0, fotelPos);
		
		// Fotel, amelyik 5 ticken át tartja ott a pandát.
		// És a 0 irányú szomszédra teszi ki.
		Fotel f = new Fotel();
		Skeleton.addObjectName(f, "fotel1");
		fotelPos.accept(f);
		
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		pandaPos.accept(u);	
		
		// És végül a trigger
		Skeleton.startForgatokonyv();
		f.tick();
		Skeleton.finishForgatokonyv();
	}
}
