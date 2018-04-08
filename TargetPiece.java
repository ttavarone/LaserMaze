import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a target piece to be used for laser maze. The laser must end at the target on this piece, 
 * and the laser can bounce off of the side with mirrors. Since this piece does not have to rotate or move,
 * there is no Mouse Listener
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class TargetPiece extends Piece{

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Toolkit toolkit;
    private Image bottom;
    private Image left;
    private int currentIndex;
    int xCoordinate, yCoordinate;

    /**
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public TargetPiece(int startingPos, int startingX, int startingY) {
        toolkit = Toolkit.getDefaultToolkit();
        
        bottom = toolkit.getImage("project4images\\TargetBottom.jpg");
        left = toolkit.getImage("project4images\\TargetRight.jpg");
        imgArr = new Image[2];
        imgArr[0] = bottom;
        imgArr[1] = left;
        
        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
        typeOfPiece = "YellowPiece";
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
