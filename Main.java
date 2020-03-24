import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		objectbernie berns = new objectbernie();
		
		JFrame frame = new JFrame("Bernsimp");
		
		//add the object Bernie into the frame
		frame.add(berns);
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //What happens when u close
	    
	    frame.setSize(1920,1080);
	    
	    //size of frame
	    frame.setVisible(true);
		
		
	}
}