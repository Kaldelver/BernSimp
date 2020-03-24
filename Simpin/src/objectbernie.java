import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;;

	public class objectbernie extends JPanel implements ActionListener, KeyListener{
			
		//creates the timer
		Timer t = new Timer(5, this);
		
		public BufferedImage image;
		
		int spriteFrameX = 0, spritePacer = 0, spriteFrameY = 0;
		
		//variables for the position and velocity of each direction
		double xPos =  0, yPos = 0, xVel = 0, yVel = 0;
		
		//makes it so that it keeps going a direction even when a key is released
		boolean checkUp = false, checkDown = false, checkRight = false, checkLeft = false;
		boolean idle = true;
		
		//sets up the key detection for the class
		public objectbernie(){
			t.start();
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/SpriteSheetFull.png"));
				
			} catch(IOException e) {
				e.printStackTrace();
				
				repaint();
			}
		}

		public void paintComponent(Graphics g){
			
			//super.paintComponent(g);
			//Graphics2D g2 = (Graphics2D) g;
			
			//create character object with positions and sizes
			//Rectangle2D rectangle = new Rectangle2D.Double(xPos, yPos, 40, 40);
			
			//fill the object (later replaced with sprite)
			//g.drawImage(image, 40, 40, 100, 100, null);
			g.drawImage(image, (int)xPos, (int)yPos, (int)xPos + 64, (int)yPos + 64, 32 * spriteFrameX, 32 * spriteFrameY, 32 * spriteFrameX + 32, 32 * spriteFrameY + 32, null);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//move the object by the velocity
			xPos += xVel;
			yPos += yVel;
			
			spritePacer += 1;
			
			if (idle == true) {
				spriteFrameY = 0;
				
				if (spriteFrameX > 1){
					spriteFrameX = 0;
					spritePacer = 0;
				}
				else if (spritePacer % 100 == 0) {
					spriteFrameX += 1;
					
				}
			}
			else if (checkLeft == true) {
				spriteFrameY = 3;
				
				if (spriteFrameX > 3){
					spriteFrameX = 0;
					spritePacer = 0;
				}
				else if (spritePacer % 35 == 0) {
					spriteFrameX += 1;
					
				}
			}
			else if (checkRight == true) {
				spriteFrameY = 1;
				
				if (spriteFrameX > 3){
					spriteFrameX = 0;
					spritePacer = 0;
				}
				else if (spritePacer % 35 == 0) {
					spriteFrameX += 1;
					
				}
			}
			else if (checkUp == true) {
				spriteFrameY = 4;
				
				if (spriteFrameX > 1){
					spriteFrameX = 0;
					spritePacer = 0;
				}
				else if (spritePacer % 35 == 0) {
					spriteFrameX += 1;
					
				}
			}
			else if (checkDown == true) {
				spriteFrameY = 2;
				
				if (spriteFrameX > 1){
					spriteFrameX = 0;
					spritePacer = 0;
				}
				else if (spritePacer % 35 == 0) {
					spriteFrameX += 1;
					
				}
			}
			
			//refreshes the screen
			repaint();	
		}

		//changes the velocity based on which direction is pressed
		public void up() {
			yVel = -1;
			idle = false;
			spriteFrameX = 0;
		}
		
		public void down() {
			yVel = 1;
			idle = false;
			spriteFrameX = 0;
		}
	
		public void left() {
			xVel = -1;
			idle = false;
			spriteFrameX = 0;
		}
		
		public void right() {
			xVel = 1;
			idle = false;
			spriteFrameX = 0;
		}
		
		public void rest() {
			
			if (checkLeft == false && checkRight == false) {
				
				xVel = 0;
				
				if (checkUp == false && checkDown == false) {

					idle = true;
				}
			}
			
			if (checkLeft == false && checkRight == true) {
				
				xVel = 1;
			}
			
			if (checkLeft == true && checkRight == false) {
				
				xVel = -1;
			}
			
			if (checkUp == false && checkDown == false) {
				
				yVel = 0;
				
				if (checkLeft == false && checkRight == false)
				idle = true;
			}
			
			if (checkUp == false && checkDown == true) {
				
				yVel = 1;
			}
			
			if (checkUp == true && checkDown == false) {
				
				yVel = -1;
			}
			
		}
		
		//detects the key presses
		public void keyPressed(KeyEvent e) {
			
			//since each key has a unique code, store it into a variable
			int code = e.getKeyCode();
			
			//check if the code matches with each direction and call the class
			if (code == KeyEvent.VK_W) {
				up();
				checkUp = true;
			}
			
			if (code == KeyEvent.VK_S) {
				down();
				checkDown = true;
			}
			
			if (code == KeyEvent.VK_A) {
				left();
				checkLeft = true;
			}
			
			if (code == KeyEvent.VK_D) {
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
			
			if (code == KeyEvent.VK_W) {
				checkUp = false;
				rest();
			}
			
			if (code == KeyEvent.VK_S) {
				checkDown = false;
				rest();
			}
			
			if (code == KeyEvent.VK_A) {
				checkLeft = false;
				rest();
			}
			
			if (code == KeyEvent.VK_D) {
				checkRight = false;
				rest();
			}
		}


	}
