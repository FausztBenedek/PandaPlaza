package objektumok;

import skeletonApp.Skeleton;

/** 
 * Egy orangutánt reprezentál
 * */
public class Orangutan extends Allat {

	@Override
	public String toString() {
		return "Orangutan " + Skeleton.getObjectName(this) + " csempe:" + Skeleton.getObjectName(getCsempe()) + 
				" elsoMancs:"+Skeleton.getObjectName(getElsoMancs()) + " hatsoMancs:"+ Skeleton.getObjectName(getHatsoMancs()) +
				" game:"+ Skeleton.getObjectName(game);
	}
		
	/** 
	 * Lépteti a megadott irányba az orangutánt
	 * */
	public void leptet(int irany) {
		// Lekéri az adott irányú szomszédos csempét
		Csempe cs = getCsempe().getNeigbour(irany);
		
		//Megpróbálja az adott irányú csempére léptetni az orangutánt, ha létezik ilyen irányú szomszéd
		if(cs !=null)
			leptet(cs);
	}
	
	/**
	 * Megpróbálja ráléptetni az adott csempére az orangutánt. Ha van ott 
	 * valami, meghívja rá a hitby függvényt.
	 * @param A csempe amelyikre léptetni akarjuk
	 */
	public void leptet(Csempe c) {
		// Lekéri a csempén lévő dolgot
		Dolog d = c.getDolog();
		
		//Ha üres a szomszédos mező, átlép rá, ha nem, ütközteti magát az ott levő dologgal.
		if(d==null) {
			c.accept(this);
		} else {
			d.hitBy(this);
		}
	}
	
	/** 
	 * Megöli az orángutánt: leveszi az orangutánt a pályáról, elengedi a mögötte lévő mancsát, és csökkenti a hátralévő orángutánok számát
	 * */
	@Override
	public void die() {
		// Leveszi a pályáról, elengedi a szomszédjai mancsát
		super.die();
		
		// Csökkenti a hátralévő orangutánok számát
		game.orangutanSzamCsokkent();
		game.setActiveOrangutan(null);
	}	
	
	@Override
	public void hitBy(Orangutan o) {
		// TODO Auto-generated method stub
		super.hitBy(o);
	}
}
