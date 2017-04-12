import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * class that directly manages how to deal with the end of an alarm. popup included
 * 
 */

public class AlarmRingDesign {

	JFrame frame = new JFrame();
	//constructor
	public AlarmRingDesign(){
		String s = (String)JOptionPane.showInputDialog(
                frame,
                "Complete the sentence:\n"
                + "\"Green eggs and...\"",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE);
	}
	
	//deletes the alarm after use. Should be a button.
	public void deleteAlarm(){
		
	}
	
	//"snoozes" the alarm 1m (makes new one, deletes old one)
	public void snooze(){
		
	}
}
