import javax.swing.JPanel;
import java.awt.Image;
/**
 * This method contains methods for all the pieces to override,
 * as well as the comments to those methods.
 * 
 * @author Logan Brandt, Tucker Tavarone, Thomas Fresenius, 
 * Josh DelSignore, Eamonn Conway 
 * @version 1.0
 */
public abstract class Piece extends JPanel
{
    protected Image[] imgArr;
    protected int row;
    protected int col;
    /**
     * This method gets the current state of the piece for PaintComponent
     * @return - the current state of the image.
     */
    public abstract Image getImage();
    
    /**
     * This method returns the current xCoordinate of the piece
     * @return - the current position of the object on the x axis
     */
    public abstract int getXCoord();
    
    /**
     * This method returns the current yCoordinate of the piece
     * @return - the current position of the object on the y axis
     */
    public abstract int getYCoord();
  
    /**
     * This method sets the x coordinate of a piece to the inputted x.
     * This is essential to drop the piece in place.
     * @param x - the x coordinate to drop the piece.
     */
    public abstract void setXCoord(int x);
    
    /**
     * This method sets the y coordinate of a piece to the inputted y.
     * This is essential to drop the piece in place.
     * @param y - the y coordinate to drop the piece.
     */
    public abstract void setYCoord(int y);
    
    /**
     * This method gets the current index of a piece object, making it
     * much easier to compare two pieces instead of using images
     * @return - the currentIndex in the imgArr of the object
     */
    public abstract int getCurrentIndex();

    /**
     * This method gets the current row the piece is in. 
     * It is -1 if not on board.
     * @return row - current row of piece on the game board.
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * This method gets the current column the piece is in. 
     * It is -1 if not on board.
     * @return col - current column of piece on the game board.
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * This method sets the new location on the board for the piece. 
     * @param newRow - new row the piece is in on the board.
     * @param newCol - new column the piece is in on the board.
     */
    public void setLocation(int newRow, int newCol)
    {
        row = newRow;
        col = newCol;
    }
}
