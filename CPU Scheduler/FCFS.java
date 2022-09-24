/**
 * FCFS scheduling algorithm.
 */
package CECS326_Project4;

import java.util.ArrayList;
import java.util.List;

public class FCFS implements Algorithm
{
	private List<Task> tasks = new ArrayList<Task>();
	
	public FCFS(List<Task> tasks)
	{
		this.tasks = tasks;
		
	}

	/*
	 * Assigns the next task and runs the task with the CPU class. Removes the task after the task is ran.
	 * 
	 */
	@Override
	public void schedule()
	{
		while(tasks.size() != 0)
		{
			
			Task task = pickNextTask();
			CPU.run(task, task.getBurst());
			System.out.println(task.getName() + " is finished.\n");
			
			tasks.remove(task);
		}
	}
	
	/*
	 * Picks the next task from a list of tasks. Since removal is happening everytime in schedule, 
	 * the indexes of the shifts are shifted so index 0 is always given.
	 */
	@Override
	public Task pickNextTask()
	{
		return tasks.get(0);
	}
	
}