package objektumok;

import java.util.*;

import skeletonApp.Skeleton;

/**
 * A pláza kijáratát reprezentálja. A kijáraton való távozás után a bejáraton jön vissza az orangután.
 *  */
public class Kijarat extends Dolog {
	
	/**
	 * Az aktuális játék.
	 *  */
	private Game game;

	/**
	 * A pláza bejárata, amelyen az orangután visszajön miután távozik a kijáraton
	 *  */
	private Bejarat bejarat;
	
	/**
	 * A paraméterül kapott orángutánt, ami rálépett a kijáratra, átteszi a bejárathoz.
	 * Az orángután után álló pandákat a láncban eltűnteti, növeli annyival a pontszámot,
	 * amennyi panádt kivezetett az orángután.
	 * @param Az orangután aki rálépett a kijáratra
	 *  */
	@Override
	public void hitBy(Orangutan o) {
		Skeleton.print(this, "hitBy", o);	
		Allat allat = o;
		ArrayList<Allat> hatsok = new ArrayList<Allat>();
		while(allat.getHatsoMancs()!=null) { // Amíg vannak a jelenleg vizsgált állat mögött
			game.addPoints(1); // Pontszám növelés
			hatsok.add(allat.getHatsoMancs());
			allat = allat.getHatsoMancs();
		}				
		Collections.reverse(hatsok);
		for(Allat a : hatsok) a.die(); // Hátulról kezdve töröljük a lánc végét
		o.leptet(bejarat.getCsempe().getRandomSzomszed()); // Léptetjük az orangutánt a bejárat melletti véletlenszerű csempére
		Skeleton.ret();
	}
	/**
	 * Beállítja az ehhez a kijárathoz tartozó bejáratot, hogy ha itt
	 * megy ki egy orangután, hol jöjjön vissza.
	 * @param b A beállítandó bejárat
	 */
	public void setBejarat(Bejarat b) {
		bejarat = b;
	}
	
	/**
	 * Beállítja a game attribútumot a paraméterként kapottra
	 * @param g A beállítandó érték
	 */
	public void setGame(Game g) {
		game = g;
	}
}