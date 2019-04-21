package objektumok;

import protoApp.Proto;

/** */
public abstract class Allat extends Dolog {

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
		setCsempe(null);
	}
	
	/** 
	 * Visszatér azzal az állattal, akit a hátsó mancsával fog
	 * */
	public Allat getHatsoMancs() {
		return hatsoMancs;
	}
	
	/** 
	 * Megfogja a hátsó mancsával a paraméterül kapott állatot
	 * */
	public void setHatsoMancs(Allat a) {
		hatsoMancs = a;
	}
	
	/** 
	 * Visszatér azzal az állattal, akit az első mancsával fog
	 * */
	public Allat getElsoMancs() {
		return elsoMancs;
	}
	
	/** 
	 * Megfogja az első mancsával a paraméterül kapott állatot. Ha nullt kap paraméterként, elengedi a mögötte álló mancsát.
	 * @param A megfogandó állat
	 * */
	public void setElsoMancs(Allat a) {
		elsoMancs = a;
		// Ha elengedték az első mancsát
		if(a==null) {
			// Ha fog valakit a hátsó mancsával
			if(hatsoMancs!=null) {
				// Elengedi a mögötte álló mancsát
				hatsoMancs.setElsoMancs(null);
				hatsoMancs = null;
			}
		}			
	}
	
	/** 
	 * Megpróbálja ráléptetni a paraméterül kapott csempére az állatot
	 * */
	public abstract void leptet(Csempe c);
	
	/**
	 * Beállítja az állat game attribútumát a paraméterben kapottra 
	 * @param A beállítandó érték
	 */
	public void setGame(Game g) {
		game = g;
	}
}
