import java.util.concurrent.locks.Lock;

public class WestVillage implements Runnable
{
	// Int variable to identify a certain villager from the West Village.
	private int villagerNumber;
	
	// Lock to represent the road the villager will travel on.
	private Lock road;
	
	// West Village constructor.
	public WestVillage(int villagerNumber, Lock road)
	{
		this.villagerNumber = villagerNumber;
		this.road = road;
	}
	
	// Run method to run a thread.
	@Override
	public void run() 
	{
		// Lock the road to show that it is in use currently.
		road.lock();
		
		// Critical Section
		try 
		{
			// Chooses an action a villager can do on the road.
			int actionChoice = (int)(Math.random() * 3) + 1;
			
			System.out.println("West Villager " + villagerNumber + " is on the road...");
			
			if (actionChoice == 1)
			{
				System.out.println("West Villager " + villagerNumber + " is eating a donut...");
				Thread.sleep(2200);
			}
			else if (actionChoice == 2)
			{
				System.out.println("West Villager " + villagerNumber + " is looking at the river...");
				Thread.sleep(2400);
			}
			else
			{
				System.out.println("West Villager " + villagerNumber + " is picking up fruits from a tree...");
				Thread.sleep(1800);
			}
			
			System.out.println("West Villager " + villagerNumber + " has exited the road...");
			Thread.sleep(2000);
			
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		road.unlock();
	}

}
