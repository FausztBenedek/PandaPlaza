package objektumok;

/** 
 * Olyan panda, aki a játékgép csilingelésétől megijed
 * */
public class Ijedos extends Panda {
	/** 
	 * Megijeszti az ijedős pandát: elengedi az előtte és mögötte állók mancsát.
	 * */
	public void hitBy(Jatekgep j) {
		
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
	}
}
