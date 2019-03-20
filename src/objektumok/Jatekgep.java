package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/** A Jatekgep random időközönként megijeszti a szomszédos mezőkön lévő
 * lévő Ijedos pandákat.
 */
public class Jatekgep extends Dolog implements ITickable {
	
	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
//	public Jatekgep(Csempe startPos) {
//		super(startPos);
//	}
	
	/** Random időközönként megijeszti a szomszédos mezőkön lévő
	 * lévő Ijedos pandákat, ha vannak.
	 */
	@Override
	public void tick() {
		Skeleton.print(this,"tick");
		
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
