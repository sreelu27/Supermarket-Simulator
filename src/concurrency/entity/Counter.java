package concurrency.entity;

import java.util.LinkedList;
import java.util.Queue;
import concurrency.main.Main;
import concurrent.utility.GenerateRandomNumbers;

public class Counter implements Runnable{
	
	private Queue<Customer> customers = new LinkedList<>();
	private int counterId;
	private long totalWaitingTime;
	private static long avg;
	private static volatile long totalCustomersProcessed;
	private static volatile long totalProductsProcessed;
	private static volatile long totalTime;
	private static long avgTime;
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

	@Override
	public void run() {
		while (true) {
			Customer frontCustomer = null;
			synchronized (customers) {
				if(customers.size() == 0)
				{
					try
					{
						customers.wait();//if no customers arrived in the checkout wait
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				else
				{					
					
					customers.notifyAll();
				}				
			}
			frontCustomer = customers.poll();		// to pick the first customer	
			int counterId = this.counterId;//to set the counter id
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
				
				int prodCount = frontCustomer.getProductCount();
				totalWaitingTime=0;
				for(int i = 0; i < prodCount; i++)
				{
					totalProductsProcessed++;
					long time = generator.getRandomNumberInRange(1, 5);
					totalWaitingTime+=time;//calculate wait time for each customer
					frontCustomer.setProcessingTime(totalWaitingTime);
					totalTime+=totalWaitingTime;//calculate total wait time of all the customer
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
					System.out.println(frontCustomer.getCustomerName()+" checked out from the Express Counter in "+frontCustomer.getProcessingTime()+" milliseconds");
					totalCustomersProcessed++;
					
				}else {
					System.out.println(frontCustomer.getCustomerName()+" checked out from Checkout" +(this.counterId-1)+" in "+frontCustomer.getProcessingTime()+" milliseconds");
					totalCustomersProcessed++;
				}
				
				//update UI
				if(counterId==1) {
					Main.ui.getTextField_9().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_17().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_27().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==2) {
					Main.ui.getTextField_8().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_18().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_28().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==3) {
					Main.ui.getTextField_10().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_19().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_29().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==4) {
					Main.ui.getTextField_11().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_20().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_30().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==5) {
					Main.ui.getTextField_12().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_21().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_31().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==6) {
					Main.ui.getTextField_13().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_22().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_32().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==7) {
					Main.ui.getTextField_14().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_23().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_33().setText(frontCustomer.getProductCount()+"");
				}
				else if(counterId==8) {
					Main.ui.getTextField_15().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_24().setText(frontCustomer.getCustomerName());
					
					Main.ui.getTextField_34().setText(frontCustomer.getProductCount()+"");
				}

				Main.ui.getTextField_25().setText(totalCustomersProcessed+"");//display ui total number of customers successfully processed
				Main.ui.getTextField_26().setText(totalProductsProcessed+"");//display in ui total number of products processed

                avg=totalProductsProcessed/totalCustomersProcessed;
                Main.ui.getTextField_36().setText(avg+"");//calculate average products per trolley assuming each customer has one trolley
                
				avgTime=totalTime/totalCustomersProcessed;
				Main.ui.getTextField_37().setText(avgTime+"");//calculate average wait time of customers
			}
			
			
			
		}
		
	}

	
	
	

}