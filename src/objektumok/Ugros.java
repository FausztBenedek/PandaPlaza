package objektumok;

import skeletonApp.Skeleton;

/** 
 * Olyan panda, aki a csokiautomata sípolásától ugrik egyet
 * */
public class Ugros extends Panda {

	/** 
	 * Ugratja a pandát
	 * */
	@Override
	public void hitBy(Csokiautomata c) {
		Skeleton.print(this, "hitBy", c);
		// Ugrik egyet az aktuális csempén. Ha ez a csempe törékeny, akkor az életereje 3 ponttal csökken
		getCsempe().ugrott();
		Skeleton.ret();
	}
}
