package concurrency.entity;
////***************Authors: Sreelekshmi Geetha & Sultan Hydrali********************
import concurrency.main.Main;
import concurrent.utility.CustomerGenerator;
import concurrent.utility.GenerateRandomNumbers;
//Customer Class
public class Customer implements Runnable{
	
	private static int lostCustomers;//to store number of customers who left the shop
	private String customerName;//to store customer name
	private int productCount;//to store product count
	private long processingTime;//to calculate processing time for each customer
	private int queuecount;	//to calculate the check times of customers
	
	GenerateRandomNumbers generator;//Create object reference for GenerateRandomNumbers
	
	public Customer(String customerName,int productCount) {//parameterized constructor
		this.customerName=customerName;
		this.productCount=productCount;
		generator = new GenerateRandomNumbers();
	}
	
	//Getter methods of attributes

	public int getQueuecount() {
		return queuecount;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public int getProductCount() {
		return productCount;
	}
	
	public long getProcessingTime() {
		return processingTime;
	}
	//setter method 
	
	public void setQueuecount(int queuecount) {
		this.queuecount = queuecount;
	}

	public void setProcessingTime(long totalWaitingTime) {
		this.processingTime = totalWaitingTime;
	}
	
	//to calculate lost customer count
	public static synchronized void increaseLostCustomers() {
		lostCustomers++;
	}
	//to retrieve the value of lost customers
	public static synchronized int getLostCustomers() {
		return lostCustomers;
	}
	
	@Override
	public void run() {
		
		boolean foundQueue = false;//variable is set to false initially
		while(!foundQueue)
		{
			
			for(Counter counter : Main.counters)//iterating through the counter list
			{
				synchronized (counter.getCustomers()) //locking the customer queue of each counter
				{
					if((counter.getCustomers().size() < 6))//check if the size of the queue is less than 6
					{
						if(counter.getCounterId()==1 && this.productCount<=5) {//for product count less than or equal to 5
							
								counter.getCustomers().add(this);//join the queue
								System.out.println( this.customerName+ " joined the Express Counter"+ " with "+ this.productCount+ " items");
								foundQueue = true;//variable true as the customer found a queue;
								counter.getCustomers().notifyAll();//notify other customer threads
								break;
							
						}
						else if(counter.getCounterId()!=1 && this.productCount>5){//for product count greater than 5
							
								counter.getCustomers().add(this);//join the queue
								System.out.println( this.customerName+ " joined the Checkout"+(counter.getCounterId()-1)+ " with "+ this.productCount+ " items");
								foundQueue = true;//variable true as the customer found a queue;
								counter.getCustomers().notifyAll();//notify other customer threads
								break;
							
						}
						
					}
					else
					{
						counter.getCustomers().notifyAll();//unlock the counter queue
						this.queuecount++;//increment variable if a queue is not found
						
					}
				
				}
			}
			
			if(this.queuecount == 7 && this.productCount>5)//if customer does not add himself into a any queues and this is for normal counter
			{
				Customer.increaseLostCustomers();//calculate lost customers
				
				
			}
			else if(this.queuecount == 1 && this.productCount<=5){ //if customer does not add himself into a any queues and this is for express counter
				Customer.increaseLostCustomers();//calculate lost customers
				
			}
			if(Customer.getLostCustomers()!=0) {
				Main.ui.getTextField_35().setText(Integer.toString(Customer.getLostCustomers()));//update UI
			}
			
			
		}
		
	
	}

	
}