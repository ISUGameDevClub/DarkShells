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
	JPanel avd;
	
	public AlarmViewDesign(String name){
		avd = new JPanel();
		avd.setLayout(new GridLayout(1, 2));
		
		JTextArea alarmTimeLabel = new JTextArea();
		JButton alarmDelete = new JButton("Delete");
		alarmTimeLabel.setText(name);
		alarmTimeLabel.setEditable(false);
		alarmDelete.setActionCommand("delete");
		alarmDelete.addActionListener(this);
		
		avd.add(alarmTimeLabel);
		avd.add(alarmDelete);
		
		avd.setVisible(true);

	}
	
	//this needs to be a button.
	private void deleteAlarm(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("delete".equals(e.getActionCommand())){
			deleteAlarm();
			avd.setVisible(false);
		}
		
	}
	
	//initialization
	public JPanel init(){
		return avd;
	}
}
