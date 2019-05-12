
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
        
        osszekot(c[2 ], c[1 ]);
        osszekot(c[2 ], c[5 ]);
        osszekot(c[2 ], c[6 ]);
        osszekot(c[2 ], c[7 ]);
        osszekot(c[2 ], c[8 ]);
        osszekot(c[2 ], c[4 ]);
        osszekot(c[2 ], c[3 ]);
        osszekot(c[6 ], c[9 ]);
        osszekot(c[7 ], c[11]);
        osszekot(c[4 ], c[13]);
        osszekot(c[12], c[8 ]);
        osszekot(c[12], c[11]);
        osszekot(c[12], c[16]);
        osszekot(c[12], c[14]);
        osszekot(c[12], c[13]);
        osszekot(c[12], c[13]);
        osszekot(c[1 ], c[5 ]);
        osszekot(c[5 ], c[6 ]);
        osszekot(c[6 ], c[7 ]);
        osszekot(c[7 ], c[8 ]);
        osszekot(c[8 ], c[4 ]);
        osszekot(c[4 ], c[3 ]);
        osszekot(c[15], c[16]);
        osszekot(c[16], c[18]);
        osszekot(c[11], c[18]);
        osszekot(c[18], c[21]);
        osszekot(c[9 ], c[17]);
        osszekot(c[17], c[20]);
        osszekot(c[10], c[6 ]);
        osszekot(c[10], c[7 ]);
        osszekot(c[10], c[9 ]);
        osszekot(c[10], c[11]);
        osszekot(c[10], c[17]);
        osszekot(c[10], c[18]);
        osszekot(c[10], c[21]);
        osszekot(c[10], c[20]);
        osszekot(c[10], c[25]);
        osszekot(c[25], c[20]);
        osszekot(c[25], c[27]);
        osszekot(c[25], c[28]);
        osszekot(c[25], c[29]);
        osszekot(c[25], c[30]);
        osszekot(c[25], c[26]);
        osszekot(c[25], c[22]);
        osszekot(c[25], c[21]);
        osszekot(c[20], c[27]);
        osszekot(c[27], c[28]);
        osszekot(c[28], c[29]);
        osszekot(c[29], c[30]);
        osszekot(c[30], c[26]);
        osszekot(c[26], c[22]);
        osszekot(c[22], c[21]);
        osszekot(c[19], c[15]);
        osszekot(c[19], c[16]);
        osszekot(c[19], c[18]);
        osszekot(c[19], c[21]);
        osszekot(c[19], c[22]);
        osszekot(c[19], c[23]);
        osszekot(c[19], c[24]);
        osszekot(c[30], c[36]);
        osszekot(c[23], c[24]);
        osszekot(c[24], c[32]);
        osszekot(c[32], c[33]);
        osszekot(c[33], c[34]);
        osszekot(c[34], c[37]);
        osszekot(c[36], c[37]);
        osszekot(c[37], c[38]);
        osszekot(c[22], c[23]);
        osszekot(c[31], c[23]);
        osszekot(c[31], c[26]);
        osszekot(c[31], c[36]);
        osszekot(c[31], c[34]);
        osszekot(c[31], c[32]);
        osszekot(c[35], c[38]);
        osszekot(c[35], c[37]);
        osszekot(c[35], c[36]);
        osszekot(c[35], c[30]);
        osszekot(c[35], c[29]);
        osszekot(c[35], c[40]);
        osszekot(c[35], c[39]);
        osszekot(c[40], c[29]);
        osszekot(c[40], c[41]);
        osszekot(c[28], c[41]);
        osszekot(c[0 ], c[41]);
        osszekot(c[0 ], c[39]);
        osszekot(c[40], c[39]);


        Orangutan o = Builder.createOrangutan(c[5]);
        Orangutan o2 = Builder.createOrangutan(c[10]);
        Game.getInstance().setActiveOrangutan(o);
        
        Builder.createBejarat(c[2]);
        Kijarat kijarat = Builder.createKijarat(c[35], c[2]);        
        Csokiautomata csokiautomata = Builder.createCsokiautomata(c[19]);
        Jatekgep jatekgep = Builder.createJatekgep(c[25]);
        
        Ugros ugros = Builder.createUgros(c[9]);
        Ulos ulos = Builder.createUlos(c[20]);
        Ulos ulos2 = Builder.createUlos(c[40]);
        Ijedos ijedos = Builder.createIjedos(c[39]);
        Ijedos ijedos2 = Builder.createIjedos(c[18]);
        Ugros ugros2 = Builder.createUgros(c[32]);
        /*Szekreny szekreny1;
        Szekreny szekreny2 = Builder.createSzekreny(c[14], szekreny1);
        szekreny1 = Builder.createSzekreny(c[38], szekreny2);*/
        
        
        
    }
    
    private static int id = 0;
    public static void osszekot(Csempe c1, Csempe c2) {
        c1.setNeighbour(id++, c2);
        c2.setNeighbour(id++, c1);
    }
}
