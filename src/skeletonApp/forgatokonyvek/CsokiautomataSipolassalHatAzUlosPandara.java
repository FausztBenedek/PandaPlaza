package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class CsokiautomataSipolassalHatAzUlosPandara extends Forgatokonyv{

	@Override
	public String getLeiras() {
		return "Csokiautomata sípolással hat az ülős pandára";
	}

	@Override
	public void action() {
		Csempe csokiCsempe = new Csempe();
		Skeleton.addObjectName(csokiCsempe, "csokiCsempe");
		Csempe ulosCsempe = new Csempe();
		Skeleton.addObjectName(ulosCsempe, "ulosCsempe");
		csokiCsempe.setNeighbour(1, ulosCsempe);
		ulosCsempe.setNeighbour(0, csokiCsempe);
		
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		Csokiautomata cs = new Csokiautomata();
		Skeleton.addObjectName(cs, "csoki1");
		csokiCsempe.setDolog(cs);
		cs.setCsempe(csokiCsempe);
		ulosCsempe.accept(u);
		
		Skeleton.startForgatokonyv();
		cs.tick();
		Skeleton.finishForgatokonyv();
		
	}

}
