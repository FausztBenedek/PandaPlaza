package objektumok;

import java.util.ArrayList;
import java.util.Random;

import skeletonApp.Skeleton;

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
		Skeleton.print("Csempe.getNeigbour()");
		Skeleton.ret();
		return szomszedok.get(irany);
		
	}
	
	/** 
	 *Beállítja a csempe dolog attribútumát a paraméterül kapott állatra illetve az állat csempe
	 *attribútumát saját magára
	 * */
	public void accept(Allat a) {
		Skeleton.print("Csempe.accept()");
		this.setDolog(a);
		Skeleton.ret();
		a.setCsempe(this);
	}
	
	/** 
	 * Visszaadja a csempén tartózkodó dolgot
	 * */
	public Dolog getDolog() {
		Skeleton.print("Csempe.getDolog()");
		Skeleton.ret();
		return dolog; // TODO
	}
	
	/**
	 * Beállítja a paraméterül kapott dolgot a csempére
	 *  */
	public void setDolog(Dolog d) {
		Skeleton.print("Csempe.setDolog()");
		dolog = d;
		Skeleton.ret();
	}
	
	/**
	 * A paraméterül kapott csempét beállítja a saját adott irányban található szomszédjaként
	 *  */
	public void setNeighbour(int irany, Csempe c) {
		Skeleton.print("Csempe.setNeighbour()");
		szomszedok.set(irany, c);
		Skeleton.ret();
	}
	
	/**
	 * Lekezeli azt hogy egy rajta álló panda ugrott. A normál csempe esetén nem történik semmi
	 *  */
	public void ugrott() {
		Skeleton.print("Csempe.ugrott");
		Skeleton.ret();
	}
	
	/**
	 * Visszaad egy random szomszédos csempét
	 * @return
	 */
	public Csempe getRandomSzomszed() {
		Skeleton.print("Csempe.getRandomSzomszed()");
		Random rand = new Random();
		int irany = rand.nextInt(szomszedok.size()); // elvileg ez a felső határt kapja paraméterül (az alsó 0) és annál szigorúan kisebbeket generál
		Skeleton.ret();
		return szomszedok.get(irany);	
		
		
	}
}
