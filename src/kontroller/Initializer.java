
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
      /*  c[0] = Builder.createCsempe(530, 45);
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
        c[12] = Builder.createTorekenycsempe(160, 209);
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
        c[31] = Builder.createTorekenycsempe(418, 226);
        //c[31] = Builder.createCsempe(418, 226);
        c[32] = Builder.createCsempe(417, 283);
        c[33] = Builder.createCsempe(464, 307);
        c[34] = Builder.createCsempe(469, 249);
        c[35] = Builder.createCsempe(528, 128);
        c[36] = Builder.createCsempe(475, 177);
        c[37] = Builder.createCsempe(522, 203);
        c[38] = Builder.createCsempe(570, 189);
        c[39] = Builder.createCsempe(570, 82);
        c[40] = Builder.createCsempe(487, 83);
        c[41] = Builder.createCsempe(469, 19);*/
        double sx = 1.5;
        double sy = 1.5;
        
        c[0] = Builder.createCsempe((int)(sx* 530), (int)(sy* 45       ));
        c[1] = Builder.createCsempe( (int)(sx* 38), (int)(sy*34        ));
        c[2] = Builder.createCsempe( (int)(sx* 36), (int)(sy*103       ));
        c[3] = Builder.createCsempe( (int)(sx* 32), (int)(sy*178       ));
        c[4] = Builder.createCsempe( (int)(sx* 87), (int)(sy*187       ));
        c[5] = Builder.createCsempe( (int)(sx* 96), (int)(sy*41        ));
        c[6] = Builder.createCsempe( (int)(sx*146), (int)(sy*63        ));
        c[7] = Builder.createCsempe( (int)(sx*151), (int)(sy*113       ));
        c[8] = Builder.createCsempe( (int)(sx*133), (int)(sy*164       ));
        c[9] = Builder.createCsempe( (int)(sx*185), (int)(sy*28        ));
       c[10] = Builder.createCsempe( (int)(sx*232), (int)(sy*90        ));
       c[11] = Builder.createCsempe( (int)(sx*192), (int)(sy*152       ));
       c[13] = Builder.createCsempe( (int)(sx*108), (int)(sy*239       ));
       c[14] = Builder.createCsempe( (int)(sx*158), (int)(sy*283       ));
       c[15] = Builder.createCsempe( (int)(sx*220), (int)(sy*307       ));
       c[16] = Builder.createCsempe( (int)(sx*214), (int)(sy*236       ));
       c[17] = Builder.createCsempe( (int)(sx*242), (int)(sy*25        ));
       c[18] = Builder.createCsempe( (int)(sx*248), (int)(sy*183       ));
       c[19] = Builder.createCsempe( (int)(sx*299), (int)(sy*267       ));
       c[20] = Builder.createCsempe( (int)(sx*297), (int)(sy*44        ));
       c[21] = Builder.createCsempe( (int)(sx*302), (int)(sy*181       ));
       c[22] = Builder.createCsempe( (int)(sx*347), (int)(sy*200       ));
       c[23] = Builder.createCsempe( (int)(sx*366), (int)(sy*244       ));
       c[24] = Builder.createCsempe( (int)(sx*359), (int)(sy*300       ));
       c[25] = Builder.createCsempe( (int)(sx*361), (int)(sy*104       ));
       c[26] = Builder.createCsempe( (int)(sx*397), (int)(sy*172       ));
       c[27] = Builder.createCsempe( (int)(sx*353), (int)(sy*33        ));
       c[28] = Builder.createCsempe( (int)(sx*417), (int)(sy*44        ));
       c[29] = Builder.createCsempe( (int)(sx*435), (int)(sy*93        ));
       c[30] = Builder.createCsempe( (int)(sx*431), (int)(sy*138       ));
       c[32] = Builder.createCsempe( (int)(sx*417), (int)(sy*283       ));
       c[33] = Builder.createCsempe( (int)(sx*464), (int)(sy*307       ));
       c[34] = Builder.createCsempe( (int)(sx*469), (int)(sy*249       ));
       c[35] = Builder.createCsempe( (int)(sx*528), (int)(sy*128       ));
       c[36] = Builder.createCsempe( (int)(sx*475), (int)(sy*177       ));
       c[37] = Builder.createCsempe( (int)(sx*522), (int)(sy*203       ));
       c[38] = Builder.createCsempe( (int)(sx*570), (int)(sy*189       ));
       c[39] = Builder.createCsempe( (int)(sx*570), (int)(sy*82        ));
       c[40] = Builder.createCsempe( (int)(sx*487), (int)(sy*83        ));
       c[41] = Builder.createCsempe( (int)(sx*469), (int)(sy*19        ));

       c[31] = Builder.createTorekenycsempe((int)(sx*418), (int)(sy*226));
       c[12] = Builder.createTorekenycsempe((int)(sx*160), (int)(sy*209));
        
        osszekotCsempe(c[2 ], c[1 ]);
        osszekotCsempe(c[2 ], c[5 ]);
        osszekotCsempe(c[2 ], c[6 ]);
        osszekotCsempe(c[2 ], c[7 ]);
        osszekotCsempe(c[2 ], c[8 ]);
        osszekotCsempe(c[2 ], c[4 ]);
        osszekotCsempe(c[2 ], c[3 ]);
        osszekotCsempe(c[6 ], c[9 ]);
        osszekotCsempe(c[7 ], c[11]);
        osszekotCsempe(c[4 ], c[13]);
        osszekotCsempe(c[12], c[8 ]);
        osszekotCsempe(c[12], c[11]);
        osszekotCsempe(c[12], c[16]);
        osszekotCsempe(c[12], c[14]);
        osszekotCsempe(c[12], c[13]);
        osszekotCsempe(c[12], c[13]);
        osszekotCsempe(c[1 ], c[5 ]);
        osszekotCsempe(c[5 ], c[6 ]);
        osszekotCsempe(c[6 ], c[7 ]);
        osszekotCsempe(c[7 ], c[8 ]);
        osszekotCsempe(c[8 ], c[4 ]);
        osszekotCsempe(c[4 ], c[3 ]);
        osszekotCsempe(c[15], c[16]);
        osszekotCsempe(c[16], c[18]);
        osszekotCsempe(c[11], c[18]);
        osszekotCsempe(c[18], c[21]);
        osszekotCsempe(c[9 ], c[17]);
        osszekotCsempe(c[17], c[20]);
        osszekotCsempe(c[10], c[6 ]);
        osszekotCsempe(c[10], c[7 ]);
        osszekotCsempe(c[10], c[9 ]);
        osszekotCsempe(c[10], c[11]);
        osszekotCsempe(c[10], c[17]);
        osszekotCsempe(c[10], c[18]);
        osszekotCsempe(c[10], c[21]);
        osszekotCsempe(c[10], c[20]);
        osszekotCsempe(c[10], c[25]);
        osszekotCsempe(c[25], c[20]);
        osszekotCsempe(c[25], c[27]);
        osszekotCsempe(c[25], c[28]);
        osszekotCsempe(c[25], c[29]);
        osszekotCsempe(c[25], c[30]);
        osszekotCsempe(c[25], c[26]);
        osszekotCsempe(c[25], c[22]);
        osszekotCsempe(c[25], c[21]);
        osszekotCsempe(c[20], c[27]);
        osszekotCsempe(c[27], c[28]);
        osszekotCsempe(c[28], c[29]);
        osszekotCsempe(c[29], c[30]);
        osszekotCsempe(c[30], c[26]);
        osszekotCsempe(c[26], c[22]);
        osszekotCsempe(c[22], c[21]);
        osszekotCsempe(c[19], c[15]);
        osszekotCsempe(c[19], c[16]);
        osszekotCsempe(c[19], c[18]);
        osszekotCsempe(c[19], c[21]);
        osszekotCsempe(c[19], c[22]);
        osszekotCsempe(c[19], c[23]);
        osszekotCsempe(c[19], c[24]);
        osszekotCsempe(c[30], c[36]);
        osszekotCsempe(c[23], c[24]);
        osszekotCsempe(c[24], c[32]);
        osszekotCsempe(c[32], c[33]);
        osszekotCsempe(c[33], c[34]);
        osszekotCsempe(c[34], c[37]);
        osszekotCsempe(c[36], c[37]);
        osszekotCsempe(c[37], c[38]);
        osszekotCsempe(c[22], c[23]);
        osszekotCsempe(c[31], c[23]);
        osszekotCsempe(c[31], c[26]);
        osszekotCsempe(c[31], c[36]);
        osszekotCsempe(c[31], c[34]);
        osszekotCsempe(c[31], c[32]);
        osszekotCsempe(c[35], c[38]);
        osszekotCsempe(c[35], c[37]);
        osszekotCsempe(c[35], c[36]);
        osszekotCsempe(c[35], c[30]);
        osszekotCsempe(c[35], c[29]);
        osszekotCsempe(c[35], c[40]);
        osszekotCsempe(c[35], c[39]);
        osszekotCsempe(c[40], c[29]);
        osszekotCsempe(c[40], c[41]);
        osszekotCsempe(c[28], c[41]);
        osszekotCsempe(c[0 ], c[41]);
        osszekotCsempe(c[0 ], c[39]);
        osszekotCsempe(c[40], c[39]);


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
        Szekreny szekreny1 = Builder.createSzekreny(c[14]);
        Szekreny szekreny2 = Builder.createSzekreny(c[38]);        
        osszekotSzekreny(szekreny1, szekreny2);        
        Fotel fotel = Builder.createFotel(c[33]);
    }
    
    private static int id = 0;
    public static void osszekotCsempe(Csempe c1, Csempe c2) {
        c1.setNeighbour(id++, c2);
        c2.setNeighbour(id++, c1);
    }
    
    public static void osszekotSzekreny(Szekreny sz1 ,Szekreny sz2) {
        sz1.setMasik(sz2);
        sz2.setMasik(sz1);
    }
}
