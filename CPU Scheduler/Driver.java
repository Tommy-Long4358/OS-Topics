/**
 * Driver.java

 * 
 * Demonstrates different scheduling algorithms.
 * 
 * Usage:
 *  
 *  java Driver <schedule> <algorithm>
 *
 * where 
 *  schedule is schedule of tasks
 *
 *  algorithm = [FCFS, SJF, PRI, RR, PRI-RR]
 */
package CECS326_Project4;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver
{
    public static void main(String[] args) throws IOException 
    {
    	args = new String[7];
    	
    	args[0] = "book.txt";
    	args[1] = "rr-schedule.txt";
    	args[2] = "1-sched.txt";
    	args[3] = "schedule.txt";
    	args[4] = "FCFS";
    	args[5] = "RR";
    	args[6] = "PRI";
    	
 
        if (args.length != 7) {
            System.err.println("Usage: java Driver <algorithm> <schedule> not found");
       
            System.exit(0);
        }
        
        BufferedReader inFile = new BufferedReader(new FileReader(args[3]));
        
        String schedule;

        // create the queue of tasks
        List<Task> queue = new ArrayList<Task>();

        // read in the tasks and populate the ready queue        
        while ( (schedule = inFile.readLine()) != null) {
            String[] params = schedule.split(",\\s*");
            queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
        }

        inFile.close();
        
        Algorithm scheduler = null;
        String choice = args[5].toUpperCase();

        switch(choice) {
	        case "FCFS":
	            scheduler = new FCFS(queue);
	            break;
	        case "PRI":
	            scheduler = new Priority(queue);
	            break;
	        case "RR":
	            scheduler = new RR(queue);
	            break;
	        default:
	            System.err.println("Invalid algorithm");
	            System.exit(0);
        }

        // start the scheduler
        scheduler.schedule();
    }
}
