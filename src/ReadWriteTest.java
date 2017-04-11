import java.util.Scanner;
public class ReadWriteTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try {
			XmlWriter x = new XmlWriter("src/Alarm.xml");
			
			String input = new String();
			while(!input.equals("e"))
			{
				System.out.println("Enter an Alarm name and date in the format \"yyyy-MM-dd HH:mm\", or \'e\' to exit");
				input = in.nextLine();
				if(!input.equals("e"))
				{
					String[] nameDate = input.split(",");
					x.writeAlarm(nameDate[0], nameDate[1]);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		in.close();
		
	}

}
