package GamePieces;

import javax.swing.*;

public class PlayGame {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Laser Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoardPanel panel = new BoardPanel();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
