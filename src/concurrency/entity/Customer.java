package concurrency.entity;

import concurrency.main.Main;
import concurrent.utility.CustomerGenerator;
import concurrent.utility.GenerateRandomNumbers;
//Customer Class
public class Customer implements Runnable{
	
	private static volatile int lostCustomers;
	private String customerName;//to store customer name
	private int productCount;//to store product count
	private int processingTime;//to calculate processing time for each customer
	private int queuecount;	
	
	GenerateRandomNumbers generator;//Create object reference for GenerateRandomNumbers
	CustomerGenerator c;
	public Customer() {
		//constructor to do the basic stuff
	}

	public Customer(String customerName,int productCount,int time) {//parameterized constructor
		this.customerName=customerName;
		this.productCount=productCount;
		this.processingTime=time;
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
	
	public int getProcessingTime() {
		return processingTime;
	}
	//setter method 
	public void setProcessingTime(int totalWaitingTime) {
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
						if(counter.getCounterId()==1 && this.productCount<=5) {
							
								counter.getCustomers().add(this);
								System.out.println( this.customerName+ " joined the Express Counter"+ " with "+ this.productCount+ " items");
								foundQueue = true;//variable true;
								counter.getCustomers().notifyAll();//notify other threads
								break;
							//join the queue
						}
						else if(counter.getCounterId()!=1 && this.productCount>5){
							
								counter.getCustomers().add(this);
								System.out.println( this.customerName+ " joined the Checkout"+(counter.getCounterId()-1)+ " with "+ this.productCount+ " items");
								foundQueue = true;//variable true;
								counter.getCustomers().notifyAll();//notify other threads
								break;
							
						}
						
					}
					else
					{
						counter.getCustomers().notifyAll();//doubt
						queuecount++;
					}
				
				}
			}
			if(queuecount == 8)
			{
				lostCustomers++;
				// this 
				break; // we break outer while loop since , the customer tried checking queues for 20 times
			}
			
		}
		if(lostCustomers!=0) {
			System.out.println(lostCustomers);
		}
	
	}

	
}