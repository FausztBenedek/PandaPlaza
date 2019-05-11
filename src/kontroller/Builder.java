
package kontroller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import objektumok.*;
import view.*;

/**
 * Olyan statikus függvények gyűjteménye, amelyek a játékhoz szükséges objektumokat
 * készítik el, és inicializálják. (pl.: hozzákötik a View-hez vagy betültenek
 * egy képet stb)
 */
public class Builder {
    
    /**
     * Eventeket dobáló objektum, amikor az egér belép egy csempére, vagy
     * kilép egy csempéről. Azért van itt tárolva, mert egy két objektumhoz
     * tartozó View-nak fel kell ezekre az eseményekre iratkoznia.
     */
    private static MouseBeKiPoller mouseBeKiEvent = new MouseBeKiPoller();
    
    private static OrangutanValto orangutanValto = new OrangutanValto();

    /**
     * Az orángutánok képe.
     */
    private static BufferedImage orangutanImage = null;
    /**
     * A csokiautomata képe.
     */
    private static BufferedImage csokiautomataImage = null;
    
    /**
     * Elkészít és inicializál egy csempét.
     * @param x A csempét megjelenítő kör x koordinátája.
     * @param y A csempét megjelenítő kör y koordinátája.
     * @return Az elkészített csempe.
     */
    public static Csempe createCsempe(int x, int y) {
        Csempe c = new Csempe();
        CsempeView cView = new CsempeView(c, x, y);
        c.setView(cView);
        mouseBeKiEvent.addCsempeView(cView);
        View.getInstance().add(cView);
        return c;
    }
    
    /**
     * Elkészít és inicializál egy orángutánt.
     * @param startPos Az orángután kezdő csempéje.
     * @return Az elkészített orángután.
     * @throws IllegalArgumentException Ha az orángutánt olyan csempére akarjuk
     * inicializálni, ahol már van egy dolog.
     */
    public static Orangutan createOrangutan(Csempe startPos) throws IllegalArgumentException {
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
        orangutanValto.addOrangutan(o);
        OrangutanView oVeiw = new OrangutanView(o, orangutanImage);
        View.getInstance().add(oVeiw);
        return o;
    }
    
    public static Csokiautomata createCsokiautomata(Csempe pos) throws IllegalArgumentException {
        if (pos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Csokiautomata c = new Csokiautomata();
        // Összekötjük a csempével.
        c.setCsempe(pos);
        pos.setDolog(c);
        // Betöltjük a képet, ha még nem volt betöltve
        if (csokiautomataImage == null) {
            try {
                csokiautomataImage = ImageIO.read(new File(ImagePaths.csokiautomata));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        CsokiautomataView cView = new CsokiautomataView(c, csokiautomataImage);
        View.getInstance().add(cView);
        return c;
    }
    
    /**
     * Eventeket dobáló objektum, amikor az egér belép egy csempére, vagy
     * kilép egy csempéről. Azért van itt tárolva, mert egy két objektumhoz
     * tartozó View-nak fel kell ezekre az eseményekre iratkoznia.
     */
    public static MouseBeKiPoller getMouseBeKiEvent() {
        return mouseBeKiEvent;
    }
    
    
    public static OrangutanValto getOrangutanValto() {
        return orangutanValto;
    }
}
