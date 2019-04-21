package objektumok;

import java.util.ArrayList;

import protoApp.Proto;

/** A Jatekgep random időközönként megijeszti a szomszédos mezőkön lévő
 * lévő Ijedos pandákat.
 */
public class Jatekgep extends Dolog implements ITickable {

	@Override
	public String toString() {
		return "Jatekgep " + Proto.getObjectName(this) + " csempe:" + Proto.getObjectName(getCsempe());
	}
	
	
	
	/** Random időközönként megijeszti a szomszédos mezőkön lévő
	 * lévő Ijedos pandákat, ha vannak.
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
