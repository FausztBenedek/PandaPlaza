
package kontroller;

import GUI.DrawPanel;
import javax.swing.event.AncestorListener;
import view.*;
import objektumok.*;

/**
 * Inicializálja a pályát.
 */
public class Initializer {
    
    public static MouseBeKiPoller mouseBeKiEvent = new MouseBeKiPoller();

    /**
     * Inicializálja a pályát.
     */
    public static void initialize() {
        DrawPanel drawPanel = DrawPanel.getInstance();
        drawPanel.addMouseMotionListener(mouseBeKiEvent);
        mouseBeKiEvent.subscribe(new CsempeSzinezo());
        
        createCsempe(100,100);
        createCsempe(200,100);
    }
    
    public static Csempe createCsempe(int x, int y) {
        Csempe c = new Csempe();
        CsempeView cView = new CsempeView(c, x, y);
        mouseBeKiEvent.addCsempeView(cView);
        View.getInstance().add(cView);
        return c;
    }
}
