
package view;

import GUI.DrawPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import objektumok.Csempe;
import objektumok.Torekenycsempe;

/**
 * Kirajzol egy számot, hogy a csempének még hány élete van hátra.
 */
public class TorekenycsempeView extends CsempeView {
    
    private Torekenycsempe represented;
    private int x, y;
    private Font f = new Font("TimesRoman", Font.PLAIN, 20);
    
    public TorekenycsempeView(Torekenycsempe represented, int x, int y) {
        super(represented, x, y);
        this.represented = represented;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void draw() {
        super.draw();
        Graphics g = DrawPanel.getG();
        
        int num = represented.getElettartam();
        g.setFont(f);
        g.setColor(Color.red);
        g.drawString(Integer.toString(num), x, y);
    }
    
}
