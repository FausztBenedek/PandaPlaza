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
	 * Beállítja a csempe dolog attribútumát a paraméterül kapott állatra illetve az állat csempe
	 * attribútumát saját magára
	 * @param A csempére rakandó állat
	 * */
	public void accept(Allat a) {
		Skeleton.print(this, "accept", a);
		this.setDolog(a);		
		a.setCsempe(this);
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
	public void ugrott() {
		Skeleton.print(this, "ugrott");
		Skeleton.ret();
	}
	
	/**
	 * Visszaad egy random szomszédos csempét
	 * @return A véletlenszerűen kiválaszott csempe
	 */
	public Csempe getRandomSzomszed() {
		Skeleton.print(this,"getRandomSzomszed");
		Random rand = new Random();
		int irany = rand.nextInt(szomszedok.size()); // elvileg ez a felső határt kapja paraméterül (az alsó 0) és annál szigorúan kisebbeket generál
		Skeleton.ret();
		return szomszedok.get(irany);	
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
