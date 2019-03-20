package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/** 
 * Egy pandát reprezentáló osztály
 * */
public abstract class Panda extends Allat implements ITickable {

	/** 
	 * Véletlen irányba lépteti egyet a Pandát
	 * */
	public void leptet() {		
		Skeleton.print(this, "leptet");
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
		Skeleton.ret();
	}
	
	/**
	 * Jelzi a pandának, hogy telt az idő, ennek hatására eldönti, hogy akar-e lépni
	 * */
	public void tick() {
		Skeleton.print(this, "tick");
		if(getElsoMancs()==null)
			leptet();
		Skeleton.ret();
	}
	
	/** 
	 * Ha a panda szabadon kószál, beállítja az orangután mögé a pandát, és megcseréli a helyüket.
	 * */
	public void hitBy(Orangutan o) {
		Skeleton.print(this, "hitBy", o);
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
		Skeleton.ret();
	}
	
	/** 
	 * Törli a pályáról a Pandát, csökkenti a hátralévő pandák számát.
	 * */
	public void die() {
		Skeleton.print(this, "die");
		// Elengedi mindenkinek a kezét, leveszi a pályáról
		super.die();
		
		// Csökkenti a hátralévő pandák számát
		game.pandaSzamCsokkent();	
		Skeleton.ret();
	}
}
