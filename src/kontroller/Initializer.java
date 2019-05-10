
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
    public static BufferedImage orangutanImage = null;

    /**
     * Inicializálja a pályát.
     */
    public static void initialize() {
        DrawPanel drawPanel = DrawPanel.getInstance();
        drawPanel.addMouseMotionListener(mouseBeKiEvent);
        mouseBeKiEvent.subscribe(new CsempeSzinezo());
        
        Csempe c1 = createCsempe(100,100);
        Csempe c2 = createCsempe(200,100);
        
        Orangutan o = createOrangutan(c1);
    }
    
    public static Csempe createCsempe(int x, int y) {
        Csempe c = new Csempe();
        CsempeView cView = new CsempeView(c, x, y);
        c.setView(cView);
        mouseBeKiEvent.addCsempeView(cView);
        View.getInstance().add(cView);
        return c;
    }
    
    public static Orangutan createOrangutan(Csempe startPos) {
        if (startPos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Orangutan o = new Orangutan();
        o.setCsempe(startPos);
        startPos.setDolog(o);
        // Kép betöltése, ha még nincs betöltve.
        if (orangutanImage == null) {
            try {
                orangutanImage = ImageIO.read(new File(ImagePaths.orangutan));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        OrangutanView oVeiw = new OrangutanView(o, orangutanImage);
        View.getInstance().add(oVeiw);
        return o;
    }
}
