
package view;

import GUI.DrawPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import objektumok.Fotel;

public class FotelView implements Drawable {

    BufferedImage pandaBenneImage;
    BufferedImage defaultImage;
    Fotel fotel;
    
    public FotelView(Fotel represented, BufferedImage defaultImg, BufferedImage pandaBenne) {
        this.fotel = represented;
        this.defaultImage = defaultImg;
        this.pandaBenneImage = pandaBenne;
    }
    
    @Override
    public void draw() {
        Graphics g = DrawPanel.getG();
        // This image will be drawn.
        BufferedImage img;
        if (fotel.getPanda() != null) {
            img = pandaBenneImage;
        } else {
            img = defaultImage;
        }
        //Kép kirajzolása a megfelelő helyre
        CsempeView pos = fotel.getCsempe().getView();
        int xTopLeft = pos.getX() - 31;
        int yTopLeft = pos.getY() - 31;
        g.drawImage(img, xTopLeft, yTopLeft, 62,62, null);
    }
}
