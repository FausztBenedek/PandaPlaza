package objektumok;

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
		//Megpróbálja egy véletlenszerűen választott csempére léptetni a pandát
		if(!Skeleton.det)
			leptet(getCsempe().getRandomSzomszed());
		else {
			System.out.println("Milyen irányba lépjen a panda?");
			leptet(getCsempe().getNeigbour(Skeleton.GetUserInput()));
		}
			
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
	@Override
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
	 * Megpróbálja ráléptetni az adott csempére a pandát. Ha van ott 
	 * valami, meghívja rá a hitby függvényt.
	 * @param A csempe amelyikre léptetni akarjuk
	 */
	public void leptet(Csempe c) { 
		Skeleton.print(this, "leptet", c);
		
		// Lekéri a csempén lévő dolgot		
		Dolog d = c.getDolog();
		
		//Ha üres a szomszédos mező, átlép rá, ha nem, ütközteti magát az ott levő dologgal.
		if(d==null) {			
			c.accept(this);
		} else {
			d.hitBy(this);
		}
		Skeleton.ret();
	}
	
	/** 
	 * Törli a pályáról a Pandát, csökkenti a hátralévő pandák számát.
	 * */
	@Override
	public void die() {
		Skeleton.print(this, "die");
		// Elengedi mindenkinek a kezét, leveszi a pályáról
		super.die();
		
		// Csökkenti a hátralévő pandák számát
		game.pandaSzamCsokkent();	
		Skeleton.ret();
	}
}
