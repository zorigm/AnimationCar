import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

import java.awt.Graphics2D;

/**
 * An icon that contains a movable shape.
 * @author Zorig Magnaituvshin , zm5282
 * @version March 4, 2016
 */

public class ShapeIcon implements Icon
{
   public ShapeIcon(MoveableShape shape,
          int width, int height)
          {
             this.shape = shape;
             this.width = width;
             this.height = height;
          }
   
   /**
    * @return height
    */
   public int getIconHeight()
   {
      // TODO Auto-generated method stub
      return height;
   }

   /**
    * @return width
    */
   public int getIconWidth()
   {
      return width;
   }

   /**
    * Paints the icon.
    * @param c the Component
    * @param g the Graphics content.
    * @param x
    * @param y
    * @return void.
    */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      shape.draw(g2);
   }
   
   private int width;
   private int height;
   private MoveableShape shape;

}