import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement
public class Alarm {
	
	private String name;
	private LocalDateTime time;
	
	public Alarm()
	{
		
	}
	
	public Alarm(String n, String t)
	{
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		time = LocalDateTime.parse(t, format);
		name = n;
	}
	
	public Alarm(String n, LocalDateTime t)
	{
		name = n;
		time = t;
	}
	
	@XmlAttribute
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	@XmlElement
	public String getTime()
	{
		return time.toString();
	}
	
	public LocalDateTime getDateTime()
	{
		return time;
	}
	
	public void setTime(LocalDateTime t)
	{
		time = t;
	}
	
}
