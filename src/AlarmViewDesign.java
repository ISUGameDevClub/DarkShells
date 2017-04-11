import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * The smallest element: the actual display in the list.
 * 
 */

public class AlarmViewDesign extends JPanel implements ActionListener{
	public AlarmViewDesign(String name){
		super(new GridLayout(1, 1));
		JPanel avd = new JPanel();
		
		//add the time label
		JTextArea alarmTimeLabel = new JTextArea();
		alarmTimeLabel.setText(name);
		alarmTimeLabel.setEditable(false);
		avd.add(alarmTimeLabel);
		
		JButton deleteAlarmView = new JButton("X");
		deleteAlarmView.setActionCommand("delete");
		deleteAlarmView.addActionListener(this);
		avd.add(deleteAlarmView);
	}
	
	//this needs to be a button.
	private void deleteAlarm(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("delete".equals(e.getActionCommand())){
			deleteAlarm();
		}
		
	}
}
