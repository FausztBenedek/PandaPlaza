package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.DrawPanel;
import objektumok.Panda;
import objektumok.Ugros;

public class PandaView implements Drawable {

	/**
     * A Pandár referencia.
     */
    //private final Ugros ugros;
    private final Panda panda;
    
    /**
     * A Pandát ábrázoló kép.
     */
    private final BufferedImage img;
    
    /**
     * Konstruktor.
     * @param panda - A modelben lévő Panda.
     * @param img - A modelben lévő kép a Pandáról.
     */
    public PandaView(Panda panda, BufferedImage img) {
        this.panda = panda;
        this.img = img;
    }
    
    /**
     *Kirajzolja a Pandát ábrázoló képet. 
     */
	@Override
	public void draw() {
            // Halott pandákat nem rajzolunk ki. Onnan tudjuk, hogy egy
            // panda halott, hogy nincs csempéje.
            if (panda.getCsempe() != null) {
                Graphics g = DrawPanel.getG();        

                CsempeView pos = panda.getCsempe().getView();
                int xTopLeft = pos.getX() - img.getWidth() / 2;
                int yTopLeft = pos.getY() - img.getHeight() / 2;
                g.drawImage(img, xTopLeft, yTopLeft, null);		
            }
	}
}
