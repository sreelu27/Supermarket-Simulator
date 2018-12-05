package concurrency.entity;

import java.util.LinkedList;
import java.util.Queue;
import concurrency.main.Main;
import concurrent.utility.GenerateRandomNumbers;

//**********Author Sreelekshmi Geetha*********************
//*****Counter Threads are created here and each customers are processed in this class**************
public class Counter implements Runnable{
	
    private Queue<Customer> customers = new LinkedList<>();//customer queue
	private int counterId;//to store id of the counter
	private long totalWaitingTime;//waiting time of each customer
	private static long avg;//average number of products
	private static volatile long totalCustomersProcessed;//total customers processed 
	private static volatile long totalProductsProcessed;//total number of products processed
	private static volatile long totalTime;//total wait time of all the customers
	private static long avgTime;//average wait time of customer
	private static volatile double totalCustomers1;//total customers in counter1 
	private static volatile double totalCustomers2;//total customers in counter2 
	private static volatile double totalCustomers3;//total customers in counter3
	private static volatile double totalCustomers4;//total customers in counter4
	private static volatile double totalCustomers5;//total customers in counter5
	private static volatile double totalCustomers6;//total customers in counter6
	private static volatile double totalCustomers7;//total customers in counter7
	private static volatile double totalCustomers8;//total customers in counter8
	private static volatile int avgUtilization1;//to calculate utilization of counter 1
	private static volatile int avgUtilization2;//to calculate utilization of counter 2
	private static volatile int avgUtilization3;//to calculate utilization of counter 3
	private static volatile int avgUtilization4;//to calculate utilization of counter 4
	private static volatile int avgUtilization5;//to calculate utilization of counter 5
	private static volatile int avgUtilization6;//to calculate utilization of counter 6
	private static volatile int avgUtilization7;//to calculate utilization of counter 7
	private static volatile int avgUtilization8;//to calculate utilization of counter 8
	private GenerateRandomNumbers generator = new GenerateRandomNumbers();//instance of utility class GenerateRandomNumber
	
	//setters and getters
	
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
			synchronized (customers) {//lock the customer queue
				if(customers.size() == 0)//if queue size is zero
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
					
					customers.notify();		//unlock 		
				}			
			}
				
			int counterId = this.counterId;//to set the counter id
			// updating UI
			
			if(counterId==1) {
				Main.ui.getTextField().setText(Integer.toString(customers.size()));
			}
			else if(counterId==2) {
				Main.ui.getTextField_1().setText(Integer.toString(customers.size()));
			}
			else if(counterId==3) {
				Main.ui.getTextField_2().setText(Integer.toString(customers.size()));
			}
			else if(counterId==4) {
				Main.ui.getTextField_3().setText(Integer.toString(customers.size()));
			}
			else if(counterId==5) {
				Main.ui.getTextField_4().setText(Integer.toString(customers.size()));
			}
			else if(counterId==6) {
				Main.ui.getTextField_5().setText(Integer.toString(customers.size()));
			}
			else if(counterId==7) {
				Main.ui.getTextField_6().setText(Integer.toString(customers.size()));
			}
			else {
				Main.ui.getTextField_7().setText(Integer.toString(customers.size()));
			}
			
			frontCustomer = customers.poll();		// to pick the first customer	
			
			if( frontCustomer != null)
			{
				
				int prodCount = frontCustomer.getProductCount();//get product count
				totalWaitingTime=0;
				for(int i = 0; i < prodCount; i++)
				{
					totalProductsProcessed++;//increment total products
					double time = generator.getRandomNumberInRange(0.5, 6);//scan time of each product
					totalWaitingTime+=time;//calculate wait time for each customer
					frontCustomer.setProcessingTime(totalWaitingTime);
					totalTime+=totalWaitingTime;//calculate total wait time of all the customer
					try 
					{
						Thread.sleep((long) (time));
					}
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//update the console
				
				if(this.counterId==1) {
					
					System.out.println(frontCustomer.getCustomerName()+" checked out from the Express Counter in "+frontCustomer.getProcessingTime()+" milliseconds");
					totalCustomersProcessed++;//total number of customers processed
			
					
				}else {
					System.out.println(frontCustomer.getCustomerName()+" checked out from Checkout" +(this.counterId-1)+" in "+frontCustomer.getProcessingTime()+" milliseconds");
					totalCustomersProcessed++;//total number of customers processed
					
				}
				//update the UI
				if(counterId==1) {
					totalCustomers1++;//increment number of customers in counter1
					Main.ui.getTextField_9().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_17().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_27().setText(frontCustomer.getProductCount()+"");
					avgUtilization1 =(int) (((totalCustomers1)/(totalCustomersProcessed))*100);//calculate utilization of counter1
					Main.ui.getTextField_38().setText(Long.toString(avgUtilization1)+"%");
					
				}
				else if(counterId==2) {
					totalCustomers2++;//increment number of customers in counter2
					Main.ui.getTextField_8().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_18().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_28().setText(frontCustomer.getProductCount()+"");
					avgUtilization2 =(int) (((totalCustomers2)/(totalCustomersProcessed))*100);//calculate utilization of counter2
					Main.ui.getTextField_39().setText(Long.toString(avgUtilization2)+"%");
				}
				
				else if(counterId==3) {
					totalCustomers3++;//increment number of customers in counter3
					Main.ui.getTextField_10().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_19().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_29().setText(frontCustomer.getProductCount()+"");
					avgUtilization3 =(int) (((totalCustomers3)/(totalCustomersProcessed))*100);//calculate utilization of counter3
					Main.ui.getTextField_40().setText(Long.toString(avgUtilization3)+"%");
				}
				else if(counterId==4) {
					totalCustomers4++;//increment number of customers in counter4
					Main.ui.getTextField_11().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_20().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_30().setText(frontCustomer.getProductCount()+"");
					avgUtilization4 =(int) (((totalCustomers4)/(totalCustomersProcessed))*100);//calculate utilization of counter4
					Main.ui.getTextField_41().setText(Long.toString(avgUtilization4)+"%");
				}
				else if(counterId==5) {
					totalCustomers5++;//increment number of customers in counter5
					Main.ui.getTextField_12().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_21().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_31().setText(frontCustomer.getProductCount()+"");
					avgUtilization5 =(int) (((totalCustomers5)/(totalCustomersProcessed))*100);//calculate utilization of counter5
					Main.ui.getTextField_42().setText(Long.toString(avgUtilization5)+"%");
				}
				else if(counterId==6) {
					totalCustomers6++;//increment number of customers in counter6
					Main.ui.getTextField_13().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_22().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_32().setText(frontCustomer.getProductCount()+"");
					avgUtilization6 =(int) (((totalCustomers6)/(totalCustomersProcessed))*100);//calculate utilization of counter6
					Main.ui.getTextField_43().setText(Long.toString(avgUtilization6)+"%");
				}
				else if(counterId==7) {
					totalCustomers7++;//increment number of customers in counter7
					Main.ui.getTextField_14().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_23().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_33().setText(frontCustomer.getProductCount()+"");
					avgUtilization7 =(int) (((totalCustomers7)/(totalCustomersProcessed))*100);//calculate utilization of counter7
					Main.ui.getTextField_44().setText(Long.toString(avgUtilization7)+"%");
				}
				else if(counterId==8) {
					totalCustomers8++;//increment number of customers in counter8
					Main.ui.getTextField_15().setText(frontCustomer.getProcessingTime()+" "+"ms");
					Main.ui.getTextField_24().setText(frontCustomer.getCustomerName());
					Main.ui.getTextField_34().setText(frontCustomer.getProductCount()+"");
					avgUtilization8 =(int) (((totalCustomers8)/(totalCustomersProcessed))*100);//calculate utilization of counter8
					Main.ui.getTextField_45().setText(Long.toString(avgUtilization8)+"%");
				}
				Main.ui.getTextField_25().setText(Long.toString(totalCustomersProcessed));//display ui total number of customers successfully processed
				Main.ui.getTextField_26().setText(Long.toString(totalProductsProcessed));//display in ui total number of products processed

                avg=totalProductsProcessed/totalCustomersProcessed;//calculate average products per trolley assuming each customer has one trolley
                Main.ui.getTextField_36().setText(Long.toString(avg)+" units");//update UI
                
				avgTime=(totalTime/totalCustomersProcessed)/1000;//calculate average wait time of customers
				Main.ui.getTextField_37().setText(Long.toString(avgTime)+ " secs");//update UI
				
				
				
				
			}
			
			
			
		}
		
	}

	
	
	

}