
package GUI;

import java.awt.Dimension;
import javax.swing.*;


/**
 * A fő ablak.
 */
public class MainFrame extends JFrame {

    /**
     * Konstruktor. Hozzáad a fő kerethez egy DrawPanel típusú JPanelt.
     * @param string 
     */
    public MainFrame(String string) {
        super(string);
        
        JPanel drawpanel = DrawPanel.getInstance();
        add(drawpanel);   
    }

    /**
     * A képernyő mérete.
     */
    private static Dimension screenSize = new Dimension(900, 500);
    
    /**
     * Akkor használd, ha szükséged van a képernyő méretére.
     * Ne változtass a visszakapott referencián!
     * @return 
     */
    public static Dimension getScreenSize() {
        return screenSize;
    }    
}
