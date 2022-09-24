/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */

public class DiningPhilosophers
{  
   public static void main(String args[])
   {
	 // Object of the DiningServer table.
     DiningServerImpl table = new DiningServerImpl();
     
     // Number of philosophers currently involved in the table
     Philosopher [] philosophers = new Philosopher[5];
     
     for (int i = 0; i < 5; i++)
     {
    	 philosophers[i] = new Philosopher(i, table);
    	 
    	 // Start the execution of the dining philosopher.
    	 new Thread(philosophers[i]).start();
     }
   }
}
