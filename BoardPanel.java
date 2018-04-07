import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * This method creates the panel based on the input it is given, then allows the player to move
 * the pieces in order to fire the laser.
 * 
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */

class BoardPanel extends JPanel implements MouseListener, MouseMotionListener
{
    protected BlankPieces[][] board;
    final private int windowWidth = 850;
    final private int windowHeight = 800;
    private int boardWidth = 600;
    private int boardHeight = 600;
    //These pieces are present on both board
    LaserPiece laser = new LaserPiece(1, 110, 230);
    TargetPiece target = new TargetPiece(0, 230, 110);
    BluePiece blue = new BluePiece(2, 725, 590);
    PurplePiece purple1 = new PurplePiece(0, 230, 590);
    PurplePiece purple2 = new PurplePiece(3, 590, 590);
    PurplePiece purple3 = new PurplePiece(2, 590, 230);
    //These pieces are only present on advanced
    YellowPiece yellow = new YellowPiece(2, 1000, 1000);//470, 350);
    PurplePiece purple4 = new PurplePiece(2, 1000, 1000);//725, 590
    boolean beginner = true;

    /**
     * This constructor creates the board based on the inputted difficulty. It also does the 
     * important task of activiating the listeners.
     * @param mode - whether the board will be in beginner or advanced
     */
    public BoardPanel(int mode)
    {

        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(windowWidth,windowHeight));
        board = new BlankPieces[5][5];

        if(mode == 1)
        {
            laser = new LaserPiece(0, 350, 110);
            target = new TargetPiece(1, 470, 230);
            blue = new BluePiece(0, 110, 470);
            purple1 = new PurplePiece(4, 725, 290);
            purple2 = new PurplePiece(4, 725, 390);
            purple3 = new PurplePiece(4, 725, 490);
            purple4 = new PurplePiece(4, 725, 590);
            yellow = new YellowPiece(2, 470, 350);
            beginner = false;
        }

        addMouseListener( this );
        addMouseMotionListener( this );
    }

    /**
     * This method creates the board for the game and all the pieces based on 
     * their x and y coordinates, as well as the current orientatio of the piece.
     * @ param g - The image to be created.
     */
    @Override
    public void paintComponent(Graphics g)
    {

        int sqDim = 120; //height and width dimensions of square

        super.paintComponent(g);
        //creating basic board square
        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 100, boardWidth, boardHeight, 50, 50);
        g.setColor(Color.BLACK);
        g.drawRoundRect(90, 90, boardWidth+20, boardHeight+20, 50, 50);
        g.fillRoundRect(90, 90, boardWidth+20, boardHeight+20, 50, 50);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(100, 100, boardWidth, boardHeight, 50, 50);

        //create inner squares
        g.setColor(Color.BLACK);
        g.drawRect(100, 100, sqDim, sqDim);
        g.drawRect(100+sqDim, 100, sqDim, sqDim);
        g.drawRect(100+sqDim*2, 100, sqDim, sqDim);
        g.drawRect(100+sqDim*3, 100, sqDim, sqDim);
        g.drawRect(100+sqDim*4, 100, sqDim, sqDim);

        g.drawRect(100, 100+sqDim, sqDim, sqDim);
        g.drawRect(100+sqDim, 100+sqDim, sqDim, sqDim);
        g.drawRect(100+sqDim*2, 100+sqDim, sqDim, sqDim);
        g.drawRect(100+sqDim*3, 100+sqDim, sqDim, sqDim);
        g.drawRect(100+sqDim*4, 100+sqDim, sqDim, sqDim);

        g.drawRect(100, 100+sqDim*2, sqDim, sqDim);
        g.drawRect(100+sqDim, 100+sqDim*2, sqDim, sqDim);
        g.drawRect(100+sqDim*2, 100+sqDim*2, sqDim, sqDim);
        g.drawRect(100+sqDim*3, 100+sqDim*2, sqDim, sqDim);
        g.drawRect(100+sqDim*4, 100+sqDim*2, sqDim, sqDim);

        g.drawRect(100, 100+sqDim*3, sqDim, sqDim);
        g.drawRect(100+sqDim, 100+sqDim*3, sqDim, sqDim);
        g.drawRect(100+sqDim*2, 100+sqDim*3, sqDim, sqDim);
        g.drawRect(100+sqDim*3, 100+sqDim*3, sqDim, sqDim);
        g.drawRect(100+sqDim*4, 100+sqDim*3, sqDim, sqDim);

        g.drawRect(100, 100+sqDim*4, sqDim, sqDim);
        g.drawRect(100+sqDim, 100+sqDim*4, sqDim, sqDim);
        g.drawRect(100+sqDim*2, 100+sqDim*4, sqDim, sqDim);
        g.drawRect(100+sqDim*3, 100+sqDim*4, sqDim, sqDim);
        g.drawRect(100+sqDim*4, 100+sqDim*4, sqDim, sqDim);

        g.drawImage(laser.getImage(), laser.getXCoord(), laser.getYCoord(), this);
        g.drawImage(blue.getImage(), blue.getXCoord(), blue.getYCoord(), this);
        g.drawImage(target.getImage(), target.getXCoord(), target.getYCoord(), this);
        g.drawImage(yellow.getImage(), yellow.getXCoord(), yellow.getYCoord(), this);
        g.drawImage(purple1.getImage(), purple1.getXCoord(), purple1.getYCoord(), this);
        g.drawImage(purple2.getImage(), purple2.getXCoord(), purple2.getYCoord(), this);
        g.drawImage(purple3.getImage(), purple3.getXCoord(), purple3.getYCoord(), this);
        g.drawImage(purple4.getImage(), purple4.getXCoord(), purple4.getYCoord(), this);
        //bp.paintPiece(g);

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
     * This method will determine if a piece is right clicked on, and if it is in the correct difficulty,
     * it will go into that pieces mouseClicked method and rotate it
     * @param e - The event where the mouse is clicked down
     */
    @Override
    public void mouseClicked( MouseEvent e ) {
        if(beginner)// blue is the only piece to rotate in beginner
        {
            if(e.getX() >= blue.getXCoord() && e.getX() <= blue.getXCoord() + 100 && e.getY() >= blue.getYCoord() && e.getY() <= blue.getYCoord() + 100)
            {
                blue.mouseClicked(e);
                repaint();
            }
        }
        else // both purple and yellow can rotate in advanced
        {
            if(e.getX() >= purple1.getXCoord() && e.getX() <= purple1.getXCoord() + 100 && e.getY() >= purple1.getYCoord() && e.getY() <= purple1.getYCoord() + 100)
            {
                purple1.mouseClicked(e);
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() && e.getX() <= purple2.getXCoord() + 100 && e.getY() >= purple2.getYCoord() && e.getY() <= purple2.getYCoord() + 100)
            {
                purple2.mouseClicked(e);
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() && e.getX() <= purple3.getXCoord() + 100 && e.getY() >= purple3.getYCoord() && e.getY() <= purple3.getYCoord() + 100)
            {
                purple3.mouseClicked(e);
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() && e.getX() <= purple4.getXCoord() + 100 && e.getY() >= purple4.getYCoord() && e.getY() <= purple4.getYCoord() + 100)
            {
                purple4.mouseClicked(e);
                repaint();
            }
            else if(e.getX() >= yellow.getXCoord() && e.getX() <= yellow.getXCoord() + 100 && e.getY() >= yellow.getYCoord() && e.getY() <= yellow.getYCoord() + 100)
            {
                yellow.mouseClicked(e);
                repaint();
            }
        }
    }

    /**
     * This method will determine if the user pressed the mouse down on a valid piece, and then send it into that
     * pieces mouse pressed handler to determine what happens.
     * @param e - when the mouse is pushed down
     */
    @Override
    public void mousePressed( MouseEvent e ) {
        if(beginner) //blue is the only piece that can be moved in beginner
        {
            if(e.getX() >= blue.getXCoord() && e.getX() <= blue.getXCoord() + 100 && e.getY() >= blue.getYCoord() && e.getY() <= blue.getYCoord() + 100)
            {
                blue.mousePressed(e);
                repaint();
            }
        }
        else // purple is the only piece that can be moved in advanced
        {
            if(e.getX() >= purple1.getXCoord() && e.getX() <= purple1.getXCoord() + 100 && e.getY() >= purple1.getYCoord() && e.getY() <= purple1.getYCoord() + 100)
            {
                purple1.mousePressed(e);
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() && e.getX() <= purple2.getXCoord() + 100 && e.getY() >= purple2.getYCoord() && e.getY() <= purple2.getYCoord() + 100)
            {
                purple2.mousePressed(e);
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() && e.getX() <= purple3.getXCoord() + 100 && e.getY() >= purple3.getYCoord() && e.getY() <= purple3.getYCoord() + 100)
            {
                purple3.mousePressed(e);
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() && e.getX() <= purple4.getXCoord() + 100 && e.getY() >= purple4.getYCoord() && e.getY() <= purple4.getYCoord() + 100)
            {
                purple4.mousePressed(e);
                repaint();
            }
        }
    }

    /**
     * This method determines if the mouse is released over a piece, and then sends it 
     * into the piece to determine what it does.
     * @param e - the event where the mouse button is pulled up.
     */
    @Override
    public void mouseReleased( MouseEvent e ) {
        if(beginner) //blue is the only piece that can be moved in beginner
        {
            if(e.getX() >= blue.getXCoord() && e.getX() <= blue.getXCoord() + 100 && e.getY() >= blue.getYCoord() && e.getY() <= blue.getYCoord() + 100)
            {
                blue.mouseReleased(e);
                repaint();
            }
        }
        else // purple is the only piece that can be moved in advanced
        {
            if(e.getX() >= purple1.getXCoord() && e.getX() <= purple1.getXCoord() + 100 && e.getY() >= purple1.getYCoord() && e.getY() <= purple1.getYCoord() + 100)
            {
                purple1.mouseReleased(e);
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() && e.getX() <= purple2.getXCoord() + 100 && e.getY() >= purple2.getYCoord() && e.getY() <= purple2.getYCoord() + 100)
            {
                purple2.mouseReleased(e);
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() && e.getX() <= purple3.getXCoord() + 100 && e.getY() >= purple3.getYCoord() && e.getY() <= purple3.getYCoord() + 100)
            {
                purple3.mouseReleased(e);
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() && e.getX() <= purple4.getXCoord() + 100 && e.getY() >= purple4.getYCoord() && e.getY() <= purple4.getYCoord() + 100)
            {
                purple4.mouseReleased(e);
                repaint();
            }
        }
    }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseMoved( MouseEvent e ){  }

    /**
     * This method determines if the mouse is dragged over a valid piece, and then sends it 
     * down into that pieces method to determine what occurs. 
     * @param e - The event where the mouse if moved while being held down.
     */
    @Override
    public void mouseDragged( MouseEvent e) {
        if(beginner) //blue is the only piece that can be moved in beginner
        {
            if(e.getX() >= blue.getXCoord() - 5 && e.getX() <= blue.getXCoord() + 105 && e.getY() >= blue.getYCoord() - 5 && e.getY() <= blue.getYCoord() + 105)
            {
                blue.mouseDragged(e);
                repaint();
            }
        }
        else //purple is the only piece that can be moved in advanced
        {
            if(e.getX() >= purple1.getXCoord() - 5 && e.getX() <= purple1.getXCoord() + 105 && e.getY() >= purple1.getYCoord() - 5 && e.getY() <= purple1.getYCoord() + 105)
            {
                purple1.mouseDragged(e);
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() - 5 && e.getX() <= purple2.getXCoord() + 105 && e.getY() >= purple2.getYCoord() -5 && e.getY() <= purple2.getYCoord() + 105)
            {
                purple2.mouseDragged(e);
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() - 5 && e.getX() <= purple3.getXCoord() + 105 && e.getY() >= purple3.getYCoord() - 5 && e.getY() <= purple3.getYCoord() + 105)
            {
                purple3.mouseDragged(e);
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() - 5 && e.getX() <= purple4.getXCoord() + 105 && e.getY() >= purple4.getYCoord() - 5 && e.getY() <= purple4.getYCoord() + 105)
            {
                purple4.mouseDragged(e);
                repaint();
            }
        }
    }
}