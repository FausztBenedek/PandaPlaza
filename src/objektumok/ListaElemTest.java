package objektumok;

import skeletonApp.Forgatokonyv;

/**
 * Ez az osztály a main függvény működését teszteli.
 * Tölendő
 */
public class ListaElemTest implements Forgatokonyv{

	@Override
	public String getLeiras() {
		return "Tesztelő elem, nincs funkcionalitása";
	}

	@Override
	public void action() {
		System.out.println("Ide fognak kerülni a metódus hívások");
	}
	

}
