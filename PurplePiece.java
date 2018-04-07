import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
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
     * This method gets the current state of the purple piece to paint onto the PaintComponent
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