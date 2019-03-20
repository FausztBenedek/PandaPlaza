package objektumok;

import java.util.ArrayList;
import java.util.Random;

/** */
public class Csempe {
	
	//attribútumok
	private Dolog dolog;
	private ArrayList<Csempe> szomszedok;
	
	//Függvények
	
	/** 
	 * Visszaadja azt a csempét ami a paraméterül kapott irányban van
	 * 
	 * */
	public Csempe getNeigbour(int irany) {
		return szomszedok.get(irany);
	}
	
	/** 
	 *Beállítja a csempe dolog attribútumát a paraméterül kapott állatra illetve az állat csempe
	 *attribútumát saját magára
	 * */
	public void accept(Allat a) {
		this.setDolog(a);
		a.setCsempe(this);
	}
	
	/** 
	 * Visszaadja a csempén tartózkodó dolgot
	 * */
	public Dolog getDolog() {
	
		return dolog; // TODO
	}
	
	/**
	 * Beállítja a paraméterül kapott dolgot a csempére
	 *  */
	public void setDolog(Dolog d) {
		dolog = d;
	}
	
	/**
	 * A paraméterül kapott csempét beállítja a saját adott irányban található szomszédjaként
	 *  */
	public void setNeighbour(int irany, Csempe c) {
		szomszedok.set(irany, c);
	}
	
	/**
	 * Lekezeli azt hogy egy rajta álló panda ugrott. A normál csempe esetén nem történik semmi
	 *  */
	public void ugrott() {
	}
	
	/**
	 * Visszaad egy random szomszédos csempét
	 * @return
	 */
	public Csempe getRandomSzomszed() {
		Random rand = new Random();
		int irany = rand.nextInt(szomszedok.size()); // elvileg ez a felső határt kapja paraméterül (az alsó 0) és annál szigorúan kisebbeket generál
		return szomszedok.get(irany);	
		
		
	}
}
