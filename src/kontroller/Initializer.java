
package kontroller;

import GUI.DrawPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import view.*;
import objektumok.*;

/**
 * Inicializálja a pályát.
 */
public class Initializer {
    
    public static MouseBeKiPoller mouseBeKiEvent = new MouseBeKiPoller();
    public static BufferedImage orangutanImage;

    /**
     * Inicializálja a pályát.
     */
    public static void initialize() {
        try {
            orangutanImage = ImageIO.read(new File("img/gorilla.png"));
        } catch (IOException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        DrawPanel drawPanel = DrawPanel.getInstance();
        drawPanel.addMouseMotionListener(mouseBeKiEvent);
        mouseBeKiEvent.subscribe(new CsempeSzinezo());
        
        Csempe c1 = createCsempe(100,100);
        Csempe c2 = createCsempe(200,100);
        
        Orangutan o = new Orangutan();
        o.setCsempe(c1);
                
        OrangutanView oView = new OrangutanView(o, orangutanImage);
        View.getInstance().add(oView);
        
        c1.setDolog(o);
    }
    
    public static Csempe createCsempe(int x, int y) {
        Csempe c = new Csempe();
        CsempeView cView = new CsempeView(c, x, y);
        c.setView(cView);
        mouseBeKiEvent.addCsempeView(cView);
        View.getInstance().add(cView);
        return c;
    }
}
