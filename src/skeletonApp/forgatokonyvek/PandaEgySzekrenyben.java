package skeletonApp.forgatokonyvek;

import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;
import objektumok.*;

public class PandaEgySzekrenyben extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Panda teleportál az egyik szekrényből egy másikba";
	}

	@Override
	public void action() {

		// Az állat, aki lépni fog
		Ugros szereplo = new Ugros();
		Skeleton.addObjectName(szereplo, "teleportaloAllat");
				
		// Szekrények:
		// Eredeti szekrény
		Szekreny szekreny1 = new Szekreny();
		Skeleton.addObjectName(szekreny1, "eredetiSzekreny");
		// Másik szekrény
		Szekreny szekreny2 = new Szekreny();
		Skeleton.addObjectName(szekreny2, "masikSzekreny");
		// Szekrények összekötése (csak a szükséges irányban)
		szekreny1.setMasik(szekreny2);
		
		// Csempék:
		// Eredeti szekrény csempéje
		Csempe cSzekreny1 = new Csempe();
		Skeleton.addObjectName(cSzekreny1, "eredetiSzekrenyCsempeje");		
		// Másik szekreny csempeje
		Csempe cSzekreny2 = new Csempe();
		Skeleton.addObjectName(cSzekreny2, "masikSzekrenyCsempeje");
		
		// Szekrenyeket rakjuk a csempékre:
		cSzekreny1.accept(szekreny1);
		cSzekreny2.accept(szekreny2);
		
		// Csempe, ahova az állat fog érkezni
		Csempe target = new Csempe();
		Skeleton.addObjectName(target, "célcsempe");
		
		// Szükséges összeköttetések (target <--> cSzekreny2)
		target.setNeighbour(0, cSzekreny2);
		cSzekreny2.setNeighbour(0, target);
		
		// És a trigger
		Skeleton.startForgatokonyv();
		szereplo.leptet(cSzekreny1);
		Skeleton.finishForgatokonyv();
	
	}

}
