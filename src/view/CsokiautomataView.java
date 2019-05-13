
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
     * @param represented - A modelben lévő Csokiautomata.
     * @param img - A modelben lévő kép a Csokiautomatáról.
     */
    public CsokiautomataView(Csokiautomata represented, BufferedImage img) {
        this.represented = represented;
        this.img = img;
    }
    
    /**
     *Kirajzolja a Csokiautomatát ábrázoló képet. 
     */
    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        
        CsempeView pos = represented.getCsempe().getView();
        //int xTopLeft = pos.getX() - img.getWidth() / 2;
        //int yTopLeft = pos.getY() - img.getHeight() / 2;
        int xTopLeft = pos.getX() - 29;
        int yTopLeft = pos.getY() - 29;
        g.drawImage(img, xTopLeft, yTopLeft, 58,58, null);
    }
}
