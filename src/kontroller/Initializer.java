
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
      
        double sx = 1.5;
        double sy = 1.5;
        int dy = 30;
        c[0] = Builder.createCsempe((int)(sx* 530), dy+(int)(sy* 45));
        c[1] = Builder.createCsempe( (int)(sx* 38), dy+(int)(sy*34));
        c[2] = Builder.createCsempe( (int)(sx* 36), dy+(int)(sy*103));
        c[3] = Builder.createCsempe( (int)(sx* 32), dy+(int)(sy*178));
        c[4] = Builder.createCsempe( (int)(sx* 87), dy+(int)(sy*187));
        c[5] = Builder.createCsempe( (int)(sx* 96), dy+(int)(sy*41));
        c[6] = Builder.createCsempe( (int)(sx*146), dy+(int)(sy*63));
        c[7] = Builder.createCsempe( (int)(sx*151), dy+(int)(sy*113));
        c[8] = Builder.createCsempe( (int)(sx*133), dy+(int)(sy*164));
        c[9] = Builder.createCsempe( (int)(sx*185), dy+(int)(sy*28));
       c[10] = Builder.createCsempe( (int)(sx*232), dy+(int)(sy*90));
       c[11] = Builder.createCsempe( (int)(sx*192), dy+(int)(sy*152));
       c[12] = Builder.createTorekenycsempe((int)(sx*160), dy+(int)(sy*209));
       c[13] = Builder.createCsempe( (int)(sx*108), dy+(int)(sy*239));
       c[14] = Builder.createCsempe( (int)(sx*158), dy+(int)(sy*283));
       c[15] = Builder.createCsempe( (int)(sx*220), dy+(int)(sy*307));
       c[16] = Builder.createCsempe( (int)(sx*214), dy+(int)(sy*236));
       c[17] = Builder.createCsempe( (int)(sx*242), dy+(int)(sy*25));
       c[18] = Builder.createCsempe( (int)(sx*248), dy+(int)(sy*183));
       c[19] = Builder.createCsempe( (int)(sx*299), dy+(int)(sy*267));
       c[20] = Builder.createCsempe( (int)(sx*297), dy+(int)(sy*44));
       c[21] = Builder.createCsempe( (int)(sx*302), dy+(int)(sy*181));
       c[22] = Builder.createCsempe( (int)(sx*347), dy+(int)(sy*200));
       c[23] = Builder.createCsempe( (int)(sx*366), dy+(int)(sy*244));
       c[24] = Builder.createCsempe( (int)(sx*359), dy+(int)(sy*300));
       c[25] = Builder.createCsempe( (int)(sx*361), dy+(int)(sy*104));
       c[26] = Builder.createCsempe( (int)(sx*397), dy+(int)(sy*172));
       c[27] = Builder.createCsempe( (int)(sx*353), dy+(int)(sy*33));
       c[28] = Builder.createCsempe( (int)(sx*417), dy+(int)(sy*44));
       c[29] = Builder.createCsempe( (int)(sx*435), dy+(int)(sy*93));
       c[30] = Builder.createCsempe( (int)(sx*431), dy+(int)(sy*138));
       c[31] = Builder.createTorekenycsempe((int)(sx*418), dy+(int)(sy*226));
       c[32] = Builder.createCsempe( (int)(sx*417), dy+(int)(sy*283));
       c[33] = Builder.createCsempe( (int)(sx*464), dy+(int)(sy*307));
       c[34] = Builder.createCsempe( (int)(sx*469), dy+(int)(sy*249));
       c[35] = Builder.createCsempe( (int)(sx*528), dy+(int)(sy*128));
       c[36] = Builder.createCsempe( (int)(sx*475), dy+(int)(sy*177));
       c[37] = Builder.createCsempe( (int)(sx*522), dy+(int)(sy*203));
       c[38] = Builder.createCsempe( (int)(sx*570), dy+(int)(sy*189));
       c[39] = Builder.createCsempe( (int)(sx*570), dy+(int)(sy*82));
       c[40] = Builder.createCsempe( (int)(sx*487), dy+(int)(sy*83));
       c[41] = Builder.createCsempe( (int)(sx*469), dy+(int)(sy*19));

        
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
        osszekotCsempe(c[14], c[15]);

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
    
    /**
     * Összeköti a paraméterül kapott két Csempét. 
     * @param c1 - Az egyik Csempe.
     * @param c2 - A másik Csempe.
     */
    public static void osszekotCsempe(Csempe c1, Csempe c2) {
        c1.setNeighbour(id++, c2);
        c2.setNeighbour(id++, c1);
    }
    
    /**
     * Összeköti a paraméterül kapott két Szekrényt. 
     * @param sz1 - Az egyik Szekrény.
     * @param sz2 - A másik Szekrény.
     */
    public static void osszekotSzekreny(Szekreny sz1 ,Szekreny sz2) {
        sz1.setMasik(sz2);
        sz2.setMasik(sz1);
    }
}
