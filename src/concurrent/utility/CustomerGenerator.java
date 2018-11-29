package concurrent.utility;

import concurrency.entity.Customer;
import concurrency.main.Main;

//class to create customer objects
public class CustomerGenerator  {

	GenerateRandomNumbers generator = new GenerateRandomNumbers();//Create reference of GenerateRandomNumbers class to generate random numbers
	
	public int customerCount;

	public void generateCustomers()//methods to generate customer objects

	{

		final long timeInterval = 30000;//variable to store time interval after which next set of customers are generated
		
		Runnable runnable = new Runnable() {//Anonymous runnable class
		
		public void run() {//implemented run method	
		
		 while (true ) {//to make the method infinite

		      System.out.println("Customer set is generated!!!");// to display message when customer set is generated
		      customerCount = generator.getRandomNumberInRange(1, 60);//variable to store count of customer generated 
              System.out.println("Number of customers: "+customerCount);//to display number of customers inside the shop
              Main.ui.getTextField_16().setText(""+customerCount);
   
              
              for(int i=1 ; i <=customerCount;i++)//loop to generate customer objects 

              {
		      	  int productCount = generator.getRandomNumberInRange(1, 200);//variable to store number of products
            	  Customer customer = new Customer("C"+i,productCount);//creating customer objects 
            	  new Thread(customer, "Customer : "+i).start();//starting customer thread
            	  
              }
              try {
              
                      	  Thread.sleep(timeInterval);//sleep the customer thread for a definite time interval
            	  
              } catch (InterruptedException e) {
            	  e.printStackTrace();
              }
		   }
		}

	};
	
		Thread thread = new Thread(runnable);//pass the runnable object to thread object
		thread.start();//starting the anonymous runnable class thread.

	}
}