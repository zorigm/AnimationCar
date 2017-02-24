import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

/**
 * A car that can be moved around.
 * @author Zorig Magnaituvshin , zm5282
 * @version March 4, 2016
 */

public class CarShape implements MoveableShape
{
   /**
    * Constructs a car item.
    * @param x the left of the bounding rectangle
    * @param y the top of the bounding rectangle
    * @param width the width of the bounding rectangle
    */
   public CarShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }
   
   /**
    * This method draws the car. Combined with a timer, and translate method, it can shift.
    * @param  g2 the graphics content.
    * CARFACTOR 1 and CARFACTOR2 includes factors for the back tire, front tire,
    * Body length, body width, tire diameter
    * @return void.
    */
   public void draw(Graphics2D g2)
   {
      Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / CARFACTOR1, width - 1, width / CARFACTOR1);
      Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / CARFACTOR1, y +width / CARFACTOR2, width / CARFACTOR1, width / CARFACTOR1);
      Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / CARFACTOR2, y + width / CARFACTOR2, width / CARFACTOR1, width / CARFACTOR1);
      
      //the bottom of the front windshield
      Point2D.Double r1 = new Point2D.Double(x + width / CARFACTOR1, y + width / CARFACTOR1);
      //the front of the roof
      Point2D.Double r2 = new Point2D.Double(x + width / CARFACTOR2, y);
      //the rear of the roof
      Point2D.Double r3 = new Point2D.Double(x + width * 2 / CARFACTOR2, y);
      //the bottom of the rear windshield
      Point2D.Double r4 = new Point2D.Double(x + width * 5 / CARFACTOR1, y + width / CARFACTOR1);
      Line2D.Double frontWindShield = new Line2D.Double(r1, r2);
      Line2D.Double roofTop = new Line2D.Double(r2, r3);
      Line2D.Double rearWindShield = new Line2D.Double(r3, r4);
      
      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindShield);
      g2.draw(roofTop);
      g2.draw(rearWindShield);
   }

   /**
    * Moves the shape by a given amount.
    * @param dx the amount to translate in x-direction
    * @param dy the amount to translate in y-direction
    * @return void.
    */
   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;

   }
   
   public void resize(int heah)
   {
   }
   private int x;
   private int y;
   private int width;
   private final int CARFACTOR1 = 6;
   private final int CARFACTOR2 = 3;
}