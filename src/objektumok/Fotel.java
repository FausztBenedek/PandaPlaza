package objektumok;

import java.util.ArrayList;

/**
 * A Fotel a szomszédos mezőn lévő Ulos pandákat leülteti,
 * és ott tartja egy ideig.
 */
public class Fotel extends Dolog implements ITickable {
	
	/**
	 * Konstruktor. Megadja, hogy a Fotel melyik csempén helyezkedik el,
	 * illetve, hogy hány Tick-en át tartja az Ulos pandát ülve, valamint
	 * az irányt, ahova a panda feláll.
	 * @param c - A kezdőcsempe.
	 * @param pandatTart - Ennyi Tick-en át marad a panda ülve a fotelben.
	 * @param felallasIrany - Ebben az irányban áll fel a panda.
	 */
	public Fotel(Csempe c, int pandatTart, int felallasIrany) {
		super(c);
		this.counterMax = pandatTart;
		this.felallasIrany = felallasIrany;
	}
	
	/**
	 * Referencia a fotelban ülő pandára. Ha a fotel üres, akkor null.
	 */
	private Ulos panda;
	
	/**
	 * Számláló.
	 * Inkrementálódik, ha egy panda ül a fotelben,
	 * Ha eléri a maximumot, akkor a panda feláll.
	 */
	private int counter = 0;
	
	/**
	 * Ha a counter eléri ezt az értéket, akkor a panda feláll
	 * a Fotel-ből, és tovább megy.
	 */
	private int counterMax;
	
	/**
	 * Ebben az irányban lévő csempére áll fel a panda.
	 */
	private int felallasIrany;
	
	/**
	 * Két feladata van:
	 * 1. A szomszédos mezőkön lévő Ulos pandákat leülteti, ha vannak.
	 * 2. Ha letelt az idő felállítja a pandát a helyéről.
	 */
	public void Tick() {
		// 1. feladat: A szomszédos mezőkön lévő Ulos pandákat
		// leülteti, ha vannak.
		{
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
		
		// 2. feladat: Ha letelt az idő felállítja a pandát a helyéről.
		{
			// Panda felállítására várakozás
			if (panda != null) {
				// Inkrementáljuk a countert, és ha elérte a maxot...
				if (counter++ < counterMax) {
					// Még várunk, mert még nem érte el.
				}
				else {
					// A pandát fel kell állítani 
					// vagyis (a target Csempe-re kell rakni)
					Csempe pos = this.getCsempe();
					Csempe target = pos.GetNeigbour(felallasIrany);
					
					// Ezt csak akkor teszzük meg, ha a target-en
					// nincs senki.
					if (target.GetDolog() == null) {
						target.SetDolog(panda);
						this.panda = null;
						counter = 0;
					}
					else {
						// A panda marad még egy kört, ameddig
						// a target csempe nem lesz üres.
					}
				}
			}
		}
	}
	
	/**
	 * Leülteti az Ulos pandát a fotelba, ha az üres. Ha már
	 * ül valaki a fotelban, azt a visszatérési értékben jelzi.
	 * @param u - Az Ulos panda, akit leültetünk a Fotel-ba
	 * @return - False, ha a fotelban már ül egy panada. True, 
	 * ha üres a fotel. Csak True esetén történik változás.
	 */
	public boolean setPanda(Ulos u) {
		if (panda != null) return false;
		this.panda = u;
		return true;
	}
}
