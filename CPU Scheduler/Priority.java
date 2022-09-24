/**
 * Non-preemptive priority scheduling algorithm.
 */
package CECS326_Project4;

import java.util.List;

public class Priority implements Algorithm
{
	private List<Task> tasks;
	
	public Priority(List<Task> tasks)
	{
		this.tasks = tasks;
	}
	
	/*
	 * Loops through the task list and removes that certain task as each task is ran.
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
	 * Picks the next task by sorting the tasks from smallest burst to largest burst.
	 */
	@Override
	public Task pickNextTask()
	{
		Task minTask = tasks.get(0);
		for(int i = 1; i < tasks.size(); i++)
		{
			if (minTask.getPriority() > tasks.get(i).getPriority())
			{
				minTask = tasks.get(i);
			}
		}
		
		return minTask;
	}
	
}