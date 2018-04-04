package GamePieces;

import javax.swing.*;
import java.awt.*;

public class PlayGame {

    static JFrame frame = new JFrame("Laser Maze");

    public static void piecePanel(){
        PiecesPanel pPanel = new PiecesPanel();
        frame.getContentPane().add(pPanel);
    }


    private static void createAndShowGUI() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoardPanel bPanel = new BoardPanel();
        frame.getContentPane().add(bPanel);

        piecePanel();

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
