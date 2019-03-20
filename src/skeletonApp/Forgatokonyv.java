package skeletonApp;

/** A forgatókönyvek listájának elemei implementálják.
 */
public abstract class Forgatokonyv {
		
	/**
	 * Leírás a forgatókönyvhöz.
	 * @return - A forgatókönyv leírása.
	 */
	public abstract String getLeiras();
	
	/**
	 * A forgatókönyvhöz tartozó objektumok példányosításához, 
	 * a forgatókönyv inicializálásához, és az inditásnak megfelelő
	 * metódus meghívásához szükséges logika.
	 */
	public abstract void action();
}
