package kontroller;

import view.CsempeView;
/**
 * Az implementálja, aki akkor hajt végre valamit, amikor az egér
 * belépett, vagy kilépett egy csempéből.
 */
public interface MouseBeKiListener {
    /**
     * Amikor az egér éppen belépett a paraméterként átadott csempére akkor hívódik
     * meg. (Ha feliratkozott)
     * @param cs Ide lépett be az egérmutató.
     */
    public void onArrive(CsempeView cs);
    /**
     * Amikor az egér éppen klépet a paraméterként átadott csempéről akkor hívódik
     * meg. (Ha feliratkozott)
     * @param cs 
     */
    public void onLeave(CsempeView cs);
}
