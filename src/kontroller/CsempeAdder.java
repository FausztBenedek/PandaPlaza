
package kontroller;

import GUI.DrawPanel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import objektumok.Csempe;
import view.CsempeView;
import view.View;

public class CsempeAdder implements MouseListener {

    ArrayList<Point> clickeds = new ArrayList<>();
    
    private int index = 0;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Point click = new Point(e.getX(), e.getY());
            clickeds.add(click);
            View.getInstance().add(new CsempeView(new Csempe(), click.x, click.y));
            DrawPanel.getInstance().repaint();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            for (Point p : clickeds) {
                System.out.print("c[");
                System.out.print(index++);
                System.out.print("]");
                System.out.print(" = Builder.createCsempe(");
                System.out.print(p.x);
                System.out.print(", ");
                System.out.print(p.y);
                System.out.println(");");
            }
            index = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
