
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
        // Eseménydobálók inicializálása
        drawPanel.addMouseMotionListener(mouseBeKiEvent);
        // Orángutánt léptető logika inicializálása
        OrangutanLepteto orangutanLepteto = new OrangutanLepteto();
        drawPanel.addMouseListener(orangutanLepteto);
        mouseBeKiEvent.subscribe(orangutanLepteto);
        
        // 3x3-as négyzet sorfojtonosan
        Csempe c1 = createCsempe(100,100); Csempe c2 = createCsempe(200,100); Csempe c3 = createCsempe(300,100);
        Csempe c4 = createCsempe(100,200); Csempe c5 = createCsempe(200,200); Csempe c6 = createCsempe(300,200);        
        Csempe c7 = createCsempe(100,300); Csempe c8 = createCsempe(200,300); Csempe c9 = createCsempe(300,300);
        
        // Vízszintes kapcsolatok
        osszekot(1, c1, c2);
        osszekot(2, c2, c3);
        osszekot(3, c4, c5);
        osszekot(4, c5, c6);
        osszekot(5, c7, c8);
        osszekot(6, c8, c9);
        // Függőleges kapcsolatok
        osszekot(7, c1, c4);
        osszekot(8, c4, c7);
        osszekot(9, c2, c5);
        osszekot(10, c5, c8);
        osszekot(11, c3, c6);
        osszekot(12, c6, c9);
        
        Orangutan o = createOrangutan(c5);
        Orangutan o2 = createOrangutan(c9);
        Game.getInstance().setActiveOrangutan(o);
    }
    
    public static void osszekot(int id, Csempe c1, Csempe c2) {
        c1.setNeighbour(id, c2);
        c2.setNeighbour(id, c1);
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
