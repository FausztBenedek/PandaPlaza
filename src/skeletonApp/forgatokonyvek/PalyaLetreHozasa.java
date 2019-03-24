package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.*;

public class PalyaLetreHozasa extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Palya létrehozása";
	}

	@Override
	public void action() {
		// Csempék létrehozása, regisztrálása
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		
		Csempe c2 = new Csempe();
		Skeleton.addObjectName(c2, "csempe2");
		
		// Játék létrehozása, regisztrálása
		Game g = new Game();		
		Skeleton.addObjectName(g, "game");
		
		// Orangután létrehozása, regisztrálása
		Orangutan o = new Orangutan();
		Skeleton.addObjectName(o, "orangutan");
		// Skeleton kiírások indítása
		Skeleton.startForgatokonyv();
		g.addCsempe(c1);
		g.addCsempe(c2);
		g.addDolog(o);
		g.csempeOsszekot(c1, 1, c2, 4);
		g.setActiveOrangutan(o);
		g.startGame();
		// Skeleton kiírások leállítása
		Skeleton.finishForgatokonyv();
		
	}

}
