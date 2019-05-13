package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.DrawPanel;
import objektumok.Csempe;

public class BejaratView implements Drawable {
	
	/**
     * A reprezentált Bejáratra referencia.
     */
    private final Csempe represented;
    
    /**
     * A Bejáratot ábrázoló kép.
     */
    private final BufferedImage img;
    
    /**
     * Konstruktor.
     * @param represented - A modelben lévő Csokiautomata.
     * @param img - A modelben lévő kép a Csokiautomatáról.
     */
    public BejaratView(Csempe represented, BufferedImage img) {
        this.represented = represented;
        this.img = img;
    }
    
    /**
     *Kirajzolja a Bejáratot ábrázoló képet. 
     */
    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        
        CsempeView pos = represented.getView();
        int xTopLeft = pos.getX() - 24;
        int yTopLeft = pos.getY() - 24;
        g.drawImage(img, xTopLeft, yTopLeft, 48,48, null);   
    }
}
