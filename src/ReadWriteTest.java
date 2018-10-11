import java.util.Scanner;
public class ReadWriteTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try {
			XmlManager x = new XmlManager("src/Alarm.xml");
			
			String input = new String();
			while(!input.equals("e"))
			{
				System.out.println("Enter an Alarm name and date in the format \"yyyy-MM-dd HH:mm\", or \'e\' to exit");
				input = in.nextLine();
				if(input.equals("delete"))
				{
					System.out.println("Enter the name of an alarm");
					input = in.nextLine();
					x.delete(input);					
				}
				else if(!input.equals("e"))
				{
					String[] nameDate = input.split(",");
					x.write(nameDate[0], nameDate[1]);
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		in.close();
		
	}

}
