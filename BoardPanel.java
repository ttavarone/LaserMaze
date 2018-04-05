package GamePieces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is just for creating the board graphic and its attributes
 * NOTE: It does not control mouse clicks or gameplay
 */
public class BoardPanel extends JPanel implements MouseListener
{
    protected PiecesPanel[][] board;
    final private int windowWidth = 800;
    final private int windowHeight = 800;
    private int boardWidth = 600;
    private int boardHeight = 600;

    private int xCoord;
    private int yCoord;
    private Toolkit toolkit;
    private Image yellowCheckpoint;
    private Image blueMirror;
    private Image blueMirror2;
    private Image yellowCheckpoint2;
    private Image bottomLeftPurple;
    private Image bottomRightPurple;
    private Image purpleMirror;
    private Image topLeftPurple;
    private Image topRightPurple;


    public BoardPanel()
    {

        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(windowWidth,windowHeight));
        board = new PiecesPanel[5][5];

        xCoord = 120;
        yCoord = 120;

        toolkit = Toolkit.getDefaultToolkit();

        yellowCheckpoint = toolkit.getImage("GamePieces/yellowCheckpoint.jpg");
        blueMirror = toolkit.getImage("GamePieces/blueMirror.jpg");
        blueMirror2 = toolkit.getImage("GamePieces/blueMirror2.jpg");
        yellowCheckpoint2 = toolkit.getImage("GamePieces/yellowCheckpoint2.jpg");
        bottomLeftPurple = toolkit.getImage("GamePieces/bottomLeftPurple.jpg");
        bottomRightPurple = toolkit.getImage("GamePieces/bottomRightPurple.jpg");
        purpleMirror = toolkit.getImage("GamePieces/purpleMirror.jpg");
        topLeftPurple = toolkit.getImage("GamePieces/topLeftPurple.jpg");
        topRightPurple = toolkit.getImage("GamePieces/topRightPurple.jpg");
        //laserBottom = toolkit.getImage("GamePieces/laserBottom.jpg");
        //laserRight = toolkit.getImage("GamePieces/laserRight.jpg");


        addMouseListener(this);
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

        g.drawImage(yellowCheckpoint, xCoord, yCoord, this);
        g.setColor(Color.BLUE);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int button = e.getButton();

        xCoord = e.getX();
        yCoord = e.getY();

        repaint();
        e.consume();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

