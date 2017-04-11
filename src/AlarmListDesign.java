import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

/*
 * Provides a panel for the list of alarms.
 * 
 */

public class AlarmListDesign extends JPanel implements ActionListener{
	private JPanel ald;
	
	//constructor
	public AlarmListDesign(){
		ald = new JPanel();
		
		JScrollBar vert= new JScrollBar();
		ald.add(vert);
	}
	
	//add an alarm to the list
	public void add(AlarmViewDesign avd){
		ald.add(avd);
	}
	
	//refreshes the program after any edit to the list
	public void refresh(){
		
	}
	
	//the initialization method
	public JPanel init(){
		return ald;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
