
package view;

import GUI.DrawPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import objektumok.Csokiautomata;

public class CsokiautomataView implements Drawable {

   /**
     * A reprezentált csokiautomatára referencia.
     */
    private final Csokiautomata represented;
    
    /**
     * Az csokiautomatát ábrázoló kép.
     */
    private final BufferedImage img;
    
    /**
     * Konstruktor.
     * @param represented 
     */
    public CsokiautomataView(Csokiautomata represented, BufferedImage img) {
        this.represented = represented;
        this.img = img;
    }

    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        
        CsempeView pos = represented.getCsempe().getView();
        int xTopLeft = pos.getX() - img.getWidth() / 2;
        int yTopLeft = pos.getY() - img.getHeight() / 2;
        g.drawImage(img, xTopLeft, yTopLeft, null);
    }
}
