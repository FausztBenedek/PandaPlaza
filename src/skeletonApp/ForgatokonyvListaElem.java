package skeletonApp;

/** A forgatókönyvek listájának elemei implementálják.
 */
public interface ForgatokonyvListaElem {
	
	/**
	 * Leírás a forgatókönyvhöz.
	 * @return - A forgatókönyv leírása.
	 */
	public String getLeiras();
	
	/**
	 * A forgatókönyvhöz tartozó objektumok példányosításához, 
	 * a forgatókönyv inicializálásához, és az inditásnak megfelelő
	 * metódus meghívásához szükséges logika.
	 */
	public void action();
}
