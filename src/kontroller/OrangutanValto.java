
package kontroller;

import GUI.DrawPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import objektumok.Game;
import objektumok.Orangutan;
import view.CsempeView;

/**
 * Az aktív orángután váltásáért felelős osztály. Folyamatosan figyeli, hogy 
 * melyik csempére lépett be az egérmutató. Ha ebben van orángután (ami nem az
 * aktív), akkor jobb gombbal kattintás esetén lecseréli az aktív orángutánt.
 */
public class OrangutanValto implements MouseBeKiListener, MouseListener {
    
    /**
     * Ebben a referenciában vagy null-t tárolunk, vagy ha az egérmutató
     * olyan csempére mutat, amiben van potenciálisan aktív orángután (ami most még
     * nem az), akkor ahhoz tartozó csempeView-t.
     */
    private CsempeView potencialisCsempeView;
    
    /**
     * Ebben a referenciában vagy null-t tárolunk, vagy ha az egérmutató
     * olyan csempére mutat, amiben van potenciálisan aktív orángután (ami most még
     * nem az), akkor azt az orángutánt.
     */
    private Orangutan potencialisOrangutan;
    
    /**
     * Gyűjtemény az összes orángutánhoz.
     */
    private ArrayList<Orangutan> orangutanok = new ArrayList<>();
    
    /**
     * Ezzel a metódussal lehet egy orángutánt felvenni a gyűjteményhez.
     * Csakk akkor lehet az aktív orángutánt ezzel az osztállyal beállítani,
     * ha fel van véve a gyűjteménybe.
     * @param o - Az orángután, amely lehet aktív, ha rákattint a felhasználó.
     */
    public void addOrangutan(Orangutan o) {
        orangutanok.add(o);
    }
    
    /**
     * Beállítja a szükséges referenciákat, ha a paraméterként kapott csempe olyan.
     * @param cs 
     */
    @Override
    public void onArrive(CsempeView cs) {
        // Minden orángutánon végigmegyünk, hogy az adott csempén van-e.
        for (Orangutan potencialisAktiv : orangutanok) {
            if (cs.getRepresented().getDolog() == potencialisAktiv) {
                // Csak akkor csinálunk bármit is, ha a csempén lévő orángután nem az aktív.
                if (potencialisAktiv != Game.getInstance().getActiveOrangutan()) {
                    // Beállítjuk a szükséges referenciákat
                    potencialisCsempeView = cs;
                    potencialisOrangutan = potencialisAktiv;
                    // Hover effektust adunk a csempéhez
                    potencialisCsempeView.setDifferentColor(true);
                    // Változott a felállás => 
                    DrawPanel.getInstance().repaint();
                }
            }
        }
    }
    
    /**
     * Visszaállítjuk az eredeti állapotot.
     * @param cs 
     */
    @Override
    public void onLeave(CsempeView cs) {
        if (potencialisCsempeView != null) {
            potencialisCsempeView.setDifferentColor(false);
            potencialisCsempeView = null;
            potencialisOrangutan = null;
            // Változott a felállás => 
            DrawPanel.getInstance().repaint();
        }
    }

    /**
     * Ha az egérmutató éppen olyan csempe fölött van, akkor leváltjuk az
     * aktív orángutánt.
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // Csak jobb gomb lenyomása esetén.
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (potencialisCsempeView != null) {
                Game.getInstance().setActiveOrangutan(potencialisOrangutan);
                potencialisCsempeView.setDifferentColor(false);
                // Változott a felállás => 
                DrawPanel.getInstance().repaint();
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
