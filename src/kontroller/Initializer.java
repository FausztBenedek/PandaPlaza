
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
        
        // Pálya építése
        Csempe[] c = new Csempe[42];
        c[0] = Builder.createCsempe(530, 45);
        c[1] = Builder.createCsempe(38, 34);
        c[2] = Builder.createCsempe(36, 103);
        c[3] = Builder.createCsempe(32, 178);
        c[4] = Builder.createCsempe(87, 187);
        c[5] = Builder.createCsempe(96, 41);
        c[6] = Builder.createCsempe(146, 63);
        c[7] = Builder.createCsempe(151, 113);
        c[8] = Builder.createCsempe(133, 164);
        c[9] = Builder.createCsempe(185, 28);
        c[10] = Builder.createCsempe(232, 90);
        c[11] = Builder.createCsempe(192, 152);
        c[12] = Builder.createCsempe(160, 209);
        c[13] = Builder.createCsempe(108, 239);
        c[14] = Builder.createCsempe(158, 283);
        c[15] = Builder.createCsempe(220, 307);
        c[16] = Builder.createCsempe(214, 236);
        c[17] = Builder.createCsempe(242, 25);
        c[18] = Builder.createCsempe(248, 183);
        c[19] = Builder.createCsempe(299, 267);
        c[20] = Builder.createCsempe(297, 44);
        c[21] = Builder.createCsempe(302, 181);
        c[22] = Builder.createCsempe(347, 200);
        c[23] = Builder.createCsempe(366, 244);
        c[24] = Builder.createCsempe(359, 300);
        c[25] = Builder.createCsempe(361, 104);
        c[26] = Builder.createCsempe(397, 172);
        c[27] = Builder.createCsempe(353, 33);
        c[28] = Builder.createCsempe(417, 44);
        c[29] = Builder.createCsempe(435, 93);
        c[30] = Builder.createCsempe(431, 138);
        c[31] = Builder.createCsempe(418, 226);
        c[32] = Builder.createCsempe(417, 283);
        c[33] = Builder.createCsempe(464, 307);
        c[34] = Builder.createCsempe(469, 249);
        c[35] = Builder.createCsempe(528, 128);
        c[36] = Builder.createCsempe(475, 177);
        c[37] = Builder.createCsempe(522, 203);
        c[38] = Builder.createCsempe(570, 189);
        c[39] = Builder.createCsempe(570, 82);
        c[40] = Builder.createCsempe(487, 83);
        c[41] = Builder.createCsempe(469, 19);
        
        CsempeAdder csempeAdder = new CsempeAdder();
        drawPanel.addMouseListener(csempeAdder);        
    }
    
    private static int id = 0;
    private static void osszekot(Csempe c1, Csempe c2) {
        c1.setNeighbour(id++, c2);
        c2.setNeighbour(id++, c1);
    }
}
