import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a purple piece to be used for laser maze. The laser can bounce off this piece
 * from only two directions, and can be both rotated and dragged
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class PurplePiece extends JPanel implements MouseListener, MouseMotionListener {

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Toolkit toolkit;
    private Image botLeft;
    private Image topLeft;
    private Image topRight;
    private Image botRight;
    private Image questionMark;
    private Image[] imgArr;
    private int currentIndex;
    int xCoordinate, yCoordinate;
    int xOffset, yOffset;
    boolean held = false;

    /**
     * This method creates a new purple piece n the board at the given starting position.
     * The default is position 0 when going from a question mark.
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
        questionMark = toolkit.getImage("project4images\\PurpleQuestionMark.jpg");
        imgArr = new Image[5];
        imgArr[0] = botLeft;
        imgArr[1] = topLeft;
        imgArr[2] = topRight;
        imgArr[3] = botRight;
        imgArr[4] = questionMark;

        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
        typeOfPiece = "PurplePiece";
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

    /**
     * This method gets the current state of the purple piece for PaintComponent
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