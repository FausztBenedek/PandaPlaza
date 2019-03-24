package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class JatekVege extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Jatek Vege";
	}

	@Override
	public void action() {
		// Állatok létrehozása és regisztrálása
		Orangutan o = new Orangutan();
		Skeleton.addObjectName(o, "orangutan1");
		Ugros u = new Ugros();
		Skeleton.addObjectName(u, "ugros1");
		// Állatok mancsainak összekötése
		o.setHatsoMancs(u);
		u.setElsoMancs(o);
		// Csempék létrehozása és regisztrálása
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		Csempe c2 = new Csempe();
		Skeleton.addObjectName(c2, "csempe2");
		c1.accept(o);
		c2.accept(u);		
		// Csempék összekötése
		c1.setNeighbour(0, c1);
		c2.setNeighbour(0,c1);
		
		Game g = new Game();
		Skeleton.addObjectName(g, "game");
		
		u.setGame(g);
		// Forgatókönyvkiírások elindítása
		Skeleton.startForgatokonyv();
		u.die();
		// Forgatókönyvkiírások befejezése
		Skeleton.finishForgatokonyv();
	}

}
