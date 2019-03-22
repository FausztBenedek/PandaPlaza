package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;

public class PandaMeghalACsempen extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Panda meghal a csempén";
	}

	@Override
	public void action() {
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		Torekenycsempe tor = new Torekenycsempe();
		Skeleton.addObjectName(tor, "torekenyCsempe");
		Ugros u = new Ugros();
		Skeleton.addObjectName(u, "ugros1");
		tor.accept(u);
		c1.accept(u);
		
		c1.setNeighbour(2, tor);
		tor.setNeighbour(0, c1);
		
		for(int i = 0; i < 6; i++)
			tor.ugrott(u); //TODO meghívni többször, hogy indításkor 1 élete legyen, attól függ hogy hány élettel indul
		Game g = new Game();;
		Skeleton.addObjectName(g, "game");
		u.setGame(g);
		
		Skeleton.startForgatokonyv();
		u.leptet();
		Skeleton.finishForgatokonyv();		
	}
}
