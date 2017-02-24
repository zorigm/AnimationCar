import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


/**
 * This program implements an animation that moves a car shape.
 * @author Zorig Magnaituvshin , zm5282
 * @version March 4, 2016
 */
public class AnimationTester
{

   public static void main(String[] args)
   {
      AnimationTester animationTest = new AnimationTester();
      animationTest.start();
      
    }
   
   /**
    * This method starts the animation test. 
    * It uses a timer to shift the car to the right every 100 milliseconds.
    * Uses every other class.
    * @return void.
    */
   public void start()
   {
      JFrame frame = new JFrame();
      final MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
      
      ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
      
      final JLabel label = new JLabel(icon);
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      frame.setLayout(new FlowLayout());
      panel.add(label);
      frame.add(panel);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL,0,200,100);
      sizeSlider.addChangeListener(new
            ChangeListener()
             {
                 public void stateChanged(ChangeEvent e) 
                 {
                     JSlider source = (JSlider) e.getSource();
                     int slideReturn = (int) source.getValue();
                     shape.resize(slideReturn);
                     label.repaint();
                 }
                 }
             );
      panel.add(sizeSlider);
      
      final int DELAY = 100;
      //milliseconds between timer ticks
      Timer t = new Timer(DELAY, 
            new ActionListener()
      {public void actionPerformed(ActionEvent event)
         {
         shape.translate(1, 0);
         label.repaint();
         }
      });
      
      final JButton click = new JButton("Start");
      click.addActionListener(new ActionListener()
      {
         boolean innerClick = false;
         public void actionPerformed(ActionEvent e)
         {
            if (innerClick == true)
            {
               click.setText("Resume");
               innerClick = false;
               //t.stop();
            }
            else
            {
               innerClick = true;
               click.setText("Stop");
               //t.start();
            }
         }
      });
      panel.add(click);

   }

   private final int ICON_WIDTH = 400;
   private final int ICON_HEIGHT = 100;
   private final int CAR_WIDTH = 100;
}