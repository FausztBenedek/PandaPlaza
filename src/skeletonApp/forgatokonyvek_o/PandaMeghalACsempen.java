package skeletonApp.forgatokonyvek;

import objektumok.*;
import skeletonApp.Forgatokonyv;
import skeletonApp.Skeleton;
import skeletonApp.SkeletonApp;


public class PandaMeghalACsempen extends Forgatokonyv {

	@Override
	public String getLeiras() {
		return "Panda meghal a csempén";
	}

	@Override
	public void action() {
		// Bekérés a tesztelőtől, hogy hány élete legyen a törékeny csmepének
		System.out.println("Hány élete legyen a törékeny csempének, amelyre éppen rá fog lépni egy panda?");
		System.out.println("(1 vagy kevesebb értéknél hal meg a panda)");
		// Beolvasás:
		int elet = SkeletonApp.sc.nextInt();
		// Objektumok létrehozása és regisztrálása
		Csempe c1 = new Csempe();
		Skeleton.addObjectName(c1, "csempe1");
		Torekenycsempe tor = new Torekenycsempe();
		tor.setElettartam(elet);
		Skeleton.addObjectName(tor, "torekenyCsempe");
		Ugros u = new Ugros();
		Skeleton.addObjectName(u, "ugros1");	
		Game g = new Game();;
		Skeleton.addObjectName(g, "game");
		u.setGame(g);
		// Panda rárakása a csempére
		c1.accept(u);
		// Csempék szomszédainak beállítása
		c1.setNeighbour(2, tor);
		tor.setNeighbour(0, c1);	
	
	
		// Forgatókönyvkiírások elindítása
		Skeleton.startForgatokonyv();
		u.leptet();
		// Forgatókönyvkiírások befejezése
		Skeleton.finishForgatokonyv();		
	}
}
