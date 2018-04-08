import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class FireButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * This method creates a fire button on the board that will activate the laser
     */
    public FireButton() {
        toolkit = Toolkit.getDefaultToolkit();
        fire = toolkit.getImage("FireButton.jpg");

        PIECE_WIDTH = 100;
        PIECE_HEIGHT = 100;
    }
    
    public Image getImage()
    {
        return fire;
    }
}
