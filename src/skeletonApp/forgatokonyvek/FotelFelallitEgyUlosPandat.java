package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.*;

public class FotelFelallitEgyUlosPandat extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Fotel felállít egy ülős pandát";
	}

	@Override
	public void action() {
		Fotel f = new Fotel();
		Skeleton.addObjectName(f,"fotel1");
		
		Csempe cs1 = new Csempe();
		Skeleton.addObjectName(cs1, "csempe1");
		
		Csempe fotelCsempe = new Csempe();
		Skeleton.addObjectName(fotelCsempe, "fotelCsempe");
		
		cs1.setNeighbour(0, fotelCsempe);
		fotelCsempe.setNeighbour(0, cs1);
		
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		
		cs1.accept(u);
		fotelCsempe.setDolog(f);
		f.setCsempe(fotelCsempe);
		
		f.tick();	// Beültetés
		f.tick();	// Várakoztatások..
		f.tick();	
		f.tick();	
		f.tick();	
		
		Skeleton.startForgatokonyv();			
		f.tick(); // Felállítás
		Skeleton.finishForgatokonyv();
		
	}

}
