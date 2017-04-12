import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
import javax.xml.bind.annotation.XmlElement;  

public class Alarm {
	
	private String name;
	private LocalDateTime time;
	
	public Alarm()
	{
		
	}
	
	public Alarm(String n, String t)
	{
		if(t != null)
			System.out.println(t);
		else
			System.out.println("null");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		time = LocalDateTime.parse(t, format);
		name = n;
	}
	
	public Alarm(String n, LocalDateTime t)
	{
		name = n;
		time = t;
	}
	
	@XmlElement
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
		String[] split = time.toString().split("T");
		return split[0] + " " + split[1];
	}
	
	public LocalDateTime getDateTime()
	{
		return time;
	}
	
	public void setTime(LocalDateTime t)
	{
		time = t;
	}
	
	public void setTime(String t)
	{
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		time = LocalDateTime.parse(t, format);
	}
	
}
