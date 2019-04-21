package objektumok;

import protoApp.Proto;

/** 
 * Olyan panda, aki a játékgép csilingelésétől megijed
 * */
public class Ijedos extends Panda {
	@Override
	public String toString() { 
		return "Ijedos " + Proto.getObjectName(this) + " csempe:" + Proto.getObjectName(getCsempe()) +
				" elsoMancs:" + Proto.getObjectName(getElsoMancs()) + " hatsoMancs:" + 
				Proto.getObjectName(getHatsoMancs()) + " game:" + Proto.getObjectName(game);
	}

	/** 
	 * Megijeszti az ijedős pandát: elengedi az előtte és mögötte állók mancsát.
	 * */
	@Override
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
