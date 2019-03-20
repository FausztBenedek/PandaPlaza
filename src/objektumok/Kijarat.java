package objektumok;

import skeletonApp.Skeleton;

/** */
public class Kijarat extends Dolog {
	
	/** */
	private Game game;

	/** */
	private Bejarat bejarat;
	
	/** */
	public void hitBy(Allat a) {
		Skeleton.print(this, "hitBy", a);
		Skeleton.ret();
	}
}
