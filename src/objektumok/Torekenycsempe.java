package objektumok;

import skeletonApp.Skeleton;

/** */
public class Torekenycsempe extends Csempe {
	/** 
	 * A törékeny csempe élettartama.
	 * */
	private int elettartam = 20;
	
	/**
	 * Beállítja a csempe dolog attribútumát a paraméterül kapott állatra illetve az állat csempe
	 * attribútumát saját magára, illetve csökkenti a törékeny csempe élettartamát 1-gyel.
	 * */
	@Override
	public void accept(Allat a) {
		Skeleton.print(this, "accept", a);	
		this.setDolog(a);		
		a.setCsempe(this);
		elettartam--;
		a.die();
		Skeleton.ret();
	}
	
	/** 
	 * Csökkenti a törékeny csempe élettartamát 3-mal
	 * */
	@Override
	public void ugrott() {
		Skeleton.print(this, "ugrott");
		elettartam-=3;
		Skeleton.ret();
	}
}
