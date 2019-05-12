
package kontroller;

import GUI.DrawPanel;
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
        // Eseménydobálók inicializálása
        drawPanel.addMouseMotionListener(Builder.getMouseBeKiEvent());
        // Orángutánt léptető logika inicializálása
        OrangutanLepteto orangutanLepteto = new OrangutanLepteto();
        drawPanel.addMouseListener(orangutanLepteto); // Kattintás detektálásához
        Builder.getMouseBeKiEvent().subscribe(orangutanLepteto); // Csempékbe való be-, kilépések detektálásához
        // Orángutánt váltó logika inicializálása
        drawPanel.addMouseListener(Builder.getOrangutanValto());
        Builder.getMouseBeKiEvent().subscribe(Builder.getOrangutanValto());
        // ITickable tickeltetési logikájának inicializálása
        orangutanLepteto.subscribe(Builder.getTicker());
        
        CsempeAdder csempeAdder = new CsempeAdder();
        drawPanel.addMouseListener(csempeAdder);        
    }
    
    private static int id = 0;
    private static void osszekot(Csempe c1, Csempe c2) {
        c1.setNeighbour(id++, c2);
        c2.setNeighbour(id++, c1);
    }
}
