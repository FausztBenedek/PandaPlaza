
package kontroller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import view.CsempeView;

/**
 * Eventeket dobó osztály a MouseBeKiListener interfészt megvalósító
 * feliratkozóknak. Kétféle eventet dob, az egyiket akkor, amikor az
 * egérmutató elhagy egy csempét, és akkor amikor éppen belép.
 */
public class MouseBeKiPoller implements MouseMotionListener {

    /**
     * A csempeView-k gyűjteménye, amelyeket megvizsgál, hogy bennük van-e
     * a mutató.
     */
    ArrayList<CsempeView> csempeViewCollection = new ArrayList<>();
    
    /**
     * A feliratkozók gyűjteménye.
     */
    ArrayList<MouseBeKiListener> observers = new ArrayList<>();
    
    /**
     * Egy feliratkozó ezzel a metódussal tud feliratkozni.
     * @param subscriber 
     */
    public void subscribe(MouseBeKiListener subscriber) {
        observers.add(subscriber);
    }
    
    /**
     * Ezzel tudunk hozzáadni olyan csempeView-kat, amelyeket 
     * megvizsgál, hogy bennük van-e a mutató.
     * @param c 
     */
    public void addCsempeView(CsempeView c) {
        csempeViewCollection.add(c);
    }

    /**
     * Az a csempe, amelyiken a mutató éppen van. Ha nincs egy csempén sem, 
     * akkor null.
     */
    CsempeView active = null;

    /**
     * Nem valósít meg semilyen logikát.
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Ebben a metódusban megvizsgáljuk, hogy a mutató éppen hol van, illetve
     * hol volt az előbb. Ennek megfelelően dobáljuk az eseményeket a
     * feliratkozók (observers) számára.
     * @param e 
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        Point pos = e.getPoint();
        // Logikai szétválasztási ág: van-e olyan csempe, amelyikben benne van a mutató
        
        // Ha nincs csempe, amelyikben benne lenne a mutató, 
        // akkor mindegyik csempét lekérdezzük.
        if (active == null) {
            for (CsempeView csempeView : csempeViewCollection) {
                if (csempeView.isInside(pos.x, pos.y)) {
                    // És ha sikerült megtalálni azt, amelyikben benne van a mutató
                    // akkor dobjuk az eseményt. 
                    // (Ez csak úgy történhetett, ha éppen most került bele)
                    active = csempeView;
                    for (MouseBeKiListener observer : observers) {
                        observer.onArrive(active);
                    }
                }
            }
        } 
        // Ha van csempe, amelyikben benne van a mutató, 
        // akkor csak akkor van dolgunk, ha éppen kilépett onnan.
        else {
            
            // Ha a mutató kilépett:
            if ( ! active.isInside(pos.x, pos.y)) {
                // És dobjuk az eseményt, hogy kiléptünk.
                for (MouseBeKiListener observer : observers) {
                    observer.onLeave(active);
                }
                active = null;
            }
        }
    }
}
