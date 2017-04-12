import java.awt.Dimension;
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
	private JPanel other;
	
	//constructor
	public AlarmListDesign(){
		other = new JPanel();
		AlarmViewDesign test = new AlarmViewDesign("Tester");
		other.add(test);
		other.setVisible(true);
		
		JScrollPane vert = new JScrollPane(other);
        vert.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        vert.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        vert.setBounds(50, 30, 360, 320);
        vert.setVisible(true);
        ald = new JPanel(null);
        ald.setPreferredSize(new Dimension(600, 480));
        ald.add(vert);
        
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
