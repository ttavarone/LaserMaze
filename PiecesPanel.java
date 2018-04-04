package GamePieces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class should be for creating board pieces
 */
public class PiecesPanel extends JPanel implements MouseListener, MouseMotionListener {

    private int xCoord;
    private int yCoord;
    private Toolkit toolkit;
    private Image yellowCheckpoint;
    private Image blueMirror;
    private Image blueMirror2;

    public PiecesPanel() {

        xCoord = 120;
        yCoord = 120;

        toolkit = Toolkit.getDefaultToolkit();

        yellowCheckpoint = toolkit.getImage("LaserMaze/src/GamePieces/yellowCheckpoint.jpg");
        blueMirror = toolkit.getImage("LaserMaze/src/GamePieces/blueMirror.jpg");
        blueMirror2 = toolkit.getImage("LaserMaze/src/GamePieces/blueMirror2.jpg");

        addMouseListener(this);
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
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    /**
     * Paints graphics on the components
     *
     * @param g the graphics input object
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(yellowCheckpoint, xCoord, yCoord, this);


    }

}
