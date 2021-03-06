import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
////////////////////////////////////////////////////////////////////////////////
/**
 * This class creates a purple piece to be used for laser maze.
 * The laser can bounce off this piece from only two directions, 
 * and can be both rotated and dragged
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, 
 * Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class PurplePiece extends Piece implements MouseListener,
 MouseMotionListener {

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected Toolkit toolkit;
    private Image botLeft;
    private Image topLeft;
    private Image topRight;
    private Image botRight;
    private Image questionMark;
    private int currentIndex;
    int xCoordinate, yCoordinate;
    int xOffset, yOffset;
    boolean held = false;
    /**
     * This method creates a new purple piece on the board at the
     * given starting position. The default is position 0
     * when going from a question mark.
     * @param startingPos - the starting position of the piece.
     * @param startingX - the starting x position
     * @param startingY - the starting y position
     */
    public PurplePiece(int startingPos, int startingX, int startingY) {
        toolkit = Toolkit.getDefaultToolkit();
        botLeft = toolkit.getImage("project4images\\BotLeftPurple.jpg");
        topLeft = toolkit.getImage("project4images\\TopLeftPurple.jpg");
        topRight = toolkit.getImage("project4images\\TopRightPurple.jpg");
        botRight = toolkit.getImage("project4images\\BotRightPurple.jpg");
        questionMark = toolkit.getImage(
        "project4images\\PurpleQuestionMark.jpg");
        imgArr = new Image[5];
        imgArr[0] = botLeft;
        imgArr[1] = topLeft;
        imgArr[2] = topRight;
        imgArr[3] = botRight;
        imgArr[4] = questionMark;

        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
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
            if(currentIndex >= 3)
            {
                currentIndex = 0;
            }
            else
            {
                currentIndex += 1;
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
     * @param e - Event where mouse is moved and held down
     */
    @Override
    public void mouseDragged( MouseEvent e) {
        if(held)
        {
            xCoordinate = e.getX() + xOffset;
            yCoordinate = e.getY() + yOffset;
        }
    }
    
    /**
     * This method gets the current row the piece is in. 
     * It is -1 if not on board.
     * @return row - current row of piece on the game board.
     */
    public int getRow()
    {
        return row;
    }
  
    /**
     * This method gets the current column the piece is in. 
     * It is -1 if not on board.
     * @return col - current column of piece on the game board.
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * This method sets the new location on the board for the piece. 
     * @param newRow - new row the piece is in on the board.
     * @param newCol - new column the piece is in on the board.
     */
    public void setLocation(int newRow, int newCol)
    {
        row = newRow;
        col = newCol;
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