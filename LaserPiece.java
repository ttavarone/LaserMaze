import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class creates a laser piece to be used for laser maze.
 * The laser will originate from this piece.
 * 
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, 
 * Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class LaserPiece extends Piece{

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Toolkit toolkit;
    private Image bottom;
    private Image right;
    private int currentIndex;
    int xCoordinate, yCoordinate;
    /**
     * This method creates a new target piece on the board at 
     * the given starting position.
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

    @Override
    public Image getImage()
    {
        return imgArr[currentIndex];
    }

    @Override
    public int getXCoord()
    {
        return xCoordinate;
    }

    @Override
    public void setXCoord(int x)
    {
        xCoordinate = x;
    }

    @Override
    public int getYCoord()
    {
        return yCoordinate;
    }
    
    @Override
    public void setYCoord(int y)
    {
        yCoordinate = y;
    }
    
    @Override
    public int getCurrentIndex()
    {
        return currentIndex;
    }
}
