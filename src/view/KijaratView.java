package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.DrawPanel;
import objektumok.Csempe;
import objektumok.Kijarat;

public class KijaratView implements Drawable{
	
	Csempe csempe;
	BufferedImage img;
	/**
     * Konsturktor.
     * @param kijarat A Kijaratra referencia.
     * @param img A betöltött kép.
     */
    public KijaratView(Kijarat kijarat, BufferedImage img) {
      //  super(kijarat, img);
        this.csempe = kijarat.getCsempe();
        this.img = img; 
    }
    
    @Override
    public void draw() {  
    	Graphics g = DrawPanel.getG();
        CsempeView pos = csempe.getView();
        int xTopLeft = pos.getX() - 24;
        int yTopLeft = pos.getY() - 19;
        g.drawImage(img, xTopLeft, yTopLeft, 48,38, null);   
    }
}
