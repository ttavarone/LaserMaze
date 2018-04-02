package GamePieces;

import javax.swing.*;
import java.awt.*;

public class PiecesPanel extends JPanel {

    final protected int PIECE_WIDTH;
    final protected int PIECE_HEIGHT;
    private int xCoord = 0;
    private int yCoord = 0;

    public PiecesPanel(int xCoordIn, int yCoordIn){
        PIECE_WIDTH = (600/5)-10;
        PIECE_HEIGHT = (600/5)-10;
        xCoord = xCoordIn;
        yCoord = yCoordIn;
    }

    public PiecesPanel(int piece_width, int piece_height, int xCoordIn, int yCoordIn){

        PIECE_WIDTH = piece_width;
        PIECE_HEIGHT = piece_height;
        xCoord = xCoordIn;
        yCoord = yCoordIn;
    }

    public void paintPiece(Graphics g){
        g.drawRect(110, 110, PIECE_WIDTH, PIECE_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        paintPiece(g);

    }
}
