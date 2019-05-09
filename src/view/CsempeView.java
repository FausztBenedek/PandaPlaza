
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
    private Csempe represented;
    
    /**
     * A csempe színe.
     */
    private Color color = Color.WHITE;
    
    /**
     * A csempék sugara.
     */
    private static final int rad = 20;
        
    /**
     * A csempe középpontjának a koordinátái.
     */
    private int x, y;
    
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
        g.setColor(color);
        int xBalFelso = x - rad;
        int yBalFelso = y - rad;
        g.fillOval(xBalFelso, yBalFelso, 2 * rad, 2 * rad);
    }

    /**
     * A modellben lévő csempére getter.
     * @return 
     */
    public Csempe getRepresented() {
        return represented;
    }

    /**
     * Annak a meghatározására, hogy a csempén belül van-e
     * a paraméterként átadott pont.
     * @param x A pont x koordinátája
     * @param y A pont y koordinátája
     * @return True, ha a pont a csempében van, false, ha nem.
     */
    public boolean isInside(int x, int y) {
        // távolság = sqrt( (x-cx)^2 + (y-cy)^2 )
        // Vagyis a középpontból a paraméterként átadott pontba mutató vektor hossza
        // c a center, itt most cx = this.x, cy = this.y
        
        double xDistance = Math.abs(x - this.x);
        double yDistance = Math.abs(y - this.y);
        
        double distanceFromCenter = Math.sqrt(
                xDistance * xDistance + yDistance * yDistance);
        
        // Ha ez a távolság kisebb, mint a sugár => benne van a pont a körben.
        return rad >= xDistance;
    }
    
    /**
     * A csempe színe.
     * @return A csempe aktuális színe.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Beállítja a csempe színét.
     * @param color Az új szín
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
