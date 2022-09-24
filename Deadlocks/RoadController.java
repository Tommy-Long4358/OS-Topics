import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoadController {

	public static void main(String[] args) 
	{
		// Lock variable to represent the road the two villages will use to cross.
		Lock road = new ReentrantLock();
	
		// An array of EastVillage objects to be our threads.
		EastVillage [] eastVillagers = new EastVillage[5];
		
		// An array of WestVillage objects to be our threads.
		WestVillage [] westVillagers = new WestVillage[5];
		
		
		// Initialize each element in both arrays with a villager number and the road lock.
		for(int i = 0; i < 5; i++)
		{
			eastVillagers[i] = new EastVillage(i + 1, road);
			westVillagers[i] = new WestVillage(i + 1, road);
		}
		
		// Chooses random villagers and runs that specific thread.
		for(int i = 0; i < 5; i++)
		{
			int randomVillager = (int)(Math.random() * 4);
			new Thread(eastVillagers[randomVillager]).start();
			
			randomVillager = (int)(Math.random() * 4);
			new Thread(westVillagers[randomVillager]).start();
			
		}
	}

}
