package objektumok;

import skeletonApp.Skeleton;

/** 
 * Olyan panda, aki a csokiautomata sípolásától ugrik egyet
 * */
public class Ugros extends Panda {
	@Override
	public String toString() {
		return "Ugros " + Skeleton.getObjectName(this) + " csempe:" + Skeleton.getObjectName(getCsempe()) +
				" elsoMancs:" + Skeleton.getObjectName(getElsoMancs()) + " hatsoMancs:" + 
				Skeleton.getObjectName(getHatsoMancs()) + " game:" + Skeleton.getObjectName(game);
	}

	/** 
	 * Ugratja a pandát
	 * @param A csokiautomata aki ugratta 
	 * */
	@Override
	public void hitBy(Csokiautomata c) {
		Skeleton.print(this, "hitBy", c);
		// Ugrik egyet az aktuális csempén. Ha ez a csempe törékeny, akkor az életereje 3 ponttal csökken
		getCsempe().ugrott(this);
		Skeleton.ret();
	}
}
