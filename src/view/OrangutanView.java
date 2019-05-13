
package view;

import GUI.DrawPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import objektumok.Orangutan;

/**
 * Tárolja az orángutánt, annak grafikus tulajdonságait és ki tudja rajzolni.
 */
public class OrangutanView implements Drawable {

    /**
     * A reprezentált orángutánra referencia.
     */
    private final Orangutan represented;
    
    /**
     * Az orángutánt ábrázoló kép.
     */
    private final BufferedImage img;
    
    /**
     * Konstruktor.
     * @param represented 
     */
    public OrangutanView(Orangutan represented, BufferedImage img) {
        this.represented = represented;
        this.img = img;
    }

    @Override
    public void draw() {
        if (!represented.isDead()) {
            Graphics g = DrawPanel.getG();

            CsempeView pos = represented.getCsempe().getView();
            int xTopLeft = pos.getX() - 25;
            int yTopLeft = pos.getY() - 25;
            g.drawImage(img, xTopLeft, yTopLeft, 50, 50, null);		
        }
    }
    
    
    
    
}
