package objektumok;

import java.util.ArrayList;

import skeletonApp.Proto;

/**
 * A Fotel a szomszédos mezőn lévő Ulos pandákat leülteti,
 * és ott tartja egy ideig.
 */
public class Fotel extends Dolog implements ITickable {
	
	@Override
	public String toString() {
		return "Fotel " + Proto.getObjectName(this) + " csempe:" + Proto.getObjectName(getCsempe())+ " panda:"+Proto.getObjectName(panda) + " counter:" + counter;
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
	private final int counterMax = 5;
	
	/**
	 * Két feladata van:
	 * 1. A szomszédos mezőkön lévő Ulos pandákból egyet leültet, ha vannak,
	 * de csak akkor, ha nincs éppen aktuális panda, aki a fotelban ül.
	 * 2. Ha letelt az idő felállítja a pandát a helyéről, és egy szabadon lévő
	 * közeli csempére rakja.
	 */
	public void tick() {
		// 1. feladat: A szomszédos mezőkön lévő Ulos pandákból egyet leültet, ha vannak,
		// de csak akkor, ha nincs éppen aktuális panda, aki a fotelban ül.
		{
			// Check, hogy üres a fotel
			if (panda == null) {
				Csempe sajatCsempe = getCsempe();				
				// Mindegyik szomszédon lévő dologgal ütköztetjük.
				ArrayList<Csempe> szomszedCsempek = sajatCsempe.getAllNeighbours();
				for (int i = 0; i < szomszedCsempek.size(); i++) {
					Dolog d = szomszedCsempek.get(i).getDolog();
					if(d!=null)
						d.hitBy(this);					
					// Leállítjuk a loopot, ha leültettünk valakit
					if (this.panda != null) {
						break;
					}
				}
			}
		}
		
		// 2. feladat: Ha letelt az idő felállítja a pandát a helyéről, és egy szabadon lévő
		// közeli csempére rakja.
		{
			// Check, hogy van-e valaki a fotelban
			if (panda != null) {
				// Inkrementáljuk a countert, és ha elérte a maxot...
				if (counter++ < counterMax) {
					// Még várunk, mert még nem érte el.
				}
				else {
					// A pandát fel kell állítani 
					// vagyis (a target Csempére kell rakni)
					Csempe sajatCsempe = this.getCsempe();
					Csempe target;
					
					// Megnézzük, hogy van-e olyan szomszéd, ami üres
					// Ehhez lehet hogy az összes szomszédot meg kell nézni
					// Ez a for loop addig fut, ameddig nem talál egyet.
					ArrayList<Csempe> szomszedCsempek = sajatCsempe.getAllNeighbours();
					for (int i = 0; i < szomszedCsempek.size(); i++) {
						target = szomszedCsempek.get(i);
						
						// Ha a targeten nincsen senki, akkor odarakjuk
						// a pandát, vissza állítjuk a counter-t és készen vagyunk.
						if (target.getDolog() == null) {
							target.setDolog(panda);
							panda.setCsempe(target);
							this.panda = null;
							counter = 0;
							break;
						}
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
	public void setPanda(Ulos u) {
		this.panda = u;
	}
	
	public int getCounter() { //TODO innentol lefele torolni?
		return counter;
	}
	
	public void setCounter(int n) {
		counter = n;
	}
	
	
}
