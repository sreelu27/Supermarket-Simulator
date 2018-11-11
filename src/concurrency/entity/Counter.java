package concurrency.entity;

import java.util.LinkedList;
import java.util.Queue;
import concurrency.main.Main;
import concurrent.utility.GenerateRandomNumbers;

public class Counter implements Runnable{
	
	private Queue<Customer> customers = new LinkedList<>();
	private int counterId;
	private int totalWaitingTime;
	private long totalTime;
	private long custCount;
	private long avg;
	private static volatile int totalCustomersProcessed;
	private int totalProductsProcessed;
	private static volatile int totalProductsProcessed_whole;
	private GenerateRandomNumbers generator = new GenerateRandomNumbers();
	
	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}
	
	public Queue<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Queue<Customer> customers) {
		this.customers = customers;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {
			Customer frontCustomer = null;
			synchronized (customers) {
				if(customers.size() == 0)
				{
					try
					{
						customers.wait();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				else
				{					
					
					customers.notifyAll();	
				}				
			}
			frontCustomer = customers.poll();			
			int counterId = this.counterId;
			// updating UI
			
			if(counterId==1) {
				Main.ui.getTextField().setText(""+customers.size());
			}
			else if(counterId==2) {
				Main.ui.getTextField_1().setText(""+customers.size());
			}
			else if(counterId==3) {
				Main.ui.getTextField_2().setText(""+customers.size());
			}
			else if(counterId==4) {
				Main.ui.getTextField_3().setText(""+customers.size());
			}
			else if(counterId==5) {
				Main.ui.getTextField_4().setText(""+customers.size());
			}
			else if(counterId==6) {
				Main.ui.getTextField_5().setText(""+customers.size());
			}
			else if(counterId==7) {
				Main.ui.getTextField_6().setText(""+customers.size());
			}
			else {
				Main.ui.getTextField_7().setText(""+customers.size());
			}
			
			if( frontCustomer != null)
			{
				
				this.custCount++;
				int prodCount = frontCustomer.getProductCount();
				this.totalProductsProcessed+=prodCount;
				for(int i = 0; i < prodCount; i++)
				{
					totalProductsProcessed_whole++;
					int time = generator.getRandomNumberInRange(1, 5);
					//System.out.println(time);
					totalWaitingTime+=time;
					frontCustomer.setProcessingTime(totalWaitingTime);
					this.totalTime+=time;
					try 
					{
						Thread.sleep(time*2);
					}
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				
				
				
				//update console
				if(this.counterId==1) {
					System.out.println(frontCustomer.getCustomerName()+" checked out from the Express Counter in "+this.totalWaitingTime+" milliseconds");
					totalCustomersProcessed++;
					
				}else {
					System.out.println(frontCustomer.getCustomerName()+" checked out from Checkout" +(this.counterId-1)+" in "+this.totalWaitingTime+" milliseconds");
					totalCustomersProcessed++;
				}
				
				//update UI
				if(counterId==1) {
					Main.ui.getTextField_9().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_17().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_27().setText(this.avg+"");
				}
				else if(counterId==2) {
					Main.ui.getTextField_8().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_18().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_28().setText(this.avg+"");
				}
				else if(counterId==3) {
					Main.ui.getTextField_10().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_19().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_29().setText(this.avg+"");
				}
				else if(counterId==4) {
					Main.ui.getTextField_11().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_20().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_30().setText(this.avg+"");
				}
				else if(counterId==5) {
					Main.ui.getTextField_12().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_21().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_31().setText(this.avg+"");
				}
				else if(counterId==6) {
					Main.ui.getTextField_13().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_22().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_32().setText(this.avg+"");
				}
				else if(counterId==7) {
					Main.ui.getTextField_14().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_23().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_33().setText(this.avg+"");
				}
				else if(counterId==8) {
					Main.ui.getTextField_15().setText(frontCustomer.getCustomerName()+" :"+this.totalWaitingTime+" milliseconds");
					Main.ui.getTextField_24().setText(this.totalProductsProcessed+"");
					this.avg=this.totalTime/this.custCount;
					Main.ui.getTextField_34().setText(this.avg+"");
				}

				Main.ui.getTextField_25().setText(totalCustomersProcessed+"");
				Main.ui.getTextField_26().setText(totalProductsProcessed_whole+"");


					
			}
			
			
			
		}
		
	}

	
	
	

}