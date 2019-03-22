package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class PandaKivezetes extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Panda kivezetése";
	}

	@Override
	public void action() {
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		Csempe c2 = new Csempe();
		Skeleton.addObjectName(c2, "csempe2");
		Csempe c3 = new Csempe();
		Skeleton.addObjectName(c3, "csempe3");
		Csempe c4 = new Csempe();
		Skeleton.addObjectName(c4, "csempe4");
		Csempe c5 = new Csempe();
		Skeleton.addObjectName(c5, "csempe5");
		
		Ulos u = new Ulos();
		Skeleton.addObjectName(u, "ulos1");
		Orangutan o = new Orangutan();
		Skeleton.addObjectName(o, "orangutan1");
		Kijarat k = new Kijarat();
		Skeleton.addObjectName(k, "kijarat1");
		Bejarat b = new Bejarat();
		Skeleton.addObjectName(b, "bejarat1");
		Game g = new Game();
		Skeleton.addObjectName(g, "game");
		
		c1.accept(u);
		c2.accept(o);
		c3.setDolog(k);
		k.setCsempe(c3);
		c4.setDolog(b);
		b.setCsempe(c4);
		
		c2.setNeighbour(3, c3);
		c3.setNeighbour(3, c2);		
		c4.setNeighbour(0, c5);
		c5.setNeighbour(0, c3);
		
		
		Skeleton.startForgatokonyv();
		o.leptet(3);
		Skeleton.finishForgatokonyv();
	}

}
