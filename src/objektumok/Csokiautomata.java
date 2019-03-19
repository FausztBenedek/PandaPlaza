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
		
		Csempe pos = getCsempe();
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		int[] iranyok = pos.getIranyok();
		for (int i = 0; i < iranyok.length; i++) {
			Csempe szomszed = pos.GetNeigbour(iranyok[i]);
			Dolog other = szomszed.GetDolog();
			other.hitBy(this);
		}
	}
}