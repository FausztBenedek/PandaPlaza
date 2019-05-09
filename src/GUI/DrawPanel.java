
package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import view.View;

/**
 * Erre a JPanel-re rajzolódik ki a játék. Ebben az osztályban lévő Graphics objektumot
 * használja minden View osztály. Ez egy singleton osztály.
 */
public class DrawPanel extends JPanel {

    /**
     * Konstruktor, levédve a singleton tervezési mintának megfelelően.
     * @param size A rajzolófelület mérete.
     */
    private DrawPanel(Dimension size) {
        setPreferredSize(size);
    }
    
    /**
     * Az singleton objektum.
     */
    private static DrawPanel instance = new DrawPanel(MainFrame.getScreenSize());
    
    /**
     * Getter a singleton objektumra.
     * @return 
     */
    public static DrawPanel getInstance() {
        return instance;
    }
    
    /**
     * A fő kirajzoló metódus.
     * @param g Ezt használjuk a rajzoláshoz. Minden újrarajzolásnál frissítjük
     * vele a statikus graphics attribútumot.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setG(g);
        View viewCollection = View.getInstance();
        viewCollection.drawAll();
    }
    
    /**
     * Az objektum, mivel rajzolunk.
     */
    private static Graphics graphics;
    
    /**
     * Getter az Graphics objektumra, amivel rajzolunk.
     * @return 
     */
    public static Graphics getG() {
        return graphics;
    }
    
    /**
     * A globális statikus objektumra setter.
     * @param g 
     */
    protected static void setG(Graphics g) {
        graphics = g;
    }
}
