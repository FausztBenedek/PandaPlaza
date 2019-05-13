
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
    private Font f = new Font("TimesRoman", Font.BOLD, 20);
    
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
        //Törékeny csempe hátrelévő élettartamának kiírása, ha törött, akkor a szám helyett X.
        if(num==0)
        	g.drawString("X", x-5, y-28);        	
        else
        	g.drawString(Integer.toString(num), x-10, y-28);
    }
    
}
