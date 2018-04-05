import javax.swing.*;

public class PlayGame {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Laser Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object levels[] = {"Beginner", "Advanced"};
        int n = JOptionPane.showOptionDialog(frame, "What level would you like to choose",
                "Level of difficulty", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, levels, levels[1]);
        if(n == 0)//beginner
        {
            BeginnerPanel bPanel = new BeginnerPanel();
            frame.getContentPane().add(bPanel);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }
        else//advanced
        {
            AdvancedPanel aPanel = new AdvancedPanel();
            frame.getContentPane().add(aPanel);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }
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
