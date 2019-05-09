
package GUI;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        //1. Create the frame.
        JFrame frame = new MainFrame("Panda Plaza");

        //2. What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Az első inicializálás (megjelés előtt) jön ide.
        
        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }
}
