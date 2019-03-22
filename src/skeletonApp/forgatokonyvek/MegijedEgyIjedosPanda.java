package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class MegijedEgyIjedosPanda extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Megijed egy ijedős panda";
	}

	@Override
	public void action() {
		Csempe jatekCsempe = new Csempe();
		Skeleton.addObjectName(jatekCsempe, "jatekCsempe");
		Csempe ijedosCsempe = new Csempe();
		Skeleton.addObjectName(ijedosCsempe, "ijedosCsempe");
		Csempe ulosCsempe = new Csempe();
		Skeleton.addObjectName(ulosCsempe, "ulosCsempe");
		jatekCsempe.setNeighbour(1, ijedosCsempe);
		ijedosCsempe.setNeighbour(0, jatekCsempe);
		
		ijedosCsempe.setNeighbour(1, ulosCsempe);
		ulosCsempe.setNeighbour(0, ijedosCsempe);
		
		Ijedos i = new Ijedos();
		Skeleton.addObjectName(i, "ijedos1");
		Jatekgep j = new Jatekgep();
		Skeleton.addObjectName(j, "jatekgep1");
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		
		i.setHatsoMancs(u);
		u.setElsoMancs(i);
		
		jatekCsempe.setDolog(j);
		j.setCsempe(jatekCsempe);
		ijedosCsempe.accept(i);
		ulosCsempe.accept(u);
		
		Skeleton.startForgatokonyv();
		j.tick();
		Skeleton.finishForgatokonyv();		
	}
}
