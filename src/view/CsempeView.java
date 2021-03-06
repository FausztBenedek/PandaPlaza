
package view;

import GUI.DrawPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import objektumok.Csempe;
import objektumok.Game;
import objektumok.Orangutan;


/** Kirajzolja a csempét. 
 * A kirajzolás színe változik. A logikát is megvalósítja.
 */

public class CsempeView implements Drawable {

    /**
     * A modellben lévő csempe.
     */
    private Csempe represented;

    /**
     * Ha igaz, akkor a csempe nem az alapértelmezett színén jelenik meg.
     */
    private boolean hasDifferentColor = false;

    /**
     * A csempék sugara.
     */
    private static final int rad = 32;
        
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
        int xBalFelso = x - rad;
        int yBalFelso = y - rad;
        // Draw neighbours
        g.setColor(Color.BLACK);
        for (Csempe szomszedCsempe : represented.getAllNeighbours()) {
            CsempeView szomszedCsempeView = szomszedCsempe.getView();        
            int xMasik = szomszedCsempeView.getX();
            int yMasik = szomszedCsempeView.getY();
            
            int dx = x-xMasik; 
            int dy = y-yMasik;            
            double angle = Math.atan2(dy, dx);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
           // g2.setStroke(new BasicStroke(1));
            g2.drawLine(x+(int)(Math.cos(angle+Math.PI)*rad), y+(int)(Math.sin(angle+Math.PI)*rad), xMasik+(int)(Math.cos(angle)*rad), yMasik+(int)(Math.sin(angle)*rad));         
          //  g.drawLine(x, y, xMasik, yMasik);
        }
        
        // Csempe rajzolása
        boolean aktivOrangutanMellett = false;
        Orangutan aktivOrangutan = Game.getInstance().getActiveOrangutan();
        for (Csempe szomszedCsempe : represented.getAllNeighbours()) {
            
            if (szomszedCsempe.getDolog() == aktivOrangutan) {
                aktivOrangutanMellett = true;
            }
        }
        boolean aktivOrangutanRajta = (represented.getDolog() == aktivOrangutan);
        g.setColor(Color.BLACK);
        g.fillOval(xBalFelso+2, yBalFelso+2, 2 * rad+3, 2 * rad+3);
        
        g.setColor(Color.WHITE);        // Default color
        if (aktivOrangutan!=null&&aktivOrangutanMellett)      g.setColor(Color.YELLOW);
        if (aktivOrangutan!=null&&aktivOrangutanRajta)        g.setColor(Color.BLUE);
        if (hasDifferentColor)          g.setColor(Color.GREEN);       
        
        
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
        return rad >= distanceFromCenter;
    }
    
    /**
     * Ha igazra van állítva, akkor a csempe színe el lesz állítva az 
     * alapértelmezettről, ha hamisra, akkor nem történik semmi.
     * @param hasDifferentColor 
     */
    public void setDifferentColor(boolean hasDifferentColor) {
        this.hasDifferentColor = hasDifferentColor;
    }
    
    /**
     * A csempét ábrázoló körnek az x koordinátája.
     * @return 
     */
    public int getX() {
        return x;
    }
    /**
     * A csempét ábrázoló körnek az y koordinátája.
     * @return 
     */
    public int getY() {
        return y;
    }
}
