package objektumok;

/** A dolog reprezentál minden olyan objektumot a játékban,
 * ami ütközhet egy másik példánnyal.
 * A dolgoknak van egy csempéjük is. 
 */
public abstract class Dolog {
	
	/**
	 * A csempe, amin a dolog éppen áll. Nem lehet soha NULL.
	 */
	private Csempe c;
	
	/** A leszármazottak ennek a metódusnak a felüldefiniálásával
	 * implementálják az ütközéskor végrehajtott logikát. Alapértelmezetten
	 * ez egy üres metódus, nincs semilyen végrehajtandó logika.
	 * 
	 * A felüldefiniálás NEM azt a célt szolgálja a modellben, hogy 
	 * heterogén kollekcióval végigiteráljunk az összes leszármazottban
	 * implementált logikán. A függvény paraméterébe MINDIG
	 * a referenciának megfelelő típusú objektumot kell átadni.
	 * 
	 * Ennek magyarázatára vegyünk két osztályt, A és B, amelyek ebből
	 * az osztályból örökölnek. A osztályban legyen definiálva egy HitBy(B b)
	 * metódus. Ha A osztály egy példányán meghívjuk a HitBy(Dolog d) metúdust,
	 * úgy hogy a d igazából egy B típusú objektumra mutató Dolog típusú 
	 * referencia (ilyet lehet előállítani pl a Dolog d = new B();-vel), akkor
	 * ennek az osztálynak (class Dolog) a HitBy metódusa hívódik meg.
	 * Ez egy heterogén kollekció esetén minden elemre ez hívódik meg. 
	 * Ezért fontos odafigyelni, hogy a paraméterben
	 * átadott referencia a lehető legspecifikusabb legyen, különben
	 * ez nem várt működést eredményezhet.
	 * @param d - A dolog amivel ez a dolog ütközik.
	 */
	public void hitBy(Dolog d) {
	}	
	public void hitBy(Allat a) {hitBy((Dolog)a);}
	public void hitBy(Csokiautomata c) {hitBy((Dolog)c);}
	public void hitBy(Fotel f) {hitBy((Dolog)f);}
	public void hitBy(Jatekgep p ) {hitBy((Dolog)p);}	
	public void hitBy(Orangutan o) {hitBy((Dolog)o);}
	
	/**
	 * Getter a csempére, amin a dolog éppen áll.
	 * @return - A csempe.
	 */
	public Csempe getCsempe() {
		return c;
	}
	
	/**
	 * Setter a csempére, amire egy dolgot akarunk helyezni.
	 * @param c - Az új csempe.
	 */
	public void setCsempe(Csempe c) {
		this.c = c;
	}
}
