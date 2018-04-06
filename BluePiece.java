import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BluePiece extends JPanel implements MouseListener {

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Toolkit toolkit;
    private Image topLeft;
    private Image topRight;
    private Image questionMark;
    private Image[] imgArr;
    private int currentIndex;

    /**
     * This method creates a new blue piece n the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public BluePiece(int startingPos) {
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
        typeOfPiece = "BluePiece";
        currentIndex = startingPos;
        
        addMouseListener(this);
    }

    public void paintPiece(Graphics g) {
        paintComponent(g);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imgArr[currentIndex], 110, 110, this);
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
    public void mousePressed( MouseEvent e ) { }

    @Override
    public void mouseReleased( MouseEvent e ) { }
    
    /**
     * This method gets the current state of the blue piece to paint onto the PaintComponent
     * @return - the current state of the image.
     */
    public Image getImage()
    {
        return imgArr[currentIndex];
    }
}
