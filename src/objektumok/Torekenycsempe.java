package objektumok;

import skeletonApp.Skeleton;

/** */
public class Torekenycsempe extends Csempe {
	/** */
	private int elettartam;
	
	/** */
	@Override
	public void accept(Dolog d) {
		Skeleton.print(this, "accept", d);
		Skeleton.ret();
	}
	
	/** */
	@Override
	public void ugrott() {
		Skeleton.print(this, "ugrott");
		Skeleton.ret();
	}
}
