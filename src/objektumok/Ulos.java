package objektumok;

import skeletonApp.Proto;

/**
 * Olyan panda, akit bele lehet ültetni egy fotelbe.
 * */
public class Ulos extends Panda {
	@Override
	public String toString() {
		return "Ulos " + Proto.getObjectName(this) + " csempe:" + Proto.getObjectName(getCsempe()) +
				" elsoMancs:" + Proto.getObjectName(getElsoMancs()) + " hatsoMancs:" + 
				Proto.getObjectName(getHatsoMancs()) + " game:" + Proto.getObjectName(game);
	}	
	
	/**
	 *  Leülteti a pandát a paraméterül kapott Fotelbe. Ha fogja valakinek a mancsát, elengedi
	 *  @param A fotel aki leültette
	 * */
	@Override
	public void hitBy(Fotel f) {	
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
		// Leveszi magát a jelenlegi mezőről
		Csempe sajatCsempe = getCsempe();
		sajatCsempe.setDolog(null);
		sajatCsempe = null;
		
		// Beleülteti a fotelbe a pandát
		f.setPanda(this);
		
	}	
}
