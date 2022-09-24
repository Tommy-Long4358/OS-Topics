/**
 * DiningServer.java

 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl  implements DiningServer
{
	// States that the philosopher can be in at any given point.
	enum PhilosopherStates {
		THINKING, HUNGRY, EATING
	};
	
	Lock mutex = new ReentrantLock();
	private Condition [] self = new Condition[5];
	private PhilosopherStates [] states = new PhilosopherStates[5];
	
	public DiningServerImpl()
	{
		for(int i = 0; i < 5; i++)
		{
			self[i] = mutex.newCondition();
			states[i] = PhilosopherStates.THINKING;
		}
	}
	
	@Override
	public void takeForks(int philNumber)
	{
		mutex.lock();
		try
		{
			states[philNumber] = PhilosopherStates.HUNGRY;
			System.out.println("Philosopher " + (philNumber) + " is hungry...");
			
			test(philNumber);
		
			if (states[philNumber] != PhilosopherStates.EATING)
			{
				self[philNumber].await(); 
			}
			
			
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mutex.unlock();
	}
	
	@Override
	public void returnForks(int philNumber)
	{
		mutex.lock();
		states[philNumber] = PhilosopherStates.THINKING;
		System.out.println("Philosopher " + (philNumber) + " is thinking...");
		
		// test left and right neighbors
		test((philNumber + 4) % 5);
		test((philNumber + 1) % 5);
		
		
		mutex.unlock();
		
	}
	
	public void test(int philNumber)
	{
		if ((states[(philNumber + 4) % 5] != PhilosopherStates.EATING) &&
				(states[philNumber] == PhilosopherStates.HUNGRY) && 
						(states[(philNumber + 1) % 5] != PhilosopherStates.EATING)) 
		{
		
			states[philNumber] = PhilosopherStates.EATING;
			System.out.println("Philosopher " + (philNumber) + " is eating...");
			
			self[philNumber].signal();
		}
	}
}
