import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;

import javax.swing.*;;

	public class objectbernie extends JPanel implements ActionListener, KeyListener{
		
		//creates the timer
		Timer t = new Timer(5, this);
		
		//variables for the position and velocity of each direction
		double xPos =  0, yPos = 0, xVel = 0, yVel = 0;
		
		//makes it so that it keeps going a direction even when a key is released
		boolean checkUp = false, checkDown = false, checkRight = false, checkLeft = false;
		
		//sets up the key detection for the class
		public objectbernie(){
			t.start();
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
		}
	
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			//create character object with positions and sizes
			Rectangle2D rectangle = new Rectangle2D.Double(xPos, yPos, 40, 40);
			
			//fill the object (later replaced with sprite)
			g2.fill(rectangle);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//move the object by the velocity
			xPos += xVel;
			yPos += yVel;
			
			//refreshes the screen
			repaint();	
		}

		//changes the velocity based on which direction is pressed
		public void up() {
			yVel = -1.5;
		}
		
		public void down() {
			yVel = 1.5;
		}
	
		public void left() {
			xVel = -1.5;
		}
		
		public void right() {
			xVel = 1.5;
		}
		
		public void rest() {
			
			if (checkLeft == false && checkRight == false) {
				xVel = 0;
			}
			
			if (checkUp == false && checkDown == false) {
				
				yVel = 0;
			}
		}
		
		//detects the key presses
		public void keyPressed(KeyEvent e) {
			
			//since each key has a unique code, store it into a variable
			int code = e.getKeyCode();
			
			//check if the code matches with each direction and call the class
			if (code == KeyEvent.VK_UP) {
				up();
				checkUp = true;
			}
			
			if (code == KeyEvent.VK_DOWN) {
				down();
				checkDown = true;
			}
			
			if (code == KeyEvent.VK_LEFT) {
				left();
				checkLeft = true;
			}
			
			if (code == KeyEvent.VK_RIGHT) {
				right();
				checkRight = true;
			}
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			
			if (code == KeyEvent.VK_UP) {
				checkUp = false;
				rest();
			}
			
			if (code == KeyEvent.VK_DOWN) {
				checkDown = false;
				rest();
			}
			
			if (code == KeyEvent.VK_LEFT) {
				checkLeft = false;
				rest();
			}
			
			if (code == KeyEvent.VK_RIGHT) {
				checkRight = false;
				rest();
			}
		}


	}
