
package kontroller;

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
        View viewCollection = View.getInstance();
        
        Csempe c = new Csempe();
        CsempeView cView = new CsempeView(c, 100, 100);
        
        viewCollection.add(cView);
    }
}
