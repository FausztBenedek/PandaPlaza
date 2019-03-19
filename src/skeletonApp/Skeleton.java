package skeletonApp;

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
	public static void print(String methodName) {
		for (int i = 0; i < tabok; i++) {
			System.out.print("\t");
		}
		System.out.println(methodName);
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
}
