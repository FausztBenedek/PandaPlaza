package objektumok;

import java.util.ArrayList;

import skeletonApp.Proto;

/** */
public class Game {
	@Override
	public String toString() {
		//TODO dolgok, csempék?
		return "Game " + Proto.getObjectName(this) + " pontszam:"+pontszam+" aktivOrangutan:"+Proto.getObjectName(aktivOrangutan) + " orangutanszam:"+ orangutanszam + " pandaszam:"+pandaszam;
	}
	
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
	private ArrayList<Dolog> dolgok = new ArrayList<Dolog>();
	
	private ArrayList<Csempe> csempek = new ArrayList<Csempe>();
	
	/**
	 * A paraméterül kapott pontmennyiséget hozzáadja a a játkos pontjaihoz
	 * @param Hány pontot adjon a pontszámhoz
	 *  */
	public void addPoints(int p) {
		pontszam+=p;
	}
	
	/** 
	 * Új dolgot ad a számontartott dolgok listájához
	 * @param d A hozzáadandó dolog
	 * */
	public void addDolog(Dolog d) {
		dolgok.add(d);
	}
	
	/**
	 * Új csempét ad a számontartott csempék listájához
	 * @param c A játékhoz adandó csempe
	 */
	public void addCsempe(Csempe c) {
		csempek.add(c);
	}
	
	/**
	 * Beállítja a jelenleg aktív (vezérelt) orángutánt a paraméterül kapottra
	 * @param o Az irányítani kívánt orangután
	 */
	public void setActiveOrangutan(Orangutan o) {
		aktivOrangutan = o;
	}
	
	/** 
	 * Elindítja a játékot
	 * */
	public void startGame() {
	}
	
	/** 
	 * Véget vet a játéknak
	 * */
	public void endGame() {
	}	
	
	/** 
	 * csökkenti a pályán nyilvántartott orángutánok számát
	 * */
	public void orangutanSzamCsokkent() {
		orangutanszam--;
	}
	
	/** 
	 * Csökkenti a pályán nyilvántartott pandák számát
	 * */
	public void pandaSzamCsokkent() {
		pandaszam--;
	}
	
	/**
	 *  Összeköt a paraméterül kapott csempéket a paraméterül kapott oldalaiknál
	 * @param c1 Egyik csempe
	 * @param i1 Egyik csempe melyik oldalára
	 * @param c2 Másik csempe
	 * @param i2 Másik csempe melyik oldalára
	 */
	public void csempeOsszekot(Csempe c1, int i1, Csempe c2, int i2) {
		c1.setNeighbour(i1, c2);
		c2.setNeighbour(i2, c1);
	}
	
	public void elenged() { //TODO kommentelni
		Allat hatso = aktivOrangutan.getHatsoMancs();
		if(hatso!=null) {
			hatso.setElsoMancs(null);
			aktivOrangutan.setHatsoMancs(null);
		}
	}
	
	public void leptet(int irany) { // TODO kommentelni
		if(aktivOrangutan!=null)
			aktivOrangutan.leptet(irany);
	}
	
	public void setPoint(int pont) { // TODO innentől lefele kiszedni? (+komment)
		pontszam = pont;
	}
	
	public void setOrangutanSzam(int n) {
		orangutanszam = n;
	}
	
	public void setPandaSzam(int n) {
		pandaszam = n;
	}
}
