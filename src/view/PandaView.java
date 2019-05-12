package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.DrawPanel;
import objektumok.Panda;

public class PandaView implements Drawable {

	/**
     * A Pandár referencia.
     */
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
            if (!panda.isDead()&&panda.getCsempe()!=null) {            	
                Graphics g = DrawPanel.getG();
                CsempeView pos = panda.getCsempe().getView();
                
                int xTopLeft = pos.getX() - 29;
                int yTopLeft = pos.getY() - 29;
                g.drawImage(img, xTopLeft, yTopLeft, 58, 58, null);		
            }
	}
}
