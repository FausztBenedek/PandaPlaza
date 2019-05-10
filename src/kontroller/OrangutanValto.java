
package kontroller;

import GUI.DrawPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import objektumok.Game;
import objektumok.Orangutan;
import view.CsempeView;

public class OrangutanValto implements MouseBeKiListener, MouseListener {

    CsempeView potencialisCsempeView;
    Orangutan potencialisOrangutan;
    
    ArrayList<Orangutan> orangutanok = new ArrayList<>();
    
    public void addOrangutan(Orangutan o) {
        orangutanok.add(o);
    }
    
    @Override
    public void onArrive(CsempeView cs) {
        for (Orangutan potencialisAktiv : orangutanok) {
            if (cs.getRepresented().getDolog() == potencialisAktiv) {
                if (potencialisAktiv != Game.getInstance().getActiveOrangutan()) {
                    potencialisCsempeView = cs;
                    potencialisCsempeView.setDifferentColor(true);
                    potencialisOrangutan = potencialisAktiv;
                    // Változott a felállás => 
                    DrawPanel.getInstance().repaint();
                }
            }
        }
    }

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


    @Override
    public void mousePressed(MouseEvent e) {
        if (potencialisCsempeView != null) {
            Game.getInstance().setActiveOrangutan(potencialisOrangutan);
            potencialisCsempeView.setDifferentColor(false);
            // Változott a felállás => 
            DrawPanel.getInstance().repaint();
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
