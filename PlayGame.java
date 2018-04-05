package GamePieces;

import javax.swing.*;
import java.awt.*;

public class PlayGame extends JPanel {



    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Laser Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        BoardPanel bPanel = new BoardPanel();
        PiecesPanel pPanel = new PiecesPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        bPanel.setOpaque(false);
        pPanel.setOpaque(true);

        mainPanel.add(bPanel);
        mainPanel.add(pPanel);

        frame.getContentPane().add(mainPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                }
            }
        });
    }
}
