package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.*;

public class OrangutanNekimegyPandanak extends Forgatokonyv {
		
	public String getLeiras() {
		return "Egy pandát húzó orangután nekimegy egy szabadon kószáló pandának";
	}
	
	public void action() {
		Csempe c0 = new Csempe();
		Skeleton.addObjectName(c0, "csempe0");
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		Csempe c2 = new Csempe();
		Skeleton.addObjectName(c2, "csempe2");
		
		c1.setNeighbour(2, c2);
		c2.setNeighbour(0, c1);	
		
		c0.setNeighbour(2, c1);
		c1.setNeighbour(0, c0);
		
		Orangutan o = new Orangutan();
		Skeleton.addObjectName(o, "orangutan1");
		o.setCsempe(c1);
		c1.setDolog(o);
		
		Ugros u1 = new Ugros();
		Skeleton.addObjectName(u1, "ugros1");
		u1.setCsempe(c2);
		c2.setDolog(u1);
		
		Ugros u2 = new Ugros();
		Skeleton.addObjectName(u2, "ugros2");
		u2.setCsempe(c0);
		c0.setDolog(u2);
		
		
		// TODO csak próba
		Game g  = new Game();
		u2.setGame(g);
		u2.die();
		//próba vége
		
		Skeleton.startForgatokonyv();
		o.leptet(2);
		Skeleton.finishForgatokonyv();
		
	}

}
