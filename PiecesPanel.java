package GamePieces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class should be for creating board pieces
 */
public class PiecesPanel extends JPanel implements MouseListener {

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Color pieceColor;

    public PiecesPanel() {
        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
        typeOfPiece = new String();
        pieceColor = Color.RED;
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

    public void setPieceColor(Color c) {
        pieceColor = c;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(pieceColor);
        g.drawRoundRect(xCoord, yCoord, PIECE_WIDTH, PIECE_HEIGHT, 10, 10);
        g.fillRoundRect(xCoord, yCoord, PIECE_WIDTH, PIECE_HEIGHT, 10, 10);

        g.setColor(Color.GRAY);
        g.drawRoundRect(xCoord+7, yCoord+7, PIECE_WIDTH-15, PIECE_HEIGHT-15, 10, 10);
        g.fillRoundRect(xCoord+7, yCoord+7, PIECE_WIDTH-15, PIECE_HEIGHT-15, 10, 10);

        //
        //g.setColor(Color.BLUE);
        //g.drawArc(xCoord+15, yCoord+15, 50, 140, 40, 120);
        //
    }

}
