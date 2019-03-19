package objektumok;

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
