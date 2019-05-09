
package kontroller;

import GUI.DrawPanel;
import java.awt.Color;
import view.CsempeView;

public class CsempeSzinezo implements MouseBeKiListener{

    @Override
    public void onArrive(CsempeView cs) {
        cs.setColor(Color.BLACK);
        DrawPanel.getInstance().repaint();
    }

    @Override
    public void onLeave(CsempeView cs) {
        cs.setColor(Color.YELLOW);
        DrawPanel.getInstance().repaint();
    }

}
