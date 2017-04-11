import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * The smallest element: the actual display in the list.
 * 
 */

public class AlarmViewDesign extends JPanel{
	public AlarmViewDesign(String name){
		super(new GridLayout(1, 1));
		JPanel avd = new JPanel();
		
		//add the time label
		JTextArea alarmTimeLabel = new JTextArea();
		alarmTimeLabel.setText(name);
		alarmTimeLabel.setEditable(false);
		avd.add(alarmTimeLabel);
		
		
	}
	
	//this needs to be a button.
	private void deleteAlarm(){
		
	}
}
