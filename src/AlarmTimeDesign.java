import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * The "set time" alarm.
 */

public class AlarmTimeDesign {

	String name = null;
	String time = null;
	
	//constructor
	public AlarmTimeDesign(AlarmListDesign ald){
		JTextField time = new JTextField(5);
	    JTextField name = new JTextField(5);

	    JPanel myPanel = new JPanel();
	    myPanel.add(new JLabel("Label:"));
	    myPanel.add(name);
	    myPanel.add(Box.createVerticalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Time:"));
	    myPanel.add(new JLabel("(xxxx-xx-xx xx:xx)"));
	    myPanel.add(time);

	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	    		"Please enter year, month, day and time for your alarm",
	    		JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	       this.name = name.getText();
	       this.time = time.getText();
	       
	       createAlarm(this.time, this.time, this.name);
	    }
		
	}
	
	//alarm creation method
	public void createAlarm(String name, String time){	
		Alarm alm = new Alarm(name, time);
	}
	
	//alarm creation with message
	public void createAlarm(String name, String time, String message){
		Alarm alm = new Alarm(name, time, message);
	}
}
