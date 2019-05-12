package objektumok;

import java.util.ArrayList;
import java.util.Random;

import protoApp.Proto;
import view.CsempeView;

/** */
public class Csempe {
	
        /**
         * A kirajzoló objektum.
         */
        private CsempeView view;
    
        /**
         * Getter a kirajzoló objektumra.
         * @return 
         */
        public CsempeView getView() {
            return view;
        }
        
        /**
         * Beállítja a kirajzoló objektumot.
         * @param view 
         */
        public void setView(CsempeView view) {
            this.view = view;
        }
        
	@Override
	public String toString() {
		String csempek = "";
		for(int i = 0; i < szomszedok.size(); i++) {
			if(szomszedok.get(i)!=null) {
				csempek+=" "+i+":"+Proto.getObjectName(szomszedok.get(i));
			}
		}
		return "Csempe " +  Proto.getObjectName(this) + " dolog:"+Proto.getObjectName(dolog) + csempek;
	}
	
	//attribútumok
	private Dolog dolog;
	protected ArrayList<Csempe> szomszedok = new ArrayList<Csempe>();
		
	/** 
	 * Visszaadja azt a csempét ami a paraméterül kapott irányban van
	 * @param Melyik irányú csempét kérjük
	 * */
	public Csempe getNeigbour(int irany) {
		return szomszedok.get(irany);
	}
	
	/** 
	 * Leveszi az állatot az előző csempéjéről, és beállítja a csempe 
	 * dolog attribútumát a paraméterül kapott állatra illetve az állat csempe
	 * attribútumát saját magára
	 * @param A csempére rakandó állat
	 * */
	public void accept(Allat a) {
		Csempe elozo = a.getCsempe();
		if(elozo!=null) 
                    if (elozo.getDolog() == a) 
			elozo.setDolog(null);
		a.setCsempe(this);
		this.setDolog(a);
	}
	
	/** 
	 * Visszaadja a csempén tartózkodó dolgot
	 * */
	public Dolog getDolog() {
		return dolog;
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
		while(irany>=szomszedok.size()) szomszedok.add(null);
		szomszedok.set(irany, c);
	}
	
	/**
	 * Lekezeli azt hogy egy rajta álló panda ugrott. A normál csempe esetén nem történik semmi
	 *  */
	public void ugrott(Allat a) {
	}
	
	/**
	 * Visszaad egy random szomszédos csempét
	 * @return A véletlenszerűen kiválaszott csempe
	 */
	public Csempe getRandomSzomszed() {
		ArrayList<Csempe> allNeighbours = getAllNeighbours();
		Random rand = new Random();		
		// elvileg ez a felső határt kapja paraméterül (az alsó 0) és annál szigorúan kisebbeket generál:
		return allNeighbours.get(rand.nextInt(allNeighbours.size()));	
	}
	
	/**
	 * Visszatér az összes szomszédos csempével
	 * @return A szomszédos csempék gyűjteménye
	 */
	public ArrayList<Csempe> getAllNeighbours(){
		ArrayList<Csempe> ret = new ArrayList<Csempe>();
		for(Csempe c : szomszedok)
			if(c!=null)
				ret.add(c);
		return ret;		
	}
}
