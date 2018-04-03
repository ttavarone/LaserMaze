package GamePieces;

import javax.swing.*;
import java.awt.*;

/**
 * This class should be for creating board pieces
 */
public class Pieces extends JPanel {

    final private int PIECE_WIDTH;
    final private int PIECE_HEIGHT;
    protected int xCoord = (600/5);
    protected int yCoord = (600/5);
    protected String typeOfPiece;
    protected Color pieceColor;

    public Pieces() {
        PIECE_WIDTH = 90;
        PIECE_HEIGHT = 90;
        typeOfPiece = new String();
        pieceColor = Color.GRAY;
    }

    public void setPieceColor(Color c){
        pieceColor = c;
    }

    public void paintPiece() {
        Graphics g
        paintComponent(new Graphics());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawRoundRect(xCoord, yCoord, PIECE_WIDTH, PIECE_HEIGHT, 10, 10);
        g.fillRoundRect(xCoord, yCoord, PIECE_WIDTH, PIECE_HEIGHT, 10, 10);

        g.setColor(Color.GRAY);
        g.drawRoundRect(xCoord+7, yCoord+7, PIECE_WIDTH-15, PIECE_HEIGHT-15, 10, 10);
        g.fillRoundRect(xCoord+7, yCoord+7, PIECE_WIDTH-15, PIECE_HEIGHT-15, 10, 10);

        g.setColor(Color.BLUE);
        g.drawArc(xCoord+15, yCoord+15, 50, 140, 40, 120);
    }
}
