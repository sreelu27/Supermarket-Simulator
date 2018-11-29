package concurrency.main;
import java.util.ArrayList;
import java.util.List;
import concurrency.entity.Counter;
import concurrent.ui.UI;
import concurrent.utility.CustomerGenerator;

public class Main{
	
	public static List<Counter> counters = new ArrayList<>();//to store the set of counter objects
	private CustomerGenerator customerGenerator = new CustomerGenerator(); //to generate customer objects
	public static UI ui;//GUI object reference

		public static void main(String[] arg) throws InterruptedException{
			
			ui = new UI();//create UI object
			Main main = new Main();//Creating Main class reference and object
			main.generateCounters();//calling method to generate the checkout counter objects
			main.customerGenerator.generateCustomers();//method to generate the customer objects
			
			
		}
		// method to generate checkout counters
		void generateCounters()
		{
			for(int i = 1; i <= 8; i++)
			{
				Counter counter = new Counter();//create counter objects 
				counter.setCounterId(i);//setting counter ID for each object
				counters.add(counter);//adding each object of the counter to the counter list
				new Thread(counter,"Counter ID : "+(i)).start();//starting the counter thread
			}
		}
		
		
		
}
