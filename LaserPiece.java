import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LaserPiece extends JPanel implements MouseListener {

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
        
        addMouseListener(this);
    }
    
    @Override
    public void mouseEntered( MouseEvent e ) { }

    @Override
    public void mouseExited( MouseEvent e ) { }

    @Override
    public void mouseClicked( MouseEvent e ) {   }

    @Override
    public void mousePressed( MouseEvent e ) { }

    @Override
    public void mouseReleased( MouseEvent e ) { }
    
    /**
     * This method gets the current state of the laser piece to paint onto the PaintComponent
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
