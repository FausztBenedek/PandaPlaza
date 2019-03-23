package objektumok;

import java.util.ArrayList;
import java.util.Random;

import skeletonApp.Skeleton;

/** */
public class Csempe {
	
	//attribútumok
	private Dolog dolog;
	private ArrayList<Csempe> szomszedok = new ArrayList<Csempe>();
	
	//Függvények
	
	/** 
	 * Visszaadja azt a csempét ami a paraméterül kapott irányban van
	 * 
	 * */
	public Csempe getNeigbour(int irany) {
		Skeleton.print(this, "getNeighbour", irany);
		Skeleton.ret();
		return szomszedok.get(irany);
	}
	
	/** 
	 * Leveszi az állatot az előző csempéjéről, és beállítja a csempe 
	 * dolog attribútumát a paraméterül kapott állatra illetve az állat csempe
	 * attribútumát saját magára
	 * @param A csempére rakandó állat
	 * */
	public void accept(Allat a) {
		Skeleton.print(this, "accept", a);
		Csempe elozo = a.getCsempe();
		if(elozo!=null)
			elozo.setDolog(null);
		a.setCsempe(this);
		this.setDolog(a);
		Skeleton.ret();
	}
	
	/** 
	 * Visszaadja a csempén tartózkodó dolgot
	 * */
	public Dolog getDolog() {
		Skeleton.print(this, "getDolog");
		Skeleton.ret();
		return dolog;
	}
	
	/**
	 * Beállítja a paraméterül kapott dolgot a csempére
	 *  */
	public void setDolog(Dolog d) {
		Skeleton.print(this, "setDolog", d);
		dolog = d;
		Skeleton.ret();
	}
	
	/**
	 * A paraméterül kapott csempét beállítja a saját adott irányban található szomszédjaként
	 *  */
	public void setNeighbour(int irany, Csempe c) {
		Skeleton.print(this, "setNeighbour", irany, c);
		while(irany>=szomszedok.size()) szomszedok.add(null); // TODO? hack?
		szomszedok.set(irany, c);
		Skeleton.ret();
	}
	
	/**
	 * Lekezeli azt hogy egy rajta álló panda ugrott. A normál csempe esetén nem történik semmi
	 *  */
	public void ugrott(Allat a) {
		Skeleton.print(this, "ugrott",a);
		Skeleton.ret();
	}
	
	/**
	 * Visszaad egy random szomszédos csempét
	 * @return A véletlenszerűen kiválaszott csempe
	 */
	public Csempe getRandomSzomszed() {
		Skeleton.print(this,"getRandomSzomszed");
		ArrayList<Csempe> allNeighbours = getAllNeighbours();
		Random rand = new Random();		
		Skeleton.ret();
		// elvileg ez a felső határt kapja paraméterül (az alsó 0) és annál szigorúan kisebbeket generál:
		return allNeighbours.get(rand.nextInt(allNeighbours.size()));	
	}
	
	/**
	 * Visszatér az összes szomszédos csempével
	 * @return A szomszédos csempék gyűjteménye
	 */
	public ArrayList<Csempe> getAllNeighbours(){
		Skeleton.print(this, "getAllNeighbours");
		ArrayList<Csempe> ret = new ArrayList<Csempe>();
		for(Csempe c : szomszedok)
			if(c!=null)
				ret.add(c);
		Skeleton.ret();
		return ret;		
	}
}
