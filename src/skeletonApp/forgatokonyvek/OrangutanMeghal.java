package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class OrangutanMeghal extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Orangutan meghal";
	}

	@Override
	public void action() {
		Orangutan o = new Orangutan();
		Skeleton.addObjectName(o, "orangutan1");
		
		Game g = new Game();
		Skeleton.addObjectName(g, "game");
		
		o.setGame(g);
		
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		c1.accept(o);
		
		Skeleton.startForgatokonyv();
		o.die();
		Skeleton.finishForgatokonyv();		
	}

}
