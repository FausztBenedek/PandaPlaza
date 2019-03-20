package objektumok;

/**
 * Olyan panda, akit bele lehet ültetni egy fotelbe.
 * */
public class Ulos extends Panda {
	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
//	public Ulos(Csempe c) {
//		super(c);
//	}
	
	/**
	 *  Leülteti a pandát a paraméterül kapott Fotelbe. Ha fogja valakinek a mancsát, elengedi
	 * */
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
		
		// Beleülteti a fotelbe a pandát
		f.setPanda(this);
	}
}
