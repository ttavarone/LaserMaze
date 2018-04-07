import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BluePiece extends JPanel implements MouseListener, MouseMotionListener{

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected Toolkit toolkit;
    private Image topLeft;
    private Image topRight;
    private Image questionMark;
    private Image[] imgArr;
    private int currentIndex;
    int xCoordinate, yCoordinate;
    int xOffset, yOffset;
    boolean held = false;

    /**
     * This method creates a new blue piece n the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
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

    @Override
    public void mouseEntered( MouseEvent e ) { }

    @Override
    public void mouseExited( MouseEvent e ) { }

    /**
     * This method increases the level count and repaints the JPanel
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

    @Override
    public void mouseReleased( MouseEvent e ) {
        int button = e.getButton();
        if(button == 1)
        {
            held = false;
        }
    }

    @Override
    public void mouseMoved( MouseEvent e ){  }

    @Override
    public void mouseDragged( MouseEvent e) {
        if(held)
        {
            xCoordinate = e.getX() + xOffset;
            yCoordinate = e.getY() + yOffset;
        }
    }

    /**
     * This method gets the current state of the blue piece to paint onto the PaintComponent
     * @return - the current state of the image.
     */
    public Image getImage()
    {
        return imgArr[currentIndex];
    }

    public int getXCoord()
    {
        return xCoordinate;
    }

    public int getYCoord()
    {
        return yCoordinate;
    }
}
