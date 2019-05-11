package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.DrawPanel;
import objektumok.Ugros;

public class PandaView implements Drawable {

	/**
     * Az Ugrosra referencia.
     */
    private final Ugros ugros;
    
    /**
     * Az Ugrost ábrázoló kép.
     */
    private final BufferedImage ugros_img;
    
    public PandaView(Ugros ugros, BufferedImage ugros_img) {
        this.ugros = ugros;
        this.ugros_img = ugros_img;
    }
    
	@Override
	public void draw() {
		Graphics g = DrawPanel.getG();        
		
        CsempeView pos = ugros.getCsempe().getView();
        int xTopLeft = pos.getX() - ugros_img.getWidth() / 2;
        int yTopLeft = pos.getY() - ugros_img.getHeight() / 2;
        g.drawImage(ugros_img, xTopLeft, yTopLeft, null);		
	}
}
