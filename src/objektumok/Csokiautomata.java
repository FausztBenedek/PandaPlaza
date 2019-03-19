package objektumok;
package objektumok;

import java.util.ArrayList;
import java.util.Random;

/** A Csokiautomata ugratja a szomszédos mezőkön álló Ugros pandákat.
 */
public class Csokiautomata extends Dolog implements ITickable {

	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
	public Csokiautomata(Csempe c) {
		super(c);
	}
	
	/** Random időközönként ugratja a szomszédos csempéken
	 * lévő Ugros pandákat.
	 */
	public void Tick() {
		
		// Szomszédok összegyűjtése
		Csempe cs = getCsempe();
		ArrayList<Csempe> szomszedok = new ArrayList<Csempe>();
		for(int i = 0; i < 100; i++) { //TODO
			if(cs.GetNeigbour(i)!=null)
				szomszedok.add(cs.GetNeigbour(i));
		}
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		for (Csempe szomszed : szomszedok) {
			Dolog other = szomszed.GetDolog();
			other.hitBy(this);
		}
	}
}