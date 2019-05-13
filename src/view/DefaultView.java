
package view;

import GUI.DrawPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import objektumok.Dolog;

/**
 * Ha valamelyik View-nak csak egy képet kell tudnia kirajzolni, akkor a kód
 * duplikációt elkerülvén ebből az osztályból származtatható.
 * @param <T> A dolog, amelynek a View-jét le akarjuk egyszerűsíteni.
 */
public class DefaultView<T extends Dolog> implements Drawable {
    
    /**
     * A reprezentált Dolog-ra referencia.
     */
    private final T represented;
    
    /**
     * A Dolgot ábrázoló kép.
     */
    private final BufferedImage img;
    
    /**
     * Konstruktor.
     * @param represented - A modelben lévő dolog.
     * @param img - A modelben lévő kép a dologról már betöltve.
     */
    public DefaultView(T represented, BufferedImage img) {
        this.represented = represented;
        this.img = img;
    }

    /**
     *Kirajzolja a dolgot ábrázoló képet. 
     */
    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        
        CsempeView pos = represented.getCsempe().getView();
      /*  int xTopLeft = pos.getX() - img.getWidth() / 2;
        int yTopLeft = pos.getY() - img.getHeight() / 2;
        g.drawImage(img, xTopLeft, yTopLeft, null);*/
        
        int xTopLeft = pos.getX() - 24;
        int yTopLeft = pos.getY() - 24;
        g.drawImage(img, xTopLeft, yTopLeft, 48,48, null);
    }

}
