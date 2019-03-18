package objektumok;

/**
 * Olyan panda, akit bele lehet ültetni egy fotelbe.
 * */
public class Ulos extends Panda {
	/**
	 *  Leülteti a pandát a paraméterül kapott Fotelbe. Ha fogja valakinek a mancsát, elengedi
	 * */
	public void HitBy(Fotel f) {		
		//Ha valakit fog az első mancsával, elengedi
		Allat ae = GetElsoMancs();
		if(ae != null) {
			ae.SetHatsoMancs(null);
			SetElsoMancs(null);
		}
		//Ha valakit fog az hátsó mancsával, elengedi
		Allat ah = GetHatsoMancs();
		if(ah != null) {
			ah.SetElsoMancs(null);
			SetHatsoMancs(null);
		}
		
		// Beleülteti a fotelbe a pandát
		f.SetPanda(this);
	}
}
