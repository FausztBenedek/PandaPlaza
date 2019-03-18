package objektumok;

import java.util.ArrayList;

/** 
 * Egy pandát reprezentáló osztály
 * */
public abstract class Panda extends Allat implements ITickable {

	/** 
	 * Véletlen irányba lépteti egyet a Pandát
	 * */
	public void Leptet() {		
		Csempe cs = GetCsempe();
		ArrayList<Csempe> szomszedok = new ArrayList<Csempe>();
		for(int i = 0; i < 100; i++) { //TODO
			if(cs.GetNeigbour(i)!=null)
				szomszedok.add(cs.GetNeigbour(i));
		}
		
		// Random csempe kiválasztása a szomszédok közül
		Csempe randomCsempe = szomszedok.get((int)Math.floor(Math.random()*szomszedok.size()));
		
		//Megpróbálja a véletlenszerűen választott csempére léptetni a pandát
		Leptet(randomCsempe);
	}
	
	/**
	 * Jelzi a pandának, hogy telt az idő, ennek hatására eldönti, hogy akar-e lépni
	 * */
	public void Tick() {
		if(GetElsoMancs()==null)
			Leptet();
	}
	
	/** 
	 * Ha a panda szabadon kószál, beállítja az orangután mögé a pandát, és megcseréli a helyüket.
	 * */
	public void HitBy(Orangutan o) {
		if(GetElsoMancs()==null) {
			Csempe c1 = o.GetCsempe();
			GetCsempe().Accept(o);
			c1.Accept(this);
			SetElsoMancs(o);
			Allat orangutanMogotti = o.GetHatsoMancs();
			if(orangutanMogotti!=null) {
				SetHatsoMancs(orangutanMogotti);
				orangutanMogotti.SetElsoMancs(this);				
			}
			o.SetHatsoMancs(this);			
		}			
	}
	
	/** 
	 * Törli a pályáról a Pandát, csökkenti a hátralévő pandák számát.
	 * */
	public void Die() {
		// Elengedi mindenkinek a kezét, leveszi a pályáról
		super.Die();
		
		// Csökkenti a hátralévő pandák számát
		game.PandaSzamCsokkent();		
	}
}
