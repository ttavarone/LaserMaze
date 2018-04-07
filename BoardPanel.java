import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class BoardPanel extends JPanel implements MouseListener, MouseMotionListener
{
    protected Pieces[][] board;
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

    public BoardPanel(int mode)
    {

        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(windowWidth,windowHeight));
        board = new Pieces[5][5];

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
        if(beginner)
        {
            if(e.getX() >= blue.getXCoord() && e.getX() <= blue.getXCoord() + 100 && e.getY() >= blue.getYCoord() && e.getY() <= blue.getYCoord() + 100)
            {
                blue.mouseClicked(e);
                repaint();
            }
        }
        else
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

    @Override
    public void mousePressed( MouseEvent e ) {
        if(beginner)
        {
            if(e.getX() >= blue.getXCoord() && e.getX() <= blue.getXCoord() + 100 && e.getY() >= blue.getYCoord() && e.getY() <= blue.getYCoord() + 100)
            {
                blue.mousePressed(e);
                repaint();
            }
        }
        else
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

    @Override
    public void mouseReleased( MouseEvent e ) {
        if(beginner)
        {
            if(e.getX() >= blue.getXCoord() && e.getX() <= blue.getXCoord() + 100 && e.getY() >= blue.getYCoord() && e.getY() <= blue.getYCoord() + 100)
            {
                blue.mouseReleased(e);
                repaint();
            }
        }
        else
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

    @Override
    public void mouseMoved( MouseEvent e ){  }

    @Override
    public void mouseDragged( MouseEvent e) {
        if(beginner)
        {
            if(e.getX() >= blue.getXCoord() - 5 && e.getX() <= blue.getXCoord() + 105 && e.getY() >= blue.getYCoord() - 5 && e.getY() <= blue.getYCoord() + 105)
            {
                blue.mouseDragged(e);
                repaint();
            }
        }
        else
        {
            if(e.getX() >= purple1.getXCoord() && e.getX() <= purple1.getXCoord() + 100 && e.getY() >= purple1.getYCoord() && e.getY() <= purple1.getYCoord() + 100)
            {
                purple1.mouseDragged(e);
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() && e.getX() <= purple2.getXCoord() + 100 && e.getY() >= purple2.getYCoord() && e.getY() <= purple2.getYCoord() + 100)
            {
                purple2.mouseDragged(e);
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() && e.getX() <= purple3.getXCoord() + 100 && e.getY() >= purple3.getYCoord() && e.getY() <= purple3.getYCoord() + 100)
            {
                purple3.mouseDragged(e);
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() && e.getX() <= purple4.getXCoord() + 100 && e.getY() >= purple4.getYCoord() && e.getY() <= purple4.getYCoord() + 100)
            {
                purple4.mouseDragged(e);
                repaint();
            }
        }
    }
}

