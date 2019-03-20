package skeletonApp;

import java.util.HashMap;

/**
 * Utility osztály, amely a metódusok nevének kiírásáért felelős.
 */
public class Skeleton {

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
		for (int i = 0; i < tabok; i++) {
			System.out.print("\t");
		}
		System.out.println(Skeleton.getObjectName(object)+"."+methodName+"()");
		tabok++;
	}
	
	/*public static void print(Object object, String methodName, ArrayList<Object> params) {
		for (int i = 0; i < tabok; i++) {
			System.out.print("\t");
		}
		String paramNames = "";
		for(int i = 0; i < params.size(); i++) 
			paramNames += getObjectName(params.get(i))+", ";	
		if(paramNames.endsWith(", ")) 
			paramNames.substring(0, paramNames.length()-3); // TODO?		
		System.out.println(Skeleton.getObjectName(object)+"."+methodName+"("+paramNames+")");
		tabok++;
	}*/
	
	public static void print(Object object, String methodName, Object... params) {
		for (int i = 0; i < tabok; i++) {
			System.out.print("\t");
		}
		String paramNames = "";
		for(int i = 0; i < params.length; i++)
			paramNames += params[i]==null?"null":getObjectName(params[i])!=null ? getObjectName(params[i]) : params[i].toString()+", ";
		if(paramNames.endsWith(", ")) paramNames = paramNames.substring(0, paramNames.length()-2);	
		System.out.println(Skeleton.getObjectName(object)+"."+methodName+"("+paramNames+")");
		tabok++;
	}
	
	/**
	 * Eggyel kiljebb állítja a tabulálást.
	 * @throws IllegalStateException - Ha többször lett meghívva, mint a print
	 */
	public static void ret() {
		tabok--;
		if (tabok < 0) {
			throw new IllegalStateException("Tabulálás nem lehet negatív");
		}
	}
	
	private static HashMap<Integer, String> objektumok = new HashMap<Integer, String>();
	
	public static void addObjectName(Object o, String szoveg) {
		int hash = System.identityHashCode(o);
		objektumok.put(hash, szoveg);
	}
	
	public static String getObjectName(Object o) {
		return objektumok.get(System.identityHashCode(o));
	}
	
	
}
