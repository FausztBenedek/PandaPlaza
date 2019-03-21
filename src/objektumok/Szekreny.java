package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/**
 * Egy olyan dolog, amivel ha egy állat ütközik, akkor elteleportálja
 * egy másik szekrényhez, de mindig ugyan oda.
 */
public class Szekreny extends Dolog {

	/**
	 * Mindig ennek a szekrénynek a szomszéd csempéinek valamelyikére
	 * teleportálja az állatot.
	 */
	private Szekreny masik;
	
	/**
	 * A teleportálási logikát megvalósító metódus.
	 * @param a - Az állat, akit a szekrény elteleportál.
	 */
	public void hitBy(Allat a) {
		Skeleton.print(this, "hitBy", a);
		
		Csempe masikSzekrenyCsempe = masik.getCsempe();
		
		// Referencia arra a csempére, ahova az állatot akarjuk léptetni
		Csempe target = null;
		
		// target(célcsempe) meghatározása: Ez a szekrény csempéjének egy üres szomszédja kell, hogy legyen
		ArrayList<Csempe> lehetsegesTargetek = masikSzekrenyCsempe.getAllNeighbours();
		for (Csempe c : lehetsegesTargetek) {
			// Ha a az éppen aktuális c csempe üres, akkor beállítjuk a targetet.
			if (c.getDolog() == null) {
				target = c;
				break;
			}
		}
		// Ha minden lehetséges csempe foglalt, akkor
		// ...
		if (target == null) {
			// TODO Ki kell találni, hogy ha a cél szekrényből nem lehet kilépni, mert minden csempe foglalt, akkor mi történik.
			// Ezt a skeletonhoz nem kell, mert egyetlen egy forgatókönyvet sem fogunk így inicializálni.
			// Ha ezt a részt egyszerűen kihagynánk, a kódból, 
			// az állat ott maradna, ahol éppen áll. (Az eredeti szekrény mellett.)
		}
		else {
			a.leptet(target);
		}
		
		Skeleton.ret();
	}
}
