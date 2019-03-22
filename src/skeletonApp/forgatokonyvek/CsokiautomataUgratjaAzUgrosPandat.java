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
		Csempe csokiCsempe = new Csempe();
		Skeleton.addObjectName(csokiCsempe, "csokiCsempe");
		Csempe ugrosCsempe = new Csempe();
		Skeleton.addObjectName(ugrosCsempe, "ugrosCsempe");
		csokiCsempe.setNeighbour(1, ugrosCsempe);
		ugrosCsempe.setNeighbour(0, csokiCsempe);
		
		Ugros u = new Ugros();
		Skeleton.addObjectName(u, "ugros1");
		Csokiautomata cs = new Csokiautomata();
		Skeleton.addObjectName(cs, "csoki1");
		csokiCsempe.accept(cs);
		ugrosCsempe.accept(u);
		
		Skeleton.startForgatokonyv();
		cs.tick();
		Skeleton.finishForgatokonyv();
		
	}

}
