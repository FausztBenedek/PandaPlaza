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
		
		Csempe sajatCsempe = getCsempe();
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		ArrayList<Csempe> szomszedCsempek = sajatCsempe.getAllNeighbours();
		for(Csempe c : szomszedCsempek)
			c.getDolog().hitBy(this);		
		Skeleton.ret();
	}
}