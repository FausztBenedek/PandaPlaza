
package view;

import java.awt.image.BufferedImage;
import objektumok.Jatekgep;

/**
 * Játékgépet kirajzoló objektum.
 */
public class JatekgepView extends DefaultView<Jatekgep> {

    /**
     * Konsturktor.
     * @param jatekgep A jatekgépre referencia.
     * @param img A betöltött kép.
     */
    public JatekgepView(Jatekgep jatekgep, BufferedImage img) {
        super(jatekgep, img);
    }
}
