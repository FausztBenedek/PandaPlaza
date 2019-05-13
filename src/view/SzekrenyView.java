package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.DrawPanel;
import objektumok.Szekreny;

public class SzekrenyView implements Drawable {
	/**
     * A reprezentált Szekrenyre referencia.
     */
    private final Szekreny szekreny;
    
    /**
     * A Szekrenyt ábrázoló kép.
     */
    private final BufferedImage img;
    
    /**
     * Konstruktor.
     * @param szekreny - A modelben lévő Szekreny.
     * @param img - A modelben lévő kép a Szekrenyről.
     */
    public SzekrenyView(Szekreny szekreny, BufferedImage img) {
        this.szekreny = szekreny;
        this.img = img;
    }

    /**
     *Kirajzolja a Szekrényt ábrázoló képet. 
     */
    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        
        CsempeView pos = szekreny.getCsempe().getView();
        int xTopLeft = pos.getX() - 26;
        int yTopLeft = pos.getY() - 26;
        g.drawImage(img, xTopLeft, yTopLeft, 52,52, null);
    }
}
