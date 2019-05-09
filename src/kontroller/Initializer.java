
package kontroller;

import GUI.DrawPanel;
import javax.swing.event.AncestorListener;
import view.*;
import objektumok.*;

/**
 * Inicializálja a pályát.
 */
public class Initializer {
    /**
     * Inicializálja a pályát.
     */
    public static void initialize() {
        DrawPanel drawPanel = DrawPanel.getInstance();
        
        View viewCollection = View.getInstance();
        
        MouseBeKiPoller mouseBeKiEvent = new MouseBeKiPoller();
        mouseBeKiEvent.subscribe(new CsempeSzinezo());
        
        Csempe c = new Csempe();
        CsempeView cView = new CsempeView(c, 100, 100);
        mouseBeKiEvent.addCsempeView(cView);
        drawPanel.addMouseMotionListener(mouseBeKiEvent);
        
        viewCollection.add(cView);
    }
}
