
package view;

import GUI.DrawPanel;
import java.awt.Color;
import java.awt.Graphics;
import objektumok.Csempe;


/** Kirajzolja a csempét. 
 * A kirajzolás színe változik. A logikát is megvalósítja.
 */

public class CsempeView implements Drawable {

    /**
     * A modellben lévő csempe.
     */
    Csempe represented;
    
    /**
     * A csempék átmérője.
     */
    private static final int rad = 20;
    
    /**
     * A csempe kék színe
     */
    private static final Color csempeBlue = new Color(15,15,255);
    
    /**
     * A csempe középpontjának a koordinátái.
     */
    int x, y;
    
    /**
     * Konstruktor. 
     * @param represented A modellben lévő csempe.
     * @param x A csempe középpontjának az x koordinátája.
     * @param y A csempe középpontjának az y koordinátája.
     */
    public CsempeView(Csempe represented, int x, int y) {
        this.represented = represented;
        this.x = x;
        this.y = y;
    }
    /**
     * Kék kört rajzol ki, ha a csempén lévő orángután az aktív, sárgát, 
     * ha az egyik szomszédos csempén van az aktív orángután, zöldet, 
     * ha a felhasználó továbblépési szándékra jelölte ki, fehéret egyébként.
     */
    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        g.setColor(Color.RED);
        int xBalFelso = x - rad;
        int yBalFelso = y - rad;
        g.fillOval(xBalFelso, yBalFelso, 2 * rad, 2 * rad);
    }
}
