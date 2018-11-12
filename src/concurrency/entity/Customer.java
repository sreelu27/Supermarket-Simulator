package concurrency.entity;

import concurrency.main.Main;
import concurrent.utility.CustomerGenerator;
import concurrent.utility.GenerateRandomNumbers;
//Customer Class
public class Customer implements Runnable{
	
	private static volatile int lostCustomers;//to store number of customers who left the shop
	private String customerName;//to store customer name
	private int productCount;//to store product count
	private long processingTime;//to calculate processing time for each customer
	private int queuecount;	//to calculate the check times of customers
	
	GenerateRandomNumbers generator;//Create object reference for GenerateRandomNumbers
	
	public Customer(String customerName,int productCount) {//parameterized constructor
		this.customerName=customerName;
		this.productCount=productCount;
		//this.processingTime=time;
		generator = new GenerateRandomNumbers();
	}
	public int getQueuecount() {
		return queuecount;
	}

	public void setQueuecount(int queuecount) {
		this.queuecount = queuecount;
	}

	//Getter methods of attributes


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
	public void setProcessingTime(long totalWaitingTime) {
		this.processingTime = totalWaitingTime;
	}
	
	@Override
	public void run() {
		
		boolean foundQueue = false;
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
								foundQueue = true;//variable true;
								counter.getCustomers().notifyAll();//notify other threads
								break;
							
						}
						else if(counter.getCounterId()!=1 && this.productCount>5){//for product count greater than 5
							
								counter.getCustomers().add(this);//join the queue
								System.out.println( this.customerName+ " joined the Checkout"+(counter.getCounterId()-1)+ " with "+ this.productCount+ " items");
								foundQueue = true;//variable true;
								counter.getCustomers().notifyAll();//notify other threads
								break;
							
						}
						
					}
					else
					{
						counter.getCustomers().notifyAll();//unlock the counter queue
						this.queuecount++;//increment variable if a queue is not found
						//System.out.println(this.queuecount);
					}
				
				}
			}
			//Main.ui.getTextField_35().setText(Integer.toString(0));
			if(this.queuecount == 7 && this.productCount>5)//if customer does not add himself into a any queues
			{
				lostCustomers++;//calculate lost customers
				Main.ui.getTextField_35().setText(Integer.toString(lostCustomers));//update UI
				break; // we break outer while loop since , the customer tried checking queues for 7 times
			}
			else if(this.queuecount == 1 && this.productCount<=5){
				lostCustomers++;//calculate lost customers
				Main.ui.getTextField_35().setText(Integer.toString(lostCustomers));//update UI
				break; // we break outer while loop since , the customer tried checking express counter for 1 time			}
			}
		}
		
	
	}

	
}