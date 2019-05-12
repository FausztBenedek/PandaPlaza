
package kontroller;

import GUI.DrawPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import objektumok.Csempe;
import objektumok.Game;
import objektumok.Orangutan;
import view.CsempeView;

/**
 * Az aktív orángután lépetéséért felelős osztály.
 * Folyamatosan figyeli, hogy melyik csempére lépett be az egérmutató, és ha
 * az az aktív orángután mellett van, akkor kattintás esetén 
 * (csak bal gomb) lépteti az orángutánt.
 * Lépés esetén eventet dob a feliratkozott ActionListenereknek
 */
public class OrangutanLepteto implements MouseBeKiListener, MouseListener {

    /**
     * Vagy null, vagy az aktív orángután mellett lévő csempére mutató referencia.
     */
    CsempeView lepesLehetoseg;
    
    /**
     * Eventet kapnak, ha az orángután lépett.
     */
    ArrayList<ActionListener> actionsOnLepes = new ArrayList<>();
    
    /**
     * Ezzel a metódussal lehet feliratkozni az eseményre.
     * A feliratkozóknak meghívódik az actionPerformed metódusa, ha az orángután
     * lépett.
     * @param subscriber A feliratkozó.
     */
    public void subscribe(ActionListener subscriber) {
        actionsOnLepes.add(subscriber);
    }
    
    /**
     * Beállítja az lepesLehetoseg: csempeView attribútumot, ha egy aktív orángután
     * melletti a paraméterként átadott csempe.
     * @param cs A vizsgált csemepe.
     */
    @Override
    public void onArrive(CsempeView cs) {
        // Megállapítjuk, hogy a csempe aktív orángután mellett van-e.
        boolean aktivOrangutanMellett = false;
        Orangutan aktivOrangutan = Game.getInstance().getActiveOrangutan();
        for (Csempe szomszedCsempe : cs.getRepresented().getAllNeighbours()) {
            if (szomszedCsempe.getDolog() == aktivOrangutan) {
                aktivOrangutanMellett = true;
                break;
            }
        }
        
        // Ha igen, akkor beállítjuk az aktív orángutánt (még nem feltétlen 
        // lépünk, csak kattintás esetén. Ez a másik metódusban van megírva)
        if (aktivOrangutanMellett) {
            lepesLehetoseg = cs;
            // Beállítjuk a csempe színét, hogy jelezzük a felhasználónak,
            // hogy kattintás esetén lépni fog.
            cs.setDifferentColor(true);
        }
        
        // Változott a felállás => 
        DrawPanel.getInstance().repaint();
    }

    /**
     * Amikor a mutató kilép a csempéből, akkor visszaállítjuk az eredeti állapotot.
     * @param cs Amelyik csempéből kilépett a mutató. Ennek kell visszaállítani
     * az állapotát.
     */
    @Override
    public void onLeave(CsempeView cs) {
        lepesLehetoseg = null;
        // Visszaállítjuk a színét.
        cs.setDifferentColor(false);
        // Változott a felállás => 
        DrawPanel.getInstance().repaint();
    }

    /**
     * Az orángutánt lépteti, ha a feltételek teljesültek.
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // Csak bal gomb lenyomása esetén
        if (e.getButton() == MouseEvent.BUTTON1) {
            // Ha akkor kattint a felhasználó, amikor éppen olyan csempére mutat
            // a felhasználó, hogy oda léphet az aktív orángután:
            if (lepesLehetoseg != null) {
                Orangutan lepo = Game.getInstance().getActiveOrangutan();
                lepo.leptet(lepesLehetoseg.getRepresented());
                lepesLehetoseg.setDifferentColor(false);
                // Változott a felállás => 
                DrawPanel.getInstance().repaint();
                
                // Az event dobása:
                for (ActionListener action : actionsOnLepes) 
                    action.actionPerformed(null);
            }
        }
    }

    /** Nem csinál semmit */
    @Override public void mouseClicked(MouseEvent e) {    }
    /** Nem csinál semmit */
    @Override public void mouseReleased(MouseEvent e) {    }
    /** Nem csinál semmit */
    @Override public void mouseEntered(MouseEvent e) {    }
    /** Nem csinál semmit */
    @Override public void mouseExited(MouseEvent e) {    }

}
