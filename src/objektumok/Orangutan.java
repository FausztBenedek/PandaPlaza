package objektumok;

/** 
 * Egy orangutánt reprezentál
 * */
public class Orangutan extends Allat {
	
	private int vedelem = 0; 
		
	/** 
	 * Lépteti a megadott irányba az orangutánt
	 * */
	public void leptet(int irany) {
		// Lekéri az adott irányú szomszédos csempét
		Csempe cs = getCsempe().getNeigbour(irany);
		
		//Megpróbálja az adott irányú csempére léptetni az orangutánt, ha létezik ilyen irányú szomszéd
		if(cs !=null)
			leptet(cs);	
	}
	
	/**
	 * Megpróbálja ráléptetni az adott csempére az orangutánt. Ha van ott 
	 * valami, meghívja rá a hitby függvényt.
         * Lépteti a mögötte lévő pandát is, ha van.
	 * @param A csempe amelyikre léptetni akarjuk
	 */
	public void leptet(Csempe c) {
		// Lekéri a csempén lévő dolgot
		Dolog d = c.getDolog();
                // Eltároljuk a mostani csempét
                Csempe elozo = getCsempe();
		
		if(vedelem > 0) vedelem--;
		//Ha üres a szomszédos mező, átlép rá, ha nem, ütközteti magát az ott levő dologgal.
		if(d==null) {
			c.accept(this);
		} else {
			d.hitBy(this);
		}
                
                if (getHatsoMancs() != null) {
                    getHatsoMancs().leptet(elozo);
                }
	}
	
	/** 
	 * Megöli az orángutánt: leveszi az orangutánt a pályáról, elengedi a mögötte lévő mancsát, és csökkenti a hátralévő orángutánok számát
	 * */
	@Override
	public void die() {
		// Leveszi a pályáról, elengedi a szomszédjai mancsát
		super.die();
		
		// Csökkenti a hátralévő orangutánok számát
		game.orangutanSzamCsokkent();
		game.setActiveOrangutan(null);
	}	
	
	@Override
	public void hitBy(Orangutan o) {
		if(o.vedelem == 0 && o.getHatsoMancs()==null) {
			Csempe sajatCsempe = getCsempe();
			Csempe masikCsempe = o.getCsempe();		
			sajatCsempe.accept(o);
			setCsempe(null);
			Allat hatso = getHatsoMancs();
			if(hatso!=null) {
				o.setHatsoMancs(hatso);
				hatso.setElsoMancs(o);
				setHatsoMancs(null);				
			}
			masikCsempe.accept(this);
			vedelem = 3;			
		}		
	}
}
