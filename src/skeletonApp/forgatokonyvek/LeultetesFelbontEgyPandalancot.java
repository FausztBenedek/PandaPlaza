package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class LeultetesFelbontEgyPandalancot extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Leültetés felbont egy pandaláncot";
	}

	@Override
	public void action() {
		// Objektumok létrehozása és regisztrálása
		Fotel f = new Fotel();
		Skeleton.addObjectName(f, "fotel1");
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		Ijedos i1 = new Ijedos();
		Skeleton.addObjectName(i1, "ijedos1");
		Ijedos i2 = new Ijedos();
		Skeleton.addObjectName(i2, "ijedos2");		
		Ijedos i3 = new Ijedos();
		Skeleton.addObjectName(i3, "ijedos3");
		
		// Állatok mancsainak összekötése
		u.setHatsoMancs(i1);
		i1.setElsoMancs(u);
		i1.setHatsoMancs(i2);
		i2.setElsoMancs(i1);
		i2.setHatsoMancs(i3);
		i3.setElsoMancs(i2);
		
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		c1.accept(u);
				
		// Forgatókönyvkiírások elindítása
		Skeleton.startForgatokonyv();
		u.hitBy(f);
		// Forgatókönyvkiírások befejezése
		Skeleton.finishForgatokonyv();
	}
}
