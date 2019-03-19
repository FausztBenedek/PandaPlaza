package objektumok;

import java.util.ArrayList;

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
