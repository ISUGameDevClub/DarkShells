import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XmlWriter {

	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document doc;
	private String filename;
	
	public XmlWriter(String filename) throws Exception
	{
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
		doc = db.parse(filename);
		this.filename = filename;
	}
	
	public void writeAlarm(String alarmName, String alarmTime) throws Exception
	{
        Element root = doc.getDocumentElement();
           
        Element newAlarm = doc.createElement("alarm");

        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(alarmName));
        newAlarm.appendChild(name);

        Element time = doc.createElement("time");
        time.appendChild(doc.createTextNode(alarmTime));
        newAlarm.appendChild(time);

        root.appendChild(newAlarm);
        
        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        StreamResult result = new StreamResult(filename);
        transformer.transform(source, result);
    }
}

