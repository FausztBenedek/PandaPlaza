package objektumok;

import skeletonApp.Skeleton;

/** 
 * Egy orangutánt reprezentál
 * */
public class Orangutan extends Allat {

	/** 
	 * Lépteti a megadott irányba az orangutánt
	 * */
	public void leptet(int irany) {
		Skeleton.print(this, "leptet", irany);
		// Lekéri az adott irányú szomszédos csempét
		Csempe cs = getCsempe().getNeigbour(irany);
		
		//Megpróbálja az adott irányú csempére léptetni az orangutánt, ha létezik ilyen irányú szomszéd
		if(cs !=null)
			leptet(cs);
	}
	
	/** 
	 * Megöli az orángutánt: leveszi az orangutánt a pályáról, elengedi a mögötte lévő mancsát, és csökkenti a hátralévő orángutánok számát
	 * */
	public void die() {
		Skeleton.print(this, "die");
		// Leveszi a pályáról, elengedi a szomszédjai mancsát
		super.die();
		
		// Csökkenti a hátralévő orangutánok számát
		game.OrangutanSzamCsokkent();
		Skeleton.ret();
	}	
}
