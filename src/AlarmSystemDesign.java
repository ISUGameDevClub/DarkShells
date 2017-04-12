import java.awt.GridLayout;

import javax.swing.JFrame;

/*
 * The actual base layout. The exterior panel.
 * 
 */

public class AlarmSystemDesign {
	private JFrame frame;
	
	//constructor
	public AlarmSystemDesign(){
		AlarmListDesign ald = new AlarmListDesign();
		ButtonPanel button = new ButtonPanel(ald);
		
		
		frame = new JFrame("Set an Alarm");
		frame.setLayout(new GridLayout(2,1));
		frame.getContentPane().add(button.init());
		frame.getContentPane().add(ald.init());
		frame.setSize(480, 800);
		frame.setVisible(true);
	}
	
	//initialization method
	public JFrame init(){
		return frame;
	}
}
