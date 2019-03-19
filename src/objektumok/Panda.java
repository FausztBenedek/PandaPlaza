package objektumok;

import java.util.ArrayList;

/** 
 * Egy pandát reprezentáló osztály
 * */
public abstract class Panda extends Allat implements ITickable {
	/**
	 * Konstruktor, amelyben meghatározzuk a kezdő csempét.
	 * @param c - A kezdőpozíció.
	 */
	public Panda(Csempe c) {
		super(c);
	}
	/** 
	 * Véletlen irányba lépteti egyet a Pandát
	 * */
	public void leptet() {		
		Csempe cs = getCsempe();
		ArrayList<Csempe> szomszedok = new ArrayList<Csempe>();
		for(int i = 0; i < 100; i++) { //TODO
			if(cs.getNeigbour(i)!=null)
				szomszedok.add(cs.getNeigbour(i));
		}
		
		// Random csempe kiválasztása a szomszédok közül
		Csempe randomCsempe = szomszedok.get((int)Math.floor(Math.random()*szomszedok.size()));
		
		//Megpróbálja a véletlenszerűen választott csempére léptetni a pandát
		leptet(randomCsempe);
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
	 * Törli a pályáról a Pandát, csökkenti a hátralévő pandák számát.
	 * */
	public void die() {
		// Elengedi mindenkinek a kezét, leveszi a pályáról
		super.die();
		
		// Csökkenti a hátralévő pandák számát
		game.pandaSzamCsokkent();		
	}
}
