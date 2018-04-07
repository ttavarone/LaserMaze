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
    protected Piece[][] board;
    final private int windowWidth = 850;
    final private int windowHeight = 800;
    private int boardWidth = 600;
    private int boardHeight = 600;
    //These pieces are present on both board
    protected LaserPiece laser = new LaserPiece(1, 110, 230);
    protected TargetPiece target = new TargetPiece(0, 230, 110);
    protected BluePiece blue = new BluePiece(2, 725, 590);
    protected PurplePiece purple1 = new PurplePiece(0, 230, 590);
    protected PurplePiece purple2 = new PurplePiece(3, 590, 590);
    protected PurplePiece purple3 = new PurplePiece(2, 590, 230);
    //These pieces are only present on advanced
    protected YellowPiece yellow = new YellowPiece(2, 1000, 1000);//470, 350);
    protected PurplePiece purple4 = new PurplePiece(2, 1000, 1000);//725, 590
    private boolean beginner = true;
    private boolean laserDraw = true;

    private boolean draggingPurple1 = false;
    private boolean draggingPurple2 = false;
    private boolean draggingPurple3 = false;
    private boolean draggingPurple4 = false;

    public int previousX, previousY;

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
        board = new Piece[5][6];//row 6 is for pieces not on the board

        if(mode == 1)
        {
            laser = new LaserPiece(0, 350, 110);
            board[0][2] = laser;
            target = new TargetPiece(1, 470, 230);
            board[1][3] = target;
            blue = new BluePiece(0, 110, 470);
            board[3][0] = blue;
            yellow = new YellowPiece(2, 470, 350);
            board[2][3] = yellow;
            purple1 = new PurplePiece(4, 725, 290);
            board[1][5] = purple2;
            purple2.setLocation(1,5);
            purple2 = new PurplePiece(4, 725, 390);
            board[2][5] = purple2;
            purple2.setLocation(2,5);
            purple3 = new PurplePiece(4, 725, 490);
            board[3][5] = purple3;
            purple3.setLocation(3,5);
            purple4 = new PurplePiece(4, 725, 590);
            board[4][5] = purple4;
            purple4.setLocation(4,5);
            beginner = false;
        }
        else
        {
            board[1][0] = laser;
            board[0][1] = target;
            board[4][1] = purple1;
            board[4][4] = purple2;
            board[1][4] = purple3;
            board[4][5] = blue;
            blue.setLocation(4,5);
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

        g.setColor(Color.RED);
        if(laserDraw)
        {
            laserDraw = false;
            drawLaser(2 ,0 , "right" , 0, g);
        }
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
                previousX = blue.getXCoord();
                previousY = blue.getYCoord();
                board[blue.getRow()][blue.getCol()] = null;
                repaint();
            }
        }
        else // purple is the only piece that can be moved in advanced
        {
            if(e.getX() >= purple1.getXCoord() && e.getX() <= purple1.getXCoord() + 100 && e.getY() >= purple1.getYCoord() && e.getY() <= purple1.getYCoord() + 100)
            {
                purple1.mousePressed(e);
                previousX = purple1.getXCoord();
                previousY = purple1.getYCoord();
                board[purple1.getRow()][purple1.getCol()] = null;
                draggingPurple1 = true;
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() && e.getX() <= purple2.getXCoord() + 100 && e.getY() >= purple2.getYCoord() && e.getY() <= purple2.getYCoord() + 100)
            {
                purple2.mousePressed(e);
                previousX = purple2.getXCoord();
                previousY = purple2.getYCoord();
                board[purple2.getRow()][purple1.getCol()] = null;
                draggingPurple2 = true;
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() && e.getX() <= purple3.getXCoord() + 100 && e.getY() >= purple3.getYCoord() && e.getY() <= purple3.getYCoord() + 100)
            {
                purple3.mousePressed(e);
                previousX = purple3.getXCoord();
                previousY = purple3.getYCoord();
                board[purple3.getRow()][purple3.getCol()] = null;
                draggingPurple3 = true;
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() && e.getX() <= purple4.getXCoord() + 100 && e.getY() >= purple4.getYCoord() && e.getY() <= purple4.getYCoord() + 100)
            {
                purple4.mousePressed(e);
                previousX = purple4.getXCoord();
                previousY = purple4.getYCoord();
                board[purple4.getRow()][purple4.getCol()] = null;
                draggingPurple4 = true;
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
                dropInPlace(blue, e);
                repaint();
            }
        }
        else // purple is the only piece that can be moved in advanced
        {
            if(e.getX() >= purple1.getXCoord() && e.getX() <= purple1.getXCoord() + 100 && e.getY() >= purple1.getYCoord() && e.getY() <= purple1.getYCoord() + 100)
            {
                purple1.mouseReleased(e);
                dropInPlace(purple1, e);
                draggingPurple1 = false;
                repaint();
            }
            else if(e.getX() >= purple2.getXCoord() && e.getX() <= purple2.getXCoord() + 100 && e.getY() >= purple2.getYCoord() && e.getY() <= purple2.getYCoord() + 100)
            {
                purple2.mouseReleased(e);
                dropInPlace(purple2, e);
                draggingPurple2 = false;
                repaint();
            }
            else if(e.getX() >= purple3.getXCoord() && e.getX() <= purple3.getXCoord() + 100 && e.getY() >= purple3.getYCoord() && e.getY() <= purple3.getYCoord() + 100)
            {
                purple3.mouseReleased(e);
                dropInPlace(purple3, e);
                draggingPurple3 = false;
                repaint();
            }
            else if(e.getX() >= purple4.getXCoord() && e.getX() <= purple4.getXCoord() + 100 && e.getY() >= purple4.getYCoord() && e.getY() <= purple4.getYCoord() + 100)
            {
                purple4.mouseReleased(e);
                dropInPlace(purple4, e);
                draggingPurple4 = false;
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
            if(draggingPurple1)
            {
                if(e.getX() >= purple1.getXCoord() - 5 && e.getX() <= purple1.getXCoord() + 105 && e.getY() >= purple1.getYCoord() - 5 && e.getY() <= purple1.getYCoord() + 105)
                {
                    purple1.mouseDragged(e);
                    repaint();
                }
            }
            else if(draggingPurple2)
            {
                if(e.getX() >= purple2.getXCoord() - 5 && e.getX() <= purple2.getXCoord() + 105 && e.getY() >= purple2.getYCoord() -5 && e.getY() <= purple2.getYCoord() + 105)
                {
                    purple2.mouseDragged(e);
                    repaint();
                }
            }
            else if(draggingPurple3)
            {
                if(e.getX() >= purple3.getXCoord() - 5 && e.getX() <= purple3.getXCoord() + 105 && e.getY() >= purple3.getYCoord() - 5 && e.getY() <= purple3.getYCoord() + 105)
                {
                    purple3.mouseDragged(e);
                    repaint();
                }
            }
            else if(draggingPurple4)
            {
                if(e.getX() >= purple4.getXCoord() - 5 && e.getX() <= purple4.getXCoord() + 105 && e.getY() >= purple4.getYCoord() - 5 && e.getY() <= purple4.getYCoord() + 105)
                {
                    purple4.mouseDragged(e);
                    repaint();
                }
            }
        }
    }

    public void drawLaser(int row, int col, String previous, int piecesHit, Graphics g)
    {
        if(row < 0 || row > 4 || col < 0 || col > 4)
        {
            return;
        }
        else if(board[row][col] == null)
        {
            if(previous.equals("right"))
            {
                g.fillRect(100 + row * 120, 160 + col * 120, 120, 10);
                drawLaser(row, col + 1, "right", piecesHit, g);
            }
            else if(previous.equals("left"))
            {
                g.fillRect(100 + row * 100, 160 + col * 100, 120, 10);
                drawLaser(row, col - 1, "left", piecesHit, g);
            }
            else if(previous.equals("top"))
            {
                g.fillRect(100 + row * 120, 160 + col * 120, 10, 120);
                drawLaser(row + 1, col, "top", piecesHit, g);
            }
            else
            {
                g.fillRect(100 + row * 120, 160 + col * 120, 10, 120);
                drawLaser(row - 1, col, "bottom", piecesHit, g);
            }
        }
        else if(board[row][col] == laser)
        {
            if(laser.getCurrentIndex() == 0)
            {

            }
            else
            {

            }
        }
    }

    /**
     * This method determines if the piece is dropped in a valid place, and if
     * so it will move it to the correct place in the square.
     */
    public void dropInPlace(Piece p, MouseEvent e)
    {
        //ROW 1
        if(e.getX() >= 100 && e.getX() <= 220 && e.getY() >= 100 && e.getY() <= 220)//[0][0]
        {
            if(board[0][0] == null)
            {
                p.setXCoord(110);
                p.setYCoord(110);
                board[0][0] = p;
                p.setLocation(0, 0);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 220 && e.getX() <= 340 && e.getY() >= 100 && e.getY() <= 220)//[0][1]
        {
            if(board[0][1] == null)
            {
                p.setXCoord(230);
                p.setYCoord(110);
                board[0][1] = p;
                p.setLocation(0, 1);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 340 && e.getX() <= 460 && e.getY() >= 100 && e.getY() <= 220)//[0][2]
        {
            if(board[0][2] == null)
            {
                p.setXCoord(350);
                p.setYCoord(110);
                board[0][2] = p;
                p.setLocation(0, 2);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 460 && e.getX() <= 580 && e.getY() >= 100 && e.getY() <= 220)//[0][3]
        {
            if(board[0][3] == null)
            {
                p.setXCoord(470);
                p.setYCoord(110);
                board[0][3] = p;
                p.setLocation(0, 3);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 580 && e.getX() <= 700 && e.getY() >= 100 && e.getY() <= 220)//[0][4]
        {
            if(board[0][4] == null)
            {
                p.setXCoord(590);
                p.setYCoord(110);
                board[0][4] = p;
                p.setLocation(0, 4);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        //ROW 2
        else if(e.getX() >= 100 && e.getX() <= 220 && e.getY() >= 220 && e.getY() <= 340)//[1][0]
        {
            if(board[1][0] == null)
            {
                p.setXCoord(110);
                p.setYCoord(230);
                board[1][0] = p;
                p.setLocation(1, 0);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 220 && e.getX() <= 340 && e.getY() >= 220 && e.getY() <= 340)//[1][1]
        {
            if(board[1][1] == null)
            {
                p.setXCoord(230);
                p.setYCoord(230);
                board[1][1] = p;
                p.setLocation(1, 1);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 340 && e.getX() <= 460 && e.getY() >= 220 && e.getY() <= 340)//[1][2]
        {
            if(board[1][2] == null)
            {
                p.setXCoord(350);
                p.setYCoord(230);
                board[1][2] = p;
                p.setLocation(1, 2);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 460 && e.getX() <= 580 && e.getY() >= 220 && e.getY() <= 340)//[1][3]
        {
            if(board[1][3] == null)
            {
                p.setXCoord(470);
                p.setYCoord(230);
                board[1][3] = p;
                p.setLocation(1, 3);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 580 && e.getX() <= 700 && e.getY() >= 220 && e.getY() <= 340)//[1][4]
        {
            if(board[1][4] == null)
            {
                p.setXCoord(590);
                p.setYCoord(230);
                board[1][4] = p;
                p.setLocation(1, 4);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        //ROW 3
        else if(e.getX() >= 100 && e.getX() <= 220 && e.getY() >= 340 && e.getY() <= 460)//[2][0]
        {
            if(board[2][0] == null)
            {
                p.setXCoord(110);
                p.setYCoord(350);
                board[2][0] = p;
                p.setLocation(2, 0);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 220 && e.getX() <= 340 && e.getY() >= 340 && e.getY() <= 460)//[2][1]
        {
            if(board[2][1] == null)
            {
                p.setXCoord(230);
                p.setYCoord(350);
                board[2][1] = p;
                p.setLocation(2, 1);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 340 && e.getX() <= 460 && e.getY() >= 340 && e.getY() <= 460)//[2][2]
        {
            if(board[2][2] == null)
            {
                p.setXCoord(350);
                p.setYCoord(350);
                board[2][2] = p;
                p.setLocation(2, 2);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 460 && e.getX() <= 580 && e.getY() >= 340 && e.getY() <= 460)//[2][3]
        {
            if(board[2][3] == null)
            {
                p.setXCoord(470);
                p.setYCoord(350);
                board[2][3] = p;
                p.setLocation(2, 3);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 580 && e.getX() <= 700 && e.getY() >= 340 && e.getY() <= 460)//[2][4]
        {
            if(board[2][4] == null)
            {
                p.setXCoord(590);
                p.setYCoord(350);
                board[2][4] = p;
                p.setLocation(2, 4);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        //ROW 4
        else if(e.getX() >= 100 && e.getX() <= 220 && e.getY() >= 460 && e.getY() <= 580)//[3][0]
        {
            if(board[3][0] == null)
            {
                p.setXCoord(110);
                p.setYCoord(470);
                board[3][0] = p;
                p.setLocation(3, 0);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 220 && e.getX() <= 340 && e.getY() >= 460 && e.getY() <= 580)//[3][1]
        {
            if(board[3][1] == null)
            {
                p.setXCoord(230);
                p.setYCoord(470);
                board[3][1] = p;
                p.setLocation(3, 1);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 340 && e.getX() <= 460 && e.getY() >= 460 && e.getY() <= 580)//[3][2]
        {
            if(board[3][2] == null)
            {
                p.setXCoord(350);
                p.setYCoord(470);
                board[3][2] = p;
                p.setLocation(3, 2);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 460 && e.getX() <= 580 && e.getY() >= 460 && e.getY() <= 580)//[3][3]
        {
            if(board[3][3] == null)
            {
                p.setXCoord(470);
                p.setYCoord(470);
                board[3][3] = p;
                p.setLocation(3, 3);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 580 && e.getX() <= 700 && e.getY() >= 460 && e.getY() <= 580)//[3][4]
        {
            if(board[3][4] == null)
            {
                p.setXCoord(590);
                p.setYCoord(470);
                board[3][4] = p;
                p.setLocation(3, 4);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        //ROW 5
        else if(e.getX() >= 100 && e.getX() <= 220 && e.getY() >= 580 && e.getY() <= 700)//[4][0]
        {
            if(board[4][0] == null)
            {
                p.setXCoord(110);
                p.setYCoord(590);
                board[4][0] = p;
                p.setLocation(4, 0);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 220 && e.getX() <= 340 && e.getY() >= 590 && e.getY() <= 700)//[4][1]
        {
            if(board[4][1] == null)
            {
                p.setXCoord(230);
                p.setYCoord(590);
                board[4][1] = p;
                p.setLocation(4, 1);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 340 && e.getX() <= 460 && e.getY() >= 590 && e.getY() <= 700)//[4][2]
        {
            if(board[4][2] == null)
            {
                p.setXCoord(350);
                p.setYCoord(590);
                board[4][2] = p;
                p.setLocation(4, 2);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 460 && e.getX() <= 580 && e.getY() >= 580 && e.getY() <= 700)//[4][3]
        {
            if(board[3][3] == null)
            {
                p.setXCoord(470);
                p.setYCoord(590);
                board[4][3] = p;
                p.setLocation(4, 3);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else if(e.getX() >= 580 && e.getX() <= 700 && e.getY() >= 580 && e.getY() <= 700)//[4][4]
        {
            if(board[4][4] == null)
            {
                p.setXCoord(590);
                p.setYCoord(590);
                board[4][4] = p;
                p.setLocation(4, 4);
            }
            else
            {
                p.setXCoord(previousX);
                p.setYCoord(previousY);
                board[p.getRow()][p.getCol()] = p;
            }
        }
        else
        {
            p.setXCoord(previousX);
            p.setYCoord(previousY);
            board[p.getRow()][p.getCol()] = p;
        }
    }
}