
package view;

import java.util.ArrayList;
import java.util.List;

/**
 * Az összes kirajzolható, vagyis a Drawable interfészt implementáló objektumot 
 * tartalmazó heterogén kollekciót tartalmazó singleton osztály.
 */
public class View {
    
    /**
     * Singleton konstruktor: levédve
     */
    protected View() {}
    
    /**
     * A singleton objektum.
     */
    private static View instance = new View();
    
    /**
     * Getter a singleton View objektumra.
     * @return 
     */
    public static View getInstance() {
        return instance;
    }
    
    /**
     * A kirajzolható objektumokat tartalmazó gyűjtemény.
     */
    List<Drawable> collection = new ArrayList<>();
    
    /**
     * Hozzáad egy objektumot, ami ke lesz rajzolva.
     */
    public void add(Drawable obj) {
        collection.add(obj);
    }
    
    /**
     * Kirajzolja az összes objektumot.
     */
    public void drawAll() {
        for (Drawable d : collection) {
            d.draw();
        }
    }
    
    /**
     * Törli az objektumot a kirajzolhatóak listájából.
     * @param obj 
     */
    public void remove(Drawable obj) {
        collection.remove(obj);
    }
}
