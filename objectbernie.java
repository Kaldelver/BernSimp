import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.*;;

	public class objectbernie extends JPanel implements ActionListener{
		
		//creates the timer
		Timer t = new Timer(5, this);
		
		//variables for the position and velocity of each direction
		double xPos =  0, yPos = 0, velX = 2, velY = 2;
	
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			//create new object with positions and sizes
			Ellipse2D circle = new Ellipse2D.Double(xPos, yPos, 40, 40);
			
			//fill the object
			g2.fill(circle);
			
			//start the timer
			t.start();
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//move the object by the velocity
			xPos += velX;
			yPos += velY;
			
			//refreshes the screen
			repaint();
			
		}


	}
