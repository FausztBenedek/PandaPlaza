package objektumok;

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
	public void Die() {		
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
		
		// Leveszi az állatot a csempéről
		GetCsempe().SetDolog(null);
	}
	
	/** 
	 * Visszatér azzal az állattal, akit a hátsó mancsával fog
	 * */
	public Allat GetHatsoMancs() {
		return hatsoMancs;
	}
	
	/** 
	 * Megfogja a hátsó mancsával a paraméterül kapott állatot
	 * */
	public void SetHatsoMancs(Allat a) {
		hatsoMancs = a;
	}
	
	/** 
	 * Visszatér azzal az állattal, akit az első mancsával fog
	 * */
	public Allat GetElsoMancs() {
		return elsoMancs;
	}
	
	/** 
	 * Megfogja az első mancsával a paraméterül kapott állatot
	 * */
	public void SetElsoMancs(Allat a) {
		elsoMancs = a;
	}
	
	/** 
	 * Megpróbálja ráléptetni a paraméterül kapott csempére az állatot
	 * */
	public void Leptet(Csempe c) {
		// Lekéri a csempén lévő dolgot
		Dolog d = c.GetDolog();
		
		//Ha üres a szomszédos mező, átlép rá, ha nem, ütközteti magát az ott levő dologgal.
		if(d==null) {
			c.Accept(this);
		} else {
			d.HitBy(this);
		}
	}
}
