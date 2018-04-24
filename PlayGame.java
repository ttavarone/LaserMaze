import javax.swing.*;

/**
 * This class is used to set up and pay the game. The player selects
 * the card level they want to do, and then proceeds to play
 * on the board of that level.
 * 
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, 
 * Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class PlayGame {
    /**
     * This method sets up the JFrame for the game, and then prompts the 
     * user for the level of difficulty they want to do. The choice by the
     * user determines which board is made.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Laser Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object levels[] = {"Beginner", "Advanced"};
        int n = JOptionPane.showOptionDialog(frame, 
                "What level would you like to choose", "Level of difficulty", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, levels, levels[1]);
        if(n == 0)//beginner
        {
            BoardPanel bPanel = new BoardPanel(0);
            frame.getContentPane().add(bPanel);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }
        else//advanced
        {
            BoardPanel aPanel = new BoardPanel(1);
            frame.getContentPane().add(aPanel);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }
    }

    /**
     * This method creates the GUI that will begin to execute the program.
     * @param args - Command line arguments.
     */
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
