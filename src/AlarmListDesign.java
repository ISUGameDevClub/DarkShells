import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Provides a panel for the list of alarms.
 * 
 */

public class AlarmListDesign extends JPanel implements ActionListener{
	private JPanel ald;
	private JScrollPane vert;
	
	//constructor
	public AlarmListDesign(){
		ald = new JPanel();
		vert = new JScrollPane(ald);
		
		AlarmViewDesign test = new AlarmViewDesign("Tester");
		vert.add(test);
		
		ald.setVisible(true);
		vert.setVisible(true);
	}
	
	//add an alarm to the list
	public void add(AlarmViewDesign avd){
		vert.add(avd);
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
