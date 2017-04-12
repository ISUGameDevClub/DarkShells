import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;

@XmlRootElement(name="SaveState")
public class SaveState {
	
	
	private ArrayList<Alarm> alarms;
	
	public SaveState()
	{
		alarms = new ArrayList<Alarm>();
	}
	
	public ArrayList<Alarm> getAlarms()
	{
		return alarms;
	}
	
	@XmlElementWrapper(name="alarms")
	@XmlElement(name="alarm")
	public void setAlarms(ArrayList<Alarm> alarms)
	{
		this.alarms = alarms;
	}
	
	public void deleteAlarm(String alarmName)
	{
		Iterator<Alarm> iter = alarms.iterator();
		while(iter.hasNext())
		{
			Alarm a = iter.next();
			if(a.getName().equals(alarmName))
				iter.remove();
		}
	}
	
	public void addAlarm(Alarm a)
	{
		alarms.add(a);
	}
	
	public String toString()
	{
		StringBuilder out = new StringBuilder();
		for(Alarm a : alarms)
		{
			out.append(a.getName() + " : " + "\n");
		}
		return out.toString();
	}
}
