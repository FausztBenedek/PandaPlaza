package view;

import java.awt.image.BufferedImage;

import objektumok.Kijarat;

public class KijaratView extends DefaultView<Kijarat>{
	
	/**
     * Konsturktor.
     * @param kijarat A Kijaratra referencia.
     * @param img A betöltött kép.
     */
    public KijaratView(Kijarat kijarat, BufferedImage img) {
        super(kijarat, img);
    }
}
