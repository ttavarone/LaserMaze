import javax.swing.*;
import java.awt.*;
/**
 * When this button is pressed, it will fire the laser to 
 * complete the maze.
 * 
 * @author Logan, Tom, Eamonn, Tucker, Josh 
 * @version 1.0
 */
public class FireButton
{
    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected Toolkit toolkit;
    private int xCoordinate, yCoordinate;
    private int xOffset, yOffset;
    private Image fire;
    private boolean held = false;
    /**
     * This method creates a fire button on the board that will
     * activate the laser
     */
    public FireButton() {
        toolkit = Toolkit.getDefaultToolkit();
        fire = toolkit.getImage("FireButton.jpg");

        PIECE_WIDTH = 100;
        PIECE_HEIGHT = 100;
    }
    
    /**
     * This method gets the image for the class, which
     * is just the fire button.
     * @return - The image used for the fire button
     */
    public Image getImage()
    {
        return fire;
    }
}
