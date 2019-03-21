package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/** A Csokiautomata ugratja a szomszédos mezőkön álló Ugros pandákat.
 */
public class Csokiautomata extends Dolog implements ITickable {	
	/** Random időközönként ugratja a szomszédos csempéken
	 * lévő Ugros pandákat.
	 */
	public void tick() {
		Skeleton.print(this, "tick");
		
		Csempe pos = getCsempe();
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		ArrayList<Integer> iranyok = pos.getIranyok();
		for (int i = 0; i < iranyok.size(); i++) {
			Csempe szomszed = pos.getNeigbour(iranyok.get(i));
			Dolog other = szomszed.getDolog();
			other.hitBy(this);
		}
		Skeleton.ret();
	}
}