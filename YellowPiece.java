import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    /**
     * This method creates a new yellow piece on the board at the given starting position.
     * The default is position 0 when going from a question mark.
     * @param startingPos - the starting position of the piece.
     */
    public YellowPiece(int startingPos) {
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
     * This method gets the current state of the yellow piece to paint onto the PaintComponent
     * @return - the current state of the image.
     */
    public Image getImage()
    {
        return imgArr[currentIndex];
    }
}
