
package kontroller;

import GUI.DrawPanel;
import java.awt.Color;
import view.CsempeView;

public class CsempeSzinezo implements MouseBeKiListener{

    @Override
    public void onArrive(CsempeView cs) {
        cs.setColor(Color.GREEN);
        DrawPanel.getInstance().repaint();
    }

    @Override
    public void onLeave(CsempeView cs) {
        cs.setColor(Color.WHITE);
        DrawPanel.getInstance().repaint();
    }

}
