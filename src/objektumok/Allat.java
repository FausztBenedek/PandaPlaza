package objektumok;

import skeletonApp.Skeleton;

/** */
public abstract class Allat extends Dolog {
	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
//	public Allat(Csempe c) {
//		super(c);
//	}
	
	/** 
	 * Az az állat, akit a hátsó mancsával fog
	 * */
	private Allat hatsoMancs;
	
	/** 
	 * Az az állat, akit az első mancsával fog
	 * */
	private Allat elsoMancs;
	
	/** 
	 * A játékot reprezentálja
	 * */
	protected Game game;
	
	/** 
	 * Elengedi az előtte és mögötte állók mancsát és leveszi a pályáról az állatot
	 * */
	public void die() {		
		Skeleton.print(this, "die");
		//Ha valakit fog az első mancsával, elengedi
		Allat ae = getElsoMancs();
		if(ae != null) {
			ae.setHatsoMancs(null);
			setElsoMancs(null);
		}
		
		//Ha valakit fog az hátsó mancsával, elengedi
		Allat ah = getHatsoMancs();
		if(ah != null) {
			ah.setElsoMancs(null);
			setHatsoMancs(null);
		}
		
		// Leveszi az állatot a csempéről
		getCsempe().setDolog(null);
		Skeleton.ret();
	}
	
	/** 
	 * Visszatér azzal az állattal, akit a hátsó mancsával fog
	 * */
	public Allat getHatsoMancs() {
		Skeleton.print(this, "getHatsoMancs");
		Skeleton.ret();
		return hatsoMancs;
	}
	
	/** 
	 * Megfogja a hátsó mancsával a paraméterül kapott állatot
	 * */
	public void setHatsoMancs(Allat a) {
		Skeleton.print(this, "setHatsoMancs");
		Skeleton.ret();
		hatsoMancs = a;
	}
	
	/** 
	 * Visszatér azzal az állattal, akit az első mancsával fog
	 * */
	public Allat getElsoMancs() {
		Skeleton.print(this, "getElsoMancs");
		Skeleton.ret();
		return elsoMancs;
	}
	
	/** 
	 * Megfogja az első mancsával a paraméterül kapott állatot
	 * */
	public void setElsoMancs(Allat a) {
		Skeleton.print(this, "setElsoMancs");
		Skeleton.ret();
		elsoMancs = a;
	}
	
	/** 
	 * Megpróbálja ráléptetni a paraméterül kapott csempére az állatot
	 * */
	public void leptet(Csempe c) {
		Skeleton.print(this, "leptet", c);
		// Lekéri a csempén lévő dolgot
		Dolog d = c.getDolog();
		
		//Ha üres a szomszédos mező, átlép rá, ha nem, ütközteti magát az ott levő dologgal.
		if(d==null) {
			c.accept(this);
		} else {
			d.hitBy(this);
		}
		Skeleton.ret();
	}
	
	/**
	 * Beállítja az állat game attribútumát a paraméterben kapottra 
	 * @param A beállítandó érték
	 */
	public void setGame(Game g) {
		game = g;
	}
}
