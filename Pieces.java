package GamePieces;

import javax.swing.*;
import java.awt.*;

public class Pieces extends JPanel {

    final protected int PIECE_WIDTH;
    final protected int PIECE_HEIGHT;
    private int xCoord = (600/5);
    private int yCoord = (600/5);

    public Pieces(){

        PIECE_WIDTH = (600/5)-30;
        PIECE_HEIGHT = (600/5)-30;
    }

    public Pieces(int piece_width, int piece_height, int xCoordIn, int yCoordIn){

        PIECE_WIDTH = piece_width;
        PIECE_HEIGHT = piece_height;
        xCoord = xCoordIn;
        yCoord = yCoordIn;
    }

    public void paintPiece(Graphics g){
        paintComponent(g);

    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawRoundRect(xCoord, yCoord, PIECE_WIDTH, PIECE_HEIGHT, 10, 10);
        g.fillRoundRect(xCoord, yCoord, PIECE_WIDTH, PIECE_HEIGHT, 10, 10);

    }
}
