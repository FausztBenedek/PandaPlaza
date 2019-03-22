package objektumok;

import skeletonApp.Skeleton;

/** */
public class Torekenycsempe extends Csempe {
	/** */
	private int elettartam;
	
	/** */
	@Override
	public void accept(Allat a) {
		Skeleton.print(this, "accept", a);
		Skeleton.ret();
	}
	
	/** */
	@Override
	public void ugrott() {
		Skeleton.print(this, "ugrott");
		Skeleton.ret();
	}
}
