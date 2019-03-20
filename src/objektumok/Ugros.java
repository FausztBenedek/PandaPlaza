package objektumok;

/** 
 * Olyan panda, aki a csokiautomata sípolásától ugrik egyet
 * */
public class Ugros extends Panda {
	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
//	public Ugros(Csempe c) {
//		super(c);
//	}
	/** 
	 * Ugratja a pandát
	 * */
	public void hitBy(Csokiautomata c) {
		// Ugrik egyet az aktuális csempén. Ha ez a csempe törékeny, akkor az életereje 3 ponttal csökken
		getCsempe().ugrott();
	}
}
