
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
    
    /**
     * Orángutánok váltására szolgáló objektum.
     */
    private static OrangutanValto orangutanValto = new OrangutanValto();
    
    /**
     * ITickables heterogén kollekciója. 
     */
    private static Ticker ticker = new Ticker();

    /**
     * Az orángutánok képe.
     */
    private static BufferedImage orangutanImage = null;
    /**
     * A csokiautomata képe.
     */
    private static BufferedImage csokiautomataImage = null;
    
    /**
     * Az Ugrosok képe.
     */
    private static BufferedImage ugrosImage = null;
    
    /**
     * Az Ulosök képe.
     */
    private static BufferedImage ulosImage = null;
    
    /**
     * Az Ijedosök képe.
     */
    private static BufferedImage ijedosImage = null;
    
    /**
     * A Szekrenyek képe.
     */
    private static BufferedImage szekrenyImage = null;
    
    /**
     * A játékgép képe.
     */
    private static BufferedImage jatekgepImage = null;
    
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
    
    /**
     * Elkészít és inicializál egy csokiautómatát
     * @param pos A kezdő csempe
     * @return Az elkészített csokiautomata
     * @throws IllegalArgumentException Ha a kezdő csempén már van valami.
     */
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
        ticker.subscribe(c, 1);
        return c;
    }
    
    /**
     * Elkészít és inicializál egy Ugrost.
     * @param startPos Az Ugros kezdő csempéje.
     * @return Az elkészített Ugrós.
     * @throws IllegalArgumentException Ha az Ugróst olyan csempére akarjuk
     * inicializálni, ahol már van egy dolog.
     */
    public static Ugros createUgros(Csempe startPos) throws IllegalArgumentException {
        if (startPos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Ugros ugros = new Ugros();
        ugros.setCsempe(startPos);
        startPos.setDolog(ugros);
        // Kép betöltése, ha még nincs betöltve.
        if (ugrosImage == null) {
            try {
            	ugrosImage = ImageIO.read(new File(ImagePaths.ugros));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        PandaView ugrosVeiw = new PandaView(ugros, ugrosImage);
        View.getInstance().add(ugrosVeiw);
        return ugros;
    }
    
    /**
     * Elkészít és inicializál egy Ulost.
     * @param startPos Az Ulos kezdő csempéje.
     * @return Az elkészített Ulos.
     * @throws IllegalArgumentException Ha az Ulost olyan csempére akarjuk
     * inicializálni, ahol már van egy dolog.
     */
    public static Ulos createUlos(Csempe startPos) throws IllegalArgumentException {
        if (startPos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Ulos ulos = new Ulos();
        ulos.setCsempe(startPos);
        startPos.setDolog(ulos);
        // Kép betöltése, ha még nincs betöltve.
        if (ulosImage == null) {
            try {
            	ulosImage = ImageIO.read(new File(ImagePaths.ulos));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        PandaView ugrosVeiw = new PandaView(ulos, ulosImage);
        View.getInstance().add(ugrosVeiw);
        return ulos;
    }
    
    /**
     * Elkészít és inicializál egy Szekrenyt.
     * @param startPos A Szekreny kezdő csempéje.
     * @return Az elkészített Szekreny.
     * @throws IllegalArgumentException Ha az Szekrenyt olyan csempére akarjuk
     * inicializálni, ahol már van egy dolog.
     */
    public static Szekreny createSzekreny(Csempe startPos) throws IllegalArgumentException {
        if (startPos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Szekreny szekreny = new Szekreny();
        szekreny.setCsempe(startPos);
        startPos.setDolog(szekreny);
        // Kép betöltése, ha még nincs betöltve.
        if (szekrenyImage == null) {
            try {
            	szekrenyImage = ImageIO.read(new File(ImagePaths.szekreny));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        SzekrenyView ugrosVeiw = new SzekrenyView(szekreny, szekrenyImage);
        View.getInstance().add(ugrosVeiw);
        return szekreny;
    }
    
    /**
     * Elkészít és inicializál egy Ijedost.
     * @param startPos Az Ijedos kezdő csempéje.
     * @return Az elkészített Ijedos.
     * @throws IllegalArgumentException Ha az Ijedost olyan csempére akarjuk
     * inicializálni, ahol már van egy dolog.
     */
    public static Ijedos createIjedos(Csempe startPos) throws IllegalArgumentException {
        if (startPos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Ijedos ijedos = new Ijedos();
        ijedos.setCsempe(startPos);
        startPos.setDolog(ijedos);
        // Kép betöltése, ha még nincs betöltve.
        if (ijedosImage == null) {
            try {
            	ijedosImage = ImageIO.read(new File(ImagePaths.ijedos));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        PandaView ugrosVeiw = new PandaView(ijedos, ijedosImage);
        View.getInstance().add(ugrosVeiw);
        return ijedos;
    }
    /**
     * Elkészít és inicializál egy Jatekgep-et.
     * @param startPos Az Ulos kezdő csempéje.
     * @return Az elkészített Ulos.
     * @throws IllegalArgumentException Ha az Ulost olyan csempére akarjuk
     * inicializálni, ahol már van egy dolog.
     */ 
    public static Jatekgep createJatekgep(Csempe startPos) throws IllegalArgumentException {
        if (startPos.getDolog() != null) {
            throw new IllegalArgumentException("A csempén már van egy dolog.");
        }
        Jatekgep j = new Jatekgep();
        j.setCsempe(startPos);
        startPos.setDolog(j);
        // Kép betöltése, ha még nincs betöltve.
        if (jatekgepImage == null) {
            try {
                jatekgepImage = ImageIO.read(new File(ImagePaths.jatekgep));
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }
        JatekgepView jView = new JatekgepView(j, jatekgepImage);
        View.getInstance().add(jView);
        ticker.subscribe(j, 1);
        return j;
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
    
    public static Ticker getTicker() {
        return ticker;
    }
}
