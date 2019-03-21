package objektumok;

import skeletonApp.Skeleton;

/** */
public class Szekreny extends Dolog {

	/** */
	private Szekreny masik;
	
	/** */
	public void hitBy(Allat a) {
		Skeleton.print(this, "hitBy", a);
		Skeleton.ret();
	}
}
