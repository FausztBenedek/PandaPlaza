package objektumok;

/** 
 * Olyan panda, aki a játékgép csilingelésétől megijed
 * */
public class Ijedos extends Panda {
	/** 
	 * Megijeszti az ijedős pandát: elengedi az előtte és mögötte állók mancsát.
	 * */
	public void HitBy(Jatekgep j) {
		
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
	}
}
