
package kontroller;

import GUI.DrawPanel;
import objektumok.*;

/**
 * Inicializálja a pályát.
 */
public class Initializer {
    
    /**
     * Inicializálja a pályát.
     */
    public static void initialize() {
        DrawPanel drawPanel = DrawPanel.getInstance();
        // Eseménydobálók inicializálása
        drawPanel.addMouseMotionListener(Builder.getMouseBeKiEvent());
        // Orángutánt léptető logika inicializálása
        OrangutanLepteto orangutanLepteto = new OrangutanLepteto();
        drawPanel.addMouseListener(orangutanLepteto); // Kattintás detektálásához
        Builder.getMouseBeKiEvent().subscribe(orangutanLepteto); // Csempékbe való be-, kilépések detektálásához
        // Orángutánt váltó logika inicializálása
        drawPanel.addMouseListener(Builder.getOrangutanValto());
        Builder.getMouseBeKiEvent().subscribe(Builder.getOrangutanValto());
        // ITickable tickeltetési logikájának inicializálása
        orangutanLepteto.subscribe(Builder.getTicker());
        
        // 3x3-as négyzet sorfojtonosan
        Csempe c1 = Builder.createCsempe(100,100); Csempe c2 = Builder.createCsempe(200,100); Csempe c3 = Builder.createCsempe(300,100);
        Csempe c4 = Builder.createCsempe(100,200); Csempe c5 = Builder.createCsempe(200,200); Csempe c6 = Builder.createCsempe(300,200);        
        Csempe c7 = Builder.createCsempe(100,300); Csempe c8 = Builder.createCsempe(200,300); Csempe c9 = Builder.createCsempe(300,300);
        Csempe cA = Builder.createCsempe(100,400); Csempe cB = Builder.createCsempe(200,400); Csempe cC = Builder.createCsempe(300,400);
        
        // Vízszintes kapcsolatok
        osszekot(1, c1, c2);
        osszekot(2, c2, c3);
        osszekot(3, c4, c5);
        osszekot(4, c5, c6);
        osszekot(5, c7, c8);
        osszekot(6, c8, c9);
        // Függőleges kapcsolatok
        osszekot(7, c1, c4);
        osszekot(8, c4, c7);
        osszekot(9, c2, c5);
        osszekot(10, c5, c8);
        osszekot(11, c3, c6);
        osszekot(12, c6, c9);

        // Utolsó szint
        osszekot(13, c7, cA);
        osszekot(14, c9, cC);
        osszekot(15, cA, cB);
        osszekot(16, cB, cC);

        Orangutan o = Builder.createOrangutan(c5);
        Orangutan o2 = Builder.createOrangutan(c9);
        Game.getInstance().setActiveOrangutan(o);
        
        Csokiautomata csokiautomata = Builder.createCsokiautomata(cC);
        Ugros ugros = Builder.createUgros(c1);
        Ulos ulos = Builder.createUlos(c4);
        Ijedos ijedos = Builder.createIjedos(c7);
        //Szekreny szekreny = Builder.createSzekreny(c3);
        Jatekgep jatekgep = Builder.createJatekgep(cA);
        Kijarat kijarat = Builder.createKijarat(c3);
    }
    
    public static void osszekot(int id, Csempe c1, Csempe c2) {
        c1.setNeighbour(id, c2);
        c2.setNeighbour(id, c1);
    }
}
