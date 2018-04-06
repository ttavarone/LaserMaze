import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PurplePiece extends JPanel implements MouseListener {

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

    /**
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public PurplePiece(int startingPos) {
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

    /**
     * This method increases the level count and repaints the JPanel
     * @param e - The event where the mouse is clicked down
     */
    @Override
    public void mouseClicked( MouseEvent e ) {
        int button = e.getButton();
        if(button == 1)
        {
            currentIndex = ((currentIndex + 1) % 4);
        }
        else if(button == 3)
        {
            if(currentIndex == 0)
            {
                currentIndex = 3;
            }
            else
            {
                currentIndex = ((currentIndex - 1) % 4);
            }
        }
        repaint();
    }

    @Override
    public void mousePressed( MouseEvent e ) { }

    @Override
    public void mouseReleased( MouseEvent e ) { }
    
    /**
     * This method gets the current state of the purple piece to paint onto the PaintComponent
     * @return - the current state of the image.
     */
    public Image getImage()
    {
        return imgArr[currentIndex];
    }
}