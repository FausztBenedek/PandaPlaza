package objektumok;

/** 
 * Egy pandát reprezentáló osztály
 * */
public abstract class Panda extends Allat implements ITickable {

	/** 
	 * Véletlen irányba lépteti egyet a Pandát
	 * */
	public void leptet() {		
		//Megpróbálja egy véletlenszerűen választott csempére léptetni a pandát
                leptet(getCsempe().getRandomSzomszed());	
	}
	
	/**
	 * Jelzi a pandának, hogy telt az idő, ennek hatására eldönti, hogy akar-e lépni
	 * */
	public void tick() {
		if(getElsoMancs()==null)
			leptet();
	}
	
	/** 
	 * Ha a panda szabadon kószál, beállítja az orangután mögé a pandát, és megcseréli a helyüket.
	 * */
	@Override
	public void hitBy(Orangutan o) {
		if(getElsoMancs()==null) {
			Csempe c1 = o.getCsempe();
			getCsempe().accept(o);
			c1.accept(this);
			setElsoMancs(o);
			Allat orangutanMogotti = o.getHatsoMancs();
			if(orangutanMogotti!=null) {
				setHatsoMancs(orangutanMogotti);
				orangutanMogotti.setElsoMancs(this);				
			}
			o.setHatsoMancs(this);			
		}		
	}
	
	/**
	 * Megpróbálja ráléptetni az adott csempére a pandát. Ha van ott 
	 * valami, meghívja rá a hitby függvényt.
         * Rekurzívan lépteti a mögötte lévőt, miután már lépett
	 * @param A csempe amelyikre léptetni akarjuk
	 */
	public void leptet(Csempe c) { 
		
		// Lekéri a csempén lévő dolgot		
		Dolog d = c.getDolog();
		// Eltároljuk a mostani csempéjét, ameddig még nem változott
                Csempe elozo = getCsempe();
                
		//Ha üres a szomszédos mező, átlép rá, ha nem, ütközteti magát az ott levő dologgal.
		if(d==null) {			
			c.accept(this);
		} else {
			d.hitBy(this);
		}
                
                // Léptetjük mögötte lévő pandát, ha van ilyen
                if (getHatsoMancs() != null) {
                    getHatsoMancs().leptet(elozo);
                }
	}
	
	/** 
	 * Törli a pályáról a Pandát, csökkenti a hátralévő pandák számát.
	 * */
	@Override
	public void die() {
		// Elengedi mindenkinek a kezét, leveszi a pályáról
		super.die();
		
		// Csökkenti a hátralévő pandák számát
		game.pandaSzamCsokkent();	
	}
}
