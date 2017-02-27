package Model;


import java.awt.Point;
import javax.swing.JButton;

/**
 * Write a description of class PacButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("serial")
public class PacButton extends JButton
{
    // instance variables - replace the example below with your own
    private Point coordinates = new Point(0,0);

    /**
     * Constructor for objects of class PacButton
     */
    public PacButton(int x, int y)
    {
      coordinates.setLocation(x,y);  
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Point getCoord()
    {
       return coordinates;
    }
    
}
