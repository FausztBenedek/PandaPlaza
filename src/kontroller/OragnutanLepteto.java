
package kontroller;

import GUI.DrawPanel;
import objektumok.Csempe;
import objektumok.Game;
import objektumok.Orangutan;
import view.CsempeView;

public class OragnutanLepteto implements MouseBeKiListener{

    CsempeView active;
    
    @Override
    public void onArrive(CsempeView cs) {
        boolean aktivOrangutanMellett = false;
        Orangutan aktivOrangutan = Game.getInstance().getActiveOrangutan();
        for (Csempe szomszedCsempe : cs.getRepresented().getAllNeighbours()) {
            if (szomszedCsempe.getDolog() == aktivOrangutan) {
                aktivOrangutanMellett = true;
            }
        }
        
        if (aktivOrangutanMellett) {
            active = cs;
            cs.setDifferentColor(true);
        }
        
        DrawPanel.getInstance().repaint();
    }

    @Override
    public void onLeave(CsempeView cs) {
        cs.setDifferentColor(false);
        DrawPanel.getInstance().repaint();
    }

}
