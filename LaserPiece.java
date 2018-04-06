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

    /**
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public LaserPiece(int startingPos) {
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
        
        addMouseListener(this);
    }

    public void paintPiece(Graphics g) {
        paintComponent(g);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imgArr[currentIndex], 0, 190, this);
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
}
