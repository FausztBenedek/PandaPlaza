package objektumok;

import skeletonApp.Proto;

/** 
 * Olyan panda, aki a csokiautomata sípolásától ugrik egyet
 * */
public class Ugros extends Panda {
	@Override
	public String toString() {
		return "Ugros " + Proto.getObjectName(this) + " csempe:" + Proto.getObjectName(getCsempe()) +
				" elsoMancs:" + Proto.getObjectName(getElsoMancs()) + " hatsoMancs:" + 
				Proto.getObjectName(getHatsoMancs()) + " game:" + Proto.getObjectName(game);
	}

	/** 
	 * Ugratja a pandát
	 * @param A csokiautomata aki ugratta 
	 * */
	@Override
	public void hitBy(Csokiautomata c) {
		// Ugrik egyet az aktuális csempén. Ha ez a csempe törékeny, akkor az életereje 3 ponttal csökken
		getCsempe().ugrott(this);
	}
}
