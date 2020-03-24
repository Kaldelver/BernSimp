
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Main {
	
	public static void main(String[] args) {
		objectbernie berns = new objectbernie();
		
		JFrame frame = new JFrame("Bernsimp");

		//this will have to change somehow set it in project folder
		ImageIcon ii = new ImageIcon("C:\\Users\\*********\\Desktop\\Yang_gang\\pixil-frame-0.png");
		
		//calling ImageIcon
	    JLabel lable = new JLabel(ii);
	       
	    @SuppressWarnings("unused")
		JScrollPane jsp = new JScrollPane(lable);
	       
	    //for jsp variable is defined for later
	    frame.getContentPane().add(jsp);
	       
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //What happens when u close
	    
	    frame.setSize(1920,1080);
		
		//add the object Bernie into the frame
		frame.add(berns);
	    
	    //size of frame
	    frame.setVisible(true);
		
		
	}
}