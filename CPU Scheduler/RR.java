/**
 * Non-preemptive priority scheduling algorithm using RR.

 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
package CECS326_Project4;

import java.util.List;

// Your code here
public class RR implements Algorithm
{
	private List<Task> tasks;
	private int size = 0;
	
	public RR(List<Task> tasks)
	{
		this.tasks = tasks;
		
	}
	
	/*
	 * Runs a given task, subtracts the burst by the time quantum, 10 
	 * and removes the task when a task's burst is at 0.
	 */
	@Override
	public void schedule()
	{
		Task task = tasks.get(size);
		while (true)
		{
			CPU.run(task, task.getBurst());
			int burst = task.getBurst() - 10;
			
			// Remove a task once its burst is less than or equal to 0.
			if (burst <= 0)
			{
				System.out.println(task.getName() + " is finished.\n");
				tasks.remove(task);
				
				// Exit the loop once the size of the task list is at 0.
				if (tasks.size() == 0)
				{
					break;
				}
			}
			else
			{
				size += 1;
			}
			
			// If burst isn't at 0 yet, we set the burst as the new burst value
			task.setBurst(burst);
			
			// Picks the next task.
			task = pickNextTask();
		}
		
	}
	
	/*
	 * Picks the next task by increasing the size + 1 each time. Resets to 0 if it is at the total task size limit.
	 */
	@Override
	public Task pickNextTask()
	{	
		// If size exceeds task list index, we reset the size to 0 to cycle back to the 0th index.
		if (size == tasks.size())
		{
			size = 0;
		}
		
		return tasks.get(size);
	}
}