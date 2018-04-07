import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a laser piece to be used for laser maze. The laser will originate from this piece.
 * Since this piece does not have to rotate or move, there is no Mouse Listener.
 * 
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class LaserPiece extends JPanel{

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Toolkit toolkit;
    private Image bottom;
    private Image right;
    private Image[] imgArr;
    private int currentIndex;
    int xCoordinate, yCoordinate;

    /**
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public LaserPiece(int startingPos, int startingX, int startingY) {
        toolkit = Toolkit.getDefaultToolkit();

        bottom = toolkit.getImage("project4images\\LaserBottom.jpg");
        right = toolkit.getImage("project4images\\LaserRight.jpg");
        imgArr = new Image[2];
        imgArr[0] = bottom;
        imgArr[1] = right;

        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
        typeOfPiece = "LaserPiece";
        currentIndex = startingPos;
        xCoordinate = startingX;
        yCoordinate = startingY;
    }

    /**
     * This method gets the current state of the laser piece for PaintComponent
     * @return - the current state of the image.
     */
    public Image getImage()
    {
        return imgArr[currentIndex];
    }

    /**
     * This method returns the current xCoordinate of the piece
     * @return - the current position of the object on the x axis
     */
    public int getXCoord()
    {
        return xCoordinate;
    }

    /**
     * This method returns the current yCoordinate of the piece
     * @return - the current position of the object on the y axis
     */
    public int getYCoord()
    {
        return yCoordinate;
    }
}
