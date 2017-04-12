import javax.xml.bind.*;
import java.io.File;

public class XmlManager {
	
	private JAXBContext context;
	private Unmarshaller reader;
	private Marshaller writer;
	
	private File axml;
	
	public XmlManager(String filename) throws Exception
	{
		context = JAXBContext.newInstance(SaveState.class);
		reader = context.createUnmarshaller();
		writer = context.createMarshaller();
		
		writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		writer.marshal(new SaveState(), System.out);
		
		axml = new File(filename);
	}
	
	public SaveState read() throws Exception
	{
		SaveState s = null;
		try {
			s = (SaveState)reader.unmarshal(axml);
		} catch(UnmarshalException e) {
			s = new SaveState();
		}
		return s;
	}
	
	public void write(String name, String time) throws Exception
	{
		SaveState s = read();
		System.out.println(s.toString());
		s.addAlarm(new Alarm(name, time));
		writer.marshal(s, axml);
	}
	
	
}
