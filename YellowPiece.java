import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a blue piece to be used for laser maze. The laser must go through the center
 * of this piece to work. This piece can be rotated, but not dragged.
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public class YellowPiece extends JPanel implements MouseListener {

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Toolkit toolkit;
    private Image horizontal;
    private Image vertical;
    private Image yellowQ;
    private Image[] imgArr;
    private int currentIndex;
    int xCoordinate, yCoordinate;

    /**
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public YellowPiece(int startingPos, int startingX, int startingY) {
        toolkit = Toolkit.getDefaultToolkit();

        horizontal = toolkit.getImage("project4images\\HorizontalYellow.jpg");
        vertical = toolkit.getImage("project4images\\VerticalYellow.jpg");
        yellowQ = toolkit.getImage("YellowQuestionMark.jpg");
        imgArr = new Image[3];
        imgArr[0] = horizontal;
        imgArr[1] = vertical;
        imgArr[2] = yellowQ;

        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
        typeOfPiece = "YellowPiece";
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
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mousePressed( MouseEvent e ) { }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseReleased( MouseEvent e ) { }

    /**
     * This method gets the current state of the yellow piece for PaintComponent
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
