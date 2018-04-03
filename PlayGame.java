package GamePieces;

import javax.swing.*;

public class PlayGame {

    static JFrame frame = new JFrame("Laser Maze");

    private static void createAndShowBoard() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoardPanel bPanel = new BoardPanel();
        frame.getContentPane().add(bPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowPieces() {
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PiecesPanel pPanel = new PiecesPanel();
        frame.getContentPane().add(pPanel);

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
                    createAndShowBoard();
                    createAndShowPieces();
                    Thread.sleep(1000);
                } catch (InterruptedException I) {
                }
            }
        });
        Thread pieces = new Thread(new Runnable() {
            public void run(){

            }
        });
    }
}
