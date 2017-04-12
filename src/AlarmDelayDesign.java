import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * the "timer" alarm
 */

public class AlarmDelayDesign {
	
	JFrame frame = new JFrame();
	String time = null;
	String name = null;
	
	//constructor
	public AlarmDelayDesign(AlarmListDesign ald){
		JTextField time = new JTextField(5);
	    JTextField name = new JTextField(5);

	    JPanel myPanel = new JPanel();
	    myPanel.setSize(200, 480);
	    myPanel.add(new JLabel("Label:"));
	    myPanel.add(name);
	    myPanel.add(Box.createVerticalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Minutes:"));
	    myPanel.add(time);

	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	    		"Please enter the length of the timer",
	    		JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	       this.name = name.getText();
	       this.time = time.getText();
	       
	       createAlarm(this.time, this.time, this.name);
	    }
	}
	
	//alarm creation method
	public void createAlarm(String name, String time){	//time can be a number value, that's just temporary
		
	}
	
	//alarm creation with message
	public void createAlarm(String name, String time, String message){
		
	}
}
