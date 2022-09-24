/**
 * Philosopher.java

 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */


public class Philosopher implements Runnable
{
	
	/* The number of the philosopher. */
	private int philNumber; 
	
	/* The table that the philosopher will eat in. */
	private DiningServerImpl table;
	
	// Philosopher constructor
	public Philosopher(int philNumber, DiningServerImpl table)
	{
		this.philNumber = philNumber;
		this.table = table;
	}
	
	// Run method for the thread.
	@Override
	public void run() 
	{
		do
		{
			try 
			{
				// Philosopher will eat.
				table.takeForks(philNumber);
					
				// Philosopher will wait.
				Thread.sleep(2200);
			
				// Philosopher is done eating.
				table.returnForks(philNumber);
				
				
				Thread.sleep(1900);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while(true);
	}
}

