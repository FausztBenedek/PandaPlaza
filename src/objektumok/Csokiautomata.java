package objektumok;

import java.util.ArrayList;

import skeletonApp.Proto;

/** A Csokiautomata ugratja a szomszédos mezőkön álló Ugros pandákat.
 */
public class Csokiautomata extends Dolog implements ITickable {	
	@Override
	public String toString() {
		return "Csokiautomata " + Proto.getObjectName(this) + " csempe:" + Proto.getObjectName(getCsempe());
	}
	
	/** Random időközönként ugratja a szomszédos csempéken
	 * lévő Ugros pandákat.
	 */
	public void tick() {
		
		Csempe sajatCsempe = getCsempe();
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		ArrayList<Csempe> szomszedCsempek = sajatCsempe.getAllNeighbours();
		for(Csempe c : szomszedCsempek) {
			Dolog d = c.getDolog();
			if(d!=null)
				d.hitBy(this);	
		}
					
	}
}