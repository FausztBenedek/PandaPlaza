package skeletonApp.forgatokonyvek;

import java.util.Scanner;

import objektumok.*;
import skeletonApp.*;

public class FotelFelallitEgyUlosPandat extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Fotel felállít egy ülős pandát";
	}

	@Override
	public void action() {	
		// Objektumok létrehozása és regisztrálása
		Fotel f = new Fotel();
		Skeleton.addObjectName(f,"fotel1");		
		Csempe cs1 = new Csempe();
		Skeleton.addObjectName(cs1, "csempe1");		
		Csempe fotelCsempe = new Csempe();
		Skeleton.addObjectName(fotelCsempe, "fotelCsempe");
		
		// Csempék szomszédainak beállítása
		cs1.setNeighbour(0, fotelCsempe);
		fotelCsempe.setNeighbour(0, cs1);
		
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		// Dolgok rárakása a csempékre
		cs1.accept(u);
		fotelCsempe.setDolog(f);
		f.setCsempe(fotelCsempe);
		
		f.tick();	// Beültetés
		// Várakoztatások, hogy a teszt úgy induljon, hogy a következő ticknél dobja ki a fotel
		f.tick();	
		f.tick();	
		f.tick();	
		f.tick();	
		// Forgatókönyvkiírások elindítása
		Skeleton.startForgatokonyv();			
		f.tick(); // Felállítás
		// Forgatókönyvkiírások befejezése
		Skeleton.finishForgatokonyv();
		
	}

}
