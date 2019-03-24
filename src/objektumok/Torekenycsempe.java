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
	 * @param A csempére rakandó állat
	 * */
	@Override
	public void accept(Allat a) {
		Skeleton.print(this, "accept", a);	
		this.setDolog(a);		
		a.setCsempe(this);
		if(a!=null) elettartam--;
		if(elettartam <=0) a.die();
		Skeleton.ret();
	}
	
	/** 
	 * Csökkenti a törékeny csempe élettartamát 3-mal
	 * @param Az állat aki ráugrott
	 * */
	@Override
	public void ugrott(Allat a) {
		Skeleton.print(this, "ugrott",a);
		elettartam-=3;
		if(elettartam <=0)			
			a.die();
		Skeleton.ret();
	}
	
	/**
	 * Beállítja, hogy hány élete legyen a csempének. (Csak skeletonban kell)
	 * @param elettartam A beállítandó érték
	 */
	public void setElettartam(int elettartam) {
		this.elettartam = elettartam;
	}
}
