package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/** A Jatekgep random időközönként megijeszti a szomszédos mezőkön lévő
 * lévő Ijedos pandákat.
 */
public class Jatekgep extends Dolog implements ITickable {

	/** Random időközönként megijeszti a szomszédos mezőkön lévő
	 * lévő Ijedos pandákat, ha vannak.
	 */
	public void tick() {
		Skeleton.print(this,"tick");
		
		Csempe sajatCsempe = getCsempe();
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		ArrayList<Csempe> szomszedCsempek = sajatCsempe.getAllNeighbours();
		for(Csempe c : szomszedCsempek)
			c.getDolog().hitBy(this);
		
		Skeleton.ret();
	}
}
