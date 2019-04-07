package objektumok;

import skeletonApp.Skeleton;

/** 
 * Olyan panda, aki a játékgép csilingelésétől megijed
 * */
public class Ijedos extends Panda {
	@Override
	public String toString() { 
		return "Ijedos " + Skeleton.getObjectName(this) + " csempe:" + Skeleton.getObjectName(getCsempe()) +
				" elsoMancs:" + Skeleton.getObjectName(getElsoMancs()) + " hatsoMancs:" + 
				Skeleton.getObjectName(getHatsoMancs()) + " game:" + Skeleton.getObjectName(game);
	}

	/** 
	 * Megijeszti az ijedős pandát: elengedi az előtte és mögötte állók mancsát.
	 * */
	@Override
	public void hitBy(Jatekgep j) {
		Skeleton.print(this, "hitBy", j);
		
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
		Skeleton.ret();
	}
}
