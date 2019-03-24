package skeletonApp;

import java.util.HashMap;

/**
 * Utility osztály, amely a metódusok nevének kiírásáért felelős.
 */
public class Skeleton {

	/**
	 * A skeleton osztály csak akkor ír ki bármit is, ha
	 * ez a változó true.
	 */
	private static boolean started = false;
	
	/**
	 * Megadja, hány tabulátorral kell behúzni a sort.
	 */
	private static int tabok = 0;
	
	/**
	 * Kiírja a paraméterül kapott stringet (a metódus neve) a 
	 * megfelelő tabulálással, és a következőkben egyel
	 * beljebb állítja.
	 * 
	 * @param methodName - A metódus neve, amit ke kell írni
	 */
	public static void print(Object object, String methodName) {
		if (started) {
			for (int i = 0; i < tabok; i++) {
				System.out.print("\t");
			}
			System.out.println(Skeleton.getObjectName(object)+"."+methodName+"()");
			tabok++;
		}
	}

	/**
	 * Kiírja a hívott függvény nevét a megfelelő paraméterekkel, tabulálásokkal, hozzá tartozó objektummal.
	 * @param object A hívó objektum
	 * @param methodName A hívott függvény neve
	 * @param params A paraméterek
	 */
	public static void print(Object object, String methodName, Object... params) {
		if (started) {
			for (int i = 0; i < tabok; i++) { //Szükséges mennyiségű tabulátor beszúrása
				System.out.print("\t");
			}
			String paramNames = "";
			// Minden objektum paramétert átfordít stringre: ha regisztrálva van, akkor a regisztrált nevét, ha nincs, akkor a ToString()-jét írja ki			
			for(int i = 0; i < params.length; i++)
				paramNames += params[i]==null?"null, ":getObjectName(params[i])!=null ? getObjectName(params[i])+", " : params[i].toString()+", ";
			if(paramNames.endsWith(", ")) paramNames = paramNames.substring(0, paramNames.length()-2);	
			System.out.println(Skeleton.getObjectName(object)+"."+methodName+"("+paramNames+")");
			tabok++;
		}
	}
	
	/**
	 * Eggyel kiljebb állítja a tabulálást.
	 * @throws IllegalStateException - Ha többször lett meghívva, mint a print
	 */
	public static void ret() {
		if (started) {
			tabok--;
			if (tabok < 0) {
				throw new IllegalStateException("Tabulálás nem lehet negatív");
			}
		}
	}
	
	private static HashMap<Integer, String> objektumok = new HashMap<Integer, String>();
	/**
	 * Regisztrálja az objektumot a skeletonba
	 * @param o A regisztrálandó objektum
	 * @param szoveg A regisztált objektum neve
	 */
	public static void addObjectName(Object o, String szoveg) {
		int hash = System.identityHashCode(o);
		objektumok.put(hash, szoveg);
	}
	
	/**
	 * Visszaadja egy regisztrált objektum nevét
	 * @param o A regisztrált objektum
	 * @return Az objektum neve
	 */
	public static String getObjectName(Object o) {
		return objektumok.get(System.identityHashCode(o));
	}
	
	/**
	 * Elindítja a forgatókönyvet.
	 */
	public static void startForgatokonyv() {
		started = true;
	}
	
	/**
	 * Visszaállítja az osztályt 
	 * az kiindulási állapotba.
	 */
	public static void finishForgatokonyv() {
		started = false;
		objektumok.clear();
	}
	
	
}
