package objektumok;

/** 
 * Olyan panda, aki a csokiautomata sípolásától ugrik egyet
 * */
public class Ugros extends Panda {
	/** 
	 * Ugratja a pandát
	 * */
	public void hitBy(Csokiautomata c) {
		// Ugrik egyet az aktuális csempén. Ha ez a csempe törékeny, akkor az életereje 3 ponttal csökken
		getCsempe().ugrott();
	}
}
