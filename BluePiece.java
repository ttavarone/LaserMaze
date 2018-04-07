import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a blue piece to be used for laser maze. The laser can bounce off this piece
 * from all four directions, and can be both rotated and dragged.
 * 
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class BluePiece extends Piece implements MouseListener, MouseMotionListener{

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected Toolkit toolkit;
    private Image topLeft;
    private Image topRight;
    private Image questionMark;
    private int currentIndex;
    private int xCoordinate, yCoordinate;
    private int xOffset, yOffset;
    private boolean held = false;

    /**
     * This method creates a new blue piece n the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     * @param startingX - the starting x position
     * @param startingY - the starting y position
     */
    public BluePiece(int startingPos, int startingX, int startingY) {
        toolkit = Toolkit.getDefaultToolkit();

        topLeft = toolkit.getImage("project4images\\TopLeftBotRightBlue.jpg");
        topRight = toolkit.getImage("project4images\\TopRightBotLeftBlue.jpg");
        questionMark = toolkit.getImage("project4images\\BlueQuestionMark.jpg");
        imgArr = new Image[3];
        imgArr[0] = topLeft;
        imgArr[1] = topRight;
        imgArr[2] = questionMark;

        PIECE_WIDTH = 100;
        PIECE_HEIGHT = 100;

        currentIndex = startingPos;
        xCoordinate = startingX;
        yCoordinate = startingY;

        addMouseListener(this);
    }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseEntered( MouseEvent e ) { }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseExited( MouseEvent e ) { }

    /**
     * This method will rotate the image or change from a question mark
     * if the image is right clicked
     * @param e - The event where the mouse is clicked down
     */
    @Override
    public void mouseClicked( MouseEvent e ) {
        int button = e.getButton();
        if(button == 3)
        {
            if(currentIndex == 0)
            {
                currentIndex = 1;
            }
            else
            {
                currentIndex = 0;
            }
        }
        repaint();
    }

    /**
     * This method will grab the piece and the offset of the piece
     * if the piece is pressed down by a left click.
     * @param e - The event where the mouse is pushed down but not lifted
     */
    @Override
    public void mousePressed( MouseEvent e ) {
        int button = e.getButton();
        if(button == 1)
        {
            held = true;
            xOffset = xCoordinate - e.getX();
            yOffset = yCoordinate - e.getY();
        }
    }

    /**
     * This method will release an image if the left click is released
     * and the piece was previously held.
     * @param e - The event where the mouse button is pulled up
     */
    @Override
    public void mouseReleased( MouseEvent e ) {
        int button = e.getButton();
        if(button == 1)
        {
            held = false;
        }
    }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseMoved( MouseEvent e ){  }

    /**
     * This event will allow the object to be dragged from where the cursor 
     * was pressed down, but only if it was pressed down first.
     * @param e - the event where the mouse is moved while a button is held down
     */
    @Override
    public void mouseDragged( MouseEvent e) {
        if(held)
        {
            xCoordinate = e.getX() + xOffset;
            yCoordinate = e.getY() + yOffset;
        }
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
