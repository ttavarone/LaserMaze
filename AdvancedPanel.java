import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class AdvancedPanel extends JPanel implements MouseListener, MouseMotionListener
{
    protected Pieces[][] board;
    final private int windowWidth = 850;
    final private int windowHeight = 800;
    private int boardWidth = 600;
    private int boardHeight = 600;
    Pieces p = new Pieces();
    AdvancedPieces ap = new AdvancedPieces();

    public AdvancedPanel()
    {

        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(windowWidth,windowHeight));
        board = new Pieces[5][5];

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
        
        ap.paintAdvanced(g);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {  }

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
    
    @Override
    public void mouseMoved(MouseEvent e){
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        
    }
}
