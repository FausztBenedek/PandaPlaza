package objektumok;

import skeletonApp.Skeleton;

/** A Jatekgep random időközönként megijeszti a szomszédos mezőkön lévő
 * lévő Ijedos pandákat.
 */
public class Jatekgep extends Dolog implements ITickable {
	
	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
	public Jatekgep(Csempe startPos) {
		super(startPos);
	}
	
	/** Random időközönként megijeszti a szomszédos mezőkön lévő
	 * lévő Ijedos pandákat, ha vannak.
	 */
	@Override
	public void tick() {
		Skeleton.print("Jatekgep.tick()");
		
		Csempe pos = getCsempe();
		
		// Mindegyik szomszédon lévő dologgal ütköztetjük.
		int[] iranyok = pos.getIranyok();
		for (int i = 0; i < iranyok.length; i++) {
			Csempe szomszed = pos.getNeigbour(iranyok[i]);
			Dolog other = szomszed.getDolog();
			other.hitBy(this);
		}
		Skeleton.ret();
	}
}
