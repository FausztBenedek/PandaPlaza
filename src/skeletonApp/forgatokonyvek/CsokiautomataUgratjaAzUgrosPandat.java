package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.*;

public class CsokiautomataUgratjaAzUgrosPandat extends Forgatokonyv{

	@Override
	public String getLeiras() {
		return "Csokiautomata ugratja a szomszéd csempén álló ugrós pandát";
	}

	@Override
	public void action() {
		
		// Csempék létrehozása és regisztrálása
		Csempe csokiCsempe = new Csempe();
		Skeleton.addObjectName(csokiCsempe, "csokiCsempe");
		Csempe ugrosCsempe = new Csempe();
		Skeleton.addObjectName(ugrosCsempe, "ugrosCsempe");
		
		// csempék szomszédainak beállítása
		csokiCsempe.setNeighbour(1, ugrosCsempe);
		ugrosCsempe.setNeighbour(0, csokiCsempe);
		
		// Dolgok létrehozása és regisztrálása
		Ugros u = new Ugros();
		Skeleton.addObjectName(u, "ugros1");
		Csokiautomata cs = new Csokiautomata();
		Skeleton.addObjectName(cs, "csoki1");
		
		// Dolgok csempékre rakása
		csokiCsempe.setDolog(cs);
		cs.setCsempe(csokiCsempe);
		ugrosCsempe.accept(u);
		
		// Forgatókönyvkiírások elindítása
		Skeleton.startForgatokonyv();
		cs.tick();
		// Forgatókönyvkiírások befejezése
		Skeleton.finishForgatokonyv();
		
	}

}
