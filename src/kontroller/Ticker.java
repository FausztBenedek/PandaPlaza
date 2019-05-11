
package kontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import objektumok.ITickable;

/**
 * Az ITickable interfészt megvalósító objektumokt tickelteti meg.
 * Ha meghívódik az actionPerformed, akkor a tick() meghívásának
 * átlagos gyakorisága állítható.
 */
public class Ticker implements ActionListener {

    /**
     * Adatstruktúra, tárolja, hogy egy adott ITickablesnek átlagosan
     * minden n-edik eventre legyen csak meghívva a tick metódusa.
     * Pl ha a gyakoriság 2, akkor átlagosan minden második tick-re
     * lesz csak meghívva a tickable tick() metódusa.
     */
    private class TickGyakorisag {
        public ITickable tickable;
        public int gyakorisag;
    }
    
    /**
     * A random számok előállításához.
     */
    private Random random = new Random();
    
    /**
     * Az ITickables heterogén kollekciója a hozzájuk tartozó gyakorisággal együtt.
     */
    private ArrayList<TickGyakorisag> tickables = new ArrayList<>();
    
    /**
     * Feliratkozik egy 
     * @param tickable
     * @param gyakorisag A tick()-ek minden ennyiedik eventre lesznek csak átlagosas meghívva.
     * Pl ha a gyakoriság 2, akkor átlagosan minden második eventre
     * lesz csak meghívva a tickable tick() metódusa.
     * Ha minden eventre meg kell hívni a tick() metódusát a feliratkozó
     * ITickables-nek, akkor a gyakoriság legyen 1.
     */
    public void subscribe(ITickable tickable, int gyakorisag) {
        TickGyakorisag elem = new TickGyakorisag();
        elem.gyakorisag = gyakorisag;
        elem.tickable = tickable;
        tickables.add(elem);
    }
    
    /**
     * Meghívja a heterogén kollekció tick() metódusát.
     * Figyeli a hívási gyakoriságot.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (TickGyakorisag ticked : tickables) {
            if (random.nextInt() % ticked.gyakorisag == 0) {
                ticked.tickable.tick();
            }
        }
    }

    
}
