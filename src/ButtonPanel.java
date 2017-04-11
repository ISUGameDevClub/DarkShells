import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * handles both buttons for adding alarms
 */

public class ButtonPanel extends JPanel implements ActionListener{
	
	JPanel buttons;
	AlarmListDesign ald;
	
	//constructor
	public ButtonPanel(AlarmListDesign ald){
		this.ald = ald;
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2));
		
		JButton alarmDelay = new JButton("Timer");
		JButton alarmSet = new JButton("Alarm");
		alarmDelay.setActionCommand("create delay");
		alarmDelay.addActionListener(this);
		alarmSet.setActionCommand("create set");
		alarmSet.addActionListener(this);
		
		buttons.add(alarmDelay);
		buttons.add(alarmSet);
		
	}
	
	//opens the "timer" or "Delay" panel
	public void openADD(){
		AlarmDelayDesign add = new AlarmDelayDesign(ald);
	}
	
	//opens the "set time alarm" panel
	public void openATD(){
		AlarmTimeDesign atd = new AlarmTimeDesign(ald);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("create set".equals(e.getActionCommand())){
			openADD();
		}
		else if("create delay".equals(e.getActionCommand())){
			openATD();
		}
	}
	
	//initializes button
	public JPanel init(){
		return buttons;
	}
}
