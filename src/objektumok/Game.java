package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/** */
public class Game {
	/** 
	 * Játékos pontszáma
	 * */
	private int pontszam;
	
	/** 
	 * Az aktuálisan irányított orángután
	 * */
	private Orangutan aktivOrangutan;
	
	/** 
	 * pályán lévő orángutánok száma
	 * */
	private int orangutanszam;
	
	/** 
	 * pályán lévő pandák száma
	 * */
	private int pandaszam;
	
	/**
	 * lista a pályán lévő összes dologról
	 *  */
	private ArrayList<Dolog> dolgok;
	
	private ArrayList<Csempe> csempek;
	
	/**
	 * A paraméterül kapott pontmennyiséget hozzáadja a a játkos pontjaihoz
	 *  */
	public void addPoints(int p) {
		Skeleton.print(this, "addPoints");
		pontszam+=p;
		Skeleton.ret();
	}
	
	/** 
	 * új dolgot ad a számontartott dolgok listájához
	 * */
	public void addDolog(Dolog d) {
		Skeleton.print(this, "addDolog");
		dolgok.add(d);
		Skeleton.ret();
	}
	
	/** 
	 * Új csempét ad a számontartott csempék listájához
	 * */
	public void addCsempe(Csempe c) {
		Skeleton.print(this, "addCsempe");
		csempek.add(c);
		Skeleton.ret();
	}
	
	/**
	 * Beállítja a jelenleg aktív (vezérelt) orángutánt a paraméterül kapottra
	 *  */
	public void setActiveOrangutan(Orangutan o) {
		Skeleton.print(this, "setActiveOrangutan");
		aktivOrangutan = o;
		Skeleton.ret();
	}
	
	/** 
	 * Elindítja a játékot
	 * */
	public void startGame() {
		Skeleton.print(this, "startGame");
		Skeleton.ret();
	}
	
	/** 
	 * Véget vet a játéknak
	 * */
	public void endGame() {
		Skeleton.print(this, "endGame");
		Skeleton.ret();
	}
	
	/** 
	 * csökkenti a pályán nyilvántartott orángutánok számát
	 * */
	public void OrangutanSzamCsokkent() {
		Skeleton.print(this, "OrangutanSzamCsokkent");
		orangutanszam--;
		Skeleton.ret();
	}
	
	/** 
	 * Csökkenti a pályán nyilvántartott pandák számát
	 * */
	public void pandaSzamCsokkent() {
		Skeleton.print(this, "PandaSzamCsokkent");
		pandaszam--;
		Skeleton.ret();
	}
	
	/**
	 * Összeköt a paraméterül kapott csempéket a paraméterül kapott oldalaiknál
	 *  */
	public void csempeOsszekot(Csempe c1, int i1, Csempe c2, int i2) {
		Skeleton.print(this, "csempeOsszekot");
		c1.setNeighbour(i1, c2);
		c2.setNeighbour(i2, c1);
		Skeleton.ret();
	}
}
