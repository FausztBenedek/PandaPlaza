
package GUI;

import javax.swing.JFrame;
import kontroller.Initializer;

public class Main {

    public static void main(String[] args) {
        //1. Create the frame.
        JFrame frame = new MainFrame("Panda Plaza");

        //2. What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Initializer.initialize();
        
        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }
}
