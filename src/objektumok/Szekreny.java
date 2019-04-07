package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/**
 * Egy olyan dolog, amivel ha egy állat ütközik, akkor elteleportálja
 * egy másik szekrényhez, de mindig ugyan oda.
 */
public class Szekreny extends Dolog {
	@Override
	public String toString() {
		return "Szekreny " + Skeleton.getObjectName(this) + " csempe:" + Skeleton.getObjectName(getCsempe()) +
				" masik:"+Skeleton.getObjectName(masik);
	}	
	

	/**
	 * Mindig ennek a szekrénynek a szomszéd csempéinek valamelyikére
	 * teleportálja az állatot.
	 */
	private Szekreny masik;
	
	/**
	 * Beállítja, hogy a szekrény hova teleportálja az állatokat.
	 * @param masik - Ide fogja az állatokat teleportálni a szekrény.
	 */
	public void setMasik(Szekreny masik) {
		this.masik = masik;
	}
	
	/**
	 * A teleportálási logikát megvalósító metódus.
	 * @param a - Az állat, akit a szekrény elteleportál.
	 */
	@Override
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
			// Ha a szekrény túloldalán nincs szabad hely, akkor a szekrényre lépő állat helyben marad.
		}
		else {
			a.leptet(target);
		}
		
		Skeleton.ret();
	}
}
