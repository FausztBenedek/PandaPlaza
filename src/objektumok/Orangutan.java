package objektumok;

/** 
 * Egy orangutánt reprezentál
 * */
public class Orangutan extends Allat {
	/** 
	 * Lépteti a megadott irányba az orangutánt
	 * */
	public void Leptet(int irany) {
		// Lekéri az adott irányú szomszédos csempét
		Csempe cs = GetCsempe().GetNeigbour(irany);
		
		//Megpróbálja az adott irányú csempére léptetni az orangutánt, ha létezik ilyen irányú szomszéd
		if(cs !=null)
			Leptet(cs);
	}
	
	/** 
	 * Megöli az orángutánt: leveszi az orangutánt a pályáról, elengedi a mögötte lévő mancsát, és csökkenti a hátralévő orángutánok számát
	 * */
	public void Die() {
		// Leveszi a pályáról, elengedi a szomszédjai mancsát
		super.Die();
		
		// Csökkenti a hátralévő orangutánok számát
		game.OrangutanSzamCsokkent();
	}	
}
